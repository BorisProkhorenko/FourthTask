package com.epam.task.fourth.entity;

import com.epam.task.fourth.enums.CaramelType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Caramel", namespace = "urn:Test.Namespace", propOrder = {"caramelType"})
public class CaramelCandy extends Candy {
    @XmlElement(name = "caramel", namespace = "urn:Test.Namespace", required = true)
    protected CaramelType caramelType;

    public CaramelCandy() {

    }

    public CaramelCandy(String id, String name, double energy, CaramelType caramelType) {
        super(id,name, energy);
        this.caramelType = caramelType;
    }

    public CaramelType getCaramelType() {
        return caramelType;
    }

    public void setCaramelType(CaramelType caramelType) {
        this.caramelType = caramelType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CaramelCandy)) {
            return false;
        }
        if (!super.equals(o)) return false;
        CaramelCandy that = (CaramelCandy) o;
        return getCaramelType() == that.getCaramelType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCaramelType());
    }

    @Override
    public String toString() {
        return "CaramelCandy{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() +
                ", energy=" + getEnergy() +
                ", caramelType=" + caramelType +
                '}';
    }
}
