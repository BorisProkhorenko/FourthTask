package com.epam.task.fourth.entity;

import com.epam.task.fourth.enums.ChocolateType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Chocolate", namespace = "urn:Test.Namespace")
public class ChocolateCandy extends Candy {

    @XmlElement(name = "chocolate", namespace = "urn:Test.Namespace", required = true)
    protected ChocolateType chocolateType;

    public ChocolateCandy() {
    }

    public ChocolateCandy(String id, String name, double energy, ChocolateType chocolateType) {
        super(id, name, energy);
        this.chocolateType = chocolateType;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChocolateCandy)) {
            return false;
        }
        if (!super.equals(o)) return false;
        ChocolateCandy that = (ChocolateCandy) o;
        return getChocolateType() == that.getChocolateType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getChocolateType());
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", energy=" + getEnergy() +
                ", chocolateType=" + chocolateType +
                '}';
    }
}
