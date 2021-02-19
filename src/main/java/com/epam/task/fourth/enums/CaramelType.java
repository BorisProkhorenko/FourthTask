package com.epam.task.fourth.enums;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "TypeOfCaramel", namespace = "urn:Test.Namespace")
@XmlEnum
public enum  CaramelType {
    @XmlEnumValue("LOLLIPOP")
    LOLLIPOP,
    @XmlEnumValue("SOFT")
    SOFT;

    public String value() {
        return name();
    }

    public static CaramelType fromValue(String v) {
        return valueOf(v);
    }
}
