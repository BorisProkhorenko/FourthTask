package com.epam.task.fourth.factories;

import com.epam.task.fourth.entity.Candy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", namespace = "urn:Test.Namespace", propOrder = {
        "candyList"
})
@XmlRootElement(namespace = "urn:Test.Namespace", name = "Candies")
public class Candies {

    @XmlElementRef(name = "candyList", namespace = "urn:Test.Namespace", type =
            JAXBElement.class)
    protected List<JAXBElement<? extends Candy>> candyList;

    public List<JAXBElement<? extends Candy>> getCandyJaxbElementList() {
        if (candyList == null) {
            candyList = new ArrayList<>();
        }
        return this.candyList;
    }

}


