package com.epam.task.fourth.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "TypeOfChocolate", namespace = "urn:Test.Namespace")
@XmlEnum
public enum ChocolateType {
    @XmlEnumValue("MILK")
    MILK,
    @XmlEnumValue("BITTER")
    BITTER,
    @XmlEnumValue("WHITE")
    WHITE;

    public String value() {
        return name();
    }

    public static ChocolateType fromValue(String v) {
        return valueOf(v);
    }
}
