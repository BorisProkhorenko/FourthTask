package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Candy", namespace = "urn:Test.Namespace", propOrder = {
        "name",
        "energy"
})
@XmlSeeAlso({
        ChocolateCandy.class,
        CaramelCandy.class
})

public abstract class Candy {

    @XmlAttribute()
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlElement(name = "name", namespace = "urn:Test.Namespace", required = true)
    protected String name;
    @XmlElement(name = "energy", namespace = "urn:Test.Namespace", required = true)
    @XmlSchemaType(name = "double", namespace = "urn:Test.Namespace")
    protected double energy;

    public Candy() {
    }

    public Candy(String id, String name, double energy) {
        this.id = id;
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Candy)) {
            return false;
        }
        Candy candy = (Candy) o;
        return Double.compare(candy.energy, energy) == 0 &&
                Objects.equals(id, candy.id) &&
                Objects.equals(name, candy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, energy);
    }
}
