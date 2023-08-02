package ${classSpecification.packageName()};

import java.util.Objects;
import com.github.javafaker.Faker;

public class ${classSpecification.builderSimpleClassName()} {

private ${classSpecification.simpleClassName()} object = new ${classSpecification.simpleClassName()}();
private Faker faker = new Faker();

    public ${classSpecification.simpleClassName()} build() {
        return object;
    }

    <#list classSpecification.fields() as field>
    public ${classSpecification.builderSimpleClassName()} ${field.name()}(${field.type()} value) {
        object.${field.name()}(value);
        return this;
    }
    </#list>

    public ${classSpecification.builderSimpleClassName()} fromObject(${classSpecification.simpleClassName()} object) {
        ${classSpecification.builderSimpleClassName()} builder = new ${classSpecification.builderSimpleClassName()}();
    <#list classSpecification.fields() as field>
    <#assign fieldName = field.name()>
    <#assign getterName = fieldName?replace("^set", "get","r")>
        builder.${field.name()}(object.${getterName}());
    </#list>
    return builder;
    }

    public ${classSpecification.builderSimpleClassName()} buildNullModel() {
    <#list classSpecification.fields() as field>
    <#assign randomValue = ''>
    <#if field.type() == 'java.lang.String'>
    <#assign randomValue = "null">
    <#elseif field.type() == 'int'>
    <#assign randomValue = "0">
    <#elseif field.type() == 'boolean'>
    <#assign randomValue = "false">
    <#elseif field.type() == 'float'>
    <#assign randomValue = "0.0f">
    <#elseif field.type() == 'double'>
    <#assign randomValue = "0.0d">
    <#else>
    <#-- For other types, assume it's a complex object (class) -->
    <#assign fieldName = field.name()>
    <#assign randomValue = "null">
    </#if>
        object.${field.name()}(${randomValue});
    </#list>
    return this;
    }

    public ${classSpecification.builderSimpleClassName()} randomize() {
    <#list classSpecification.fields() as field>
    <#assign randomValue = ''>
    <#if field.type() == 'java.lang.String'>
    <#assign randomValue = "faker.lorem().characters(faker.random().nextInt(5, 15))">
    <#elseif field.type() == 'int'>
    <#assign randomValue = "faker.random().nextInt(5, 15)">
    <#elseif field.type() == 'boolean'>
    <#assign randomValue = "faker.bool().bool()">
    <#elseif field.type() == 'float'>
    <#assign randomValue = "faker.number().randomDouble(2, 0, 100).floatValue()">
    <#elseif field.type() == 'double'>
    <#assign randomValue = "faker.number().randomDouble(2, 0, 100)">
    <#else>
    <#-- For other types, assume it's a complex object (class) -->
    <#assign fieldName = field.name()>
    <#assign customObject = fieldName?replace("^set", "","r")?cap_first>
    <#assign randomValue = "new ${customObject}Builder().randomize().build()">
    </#if>
        object.${field.name()}(${randomValue});
    </#list>
    return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ${classSpecification.builderSimpleClassName()} builder = (${classSpecification.builderSimpleClassName()}) o;
        return Objects.equals(object, builder.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    @Override
    public String toString() {
    return "Builder{" +
        "object=" + object +
        '}';
    }
}
