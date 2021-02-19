package com.epam.task.fourth.collections;

import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.entity.CaramelCandy;
import com.epam.task.fourth.entity.ChocolateCandy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Candy_QNAME =
            new QName("urn:Test.Namespace", "candyList");
    private final static QName _Chocolate_Candy_QNAME =
            new QName("urn:Test.Namespace", "chocolate-candy");
    private final static QName _Caramel_Candy_QNAME =
            new QName("urn:Test.Namespace", "caramel-candy");

    public ObjectFactory() {
    }

    public Candies createCandies() {
        return new Candies();
    }

    public ChocolateCandy createChocolateCandy() {
        return new ChocolateCandy();
    }

    public CaramelCandy createCaramelCandy() {
        return new CaramelCandy();
    }

    @XmlElementDecl(namespace = "urn:Test.Namespace", name = "candyList")
    public JAXBElement<Candy> createCandyList(Candy value) {
        return new JAXBElement<>(_Candy_QNAME, Candy.class, null, value);
    }

    @XmlElementDecl(namespace = "urn:Test.Namespace", name = "chocolate-candy",
            substitutionHeadNamespace = "urn:Test.Namespace",
            substitutionHeadName = "candyList")
    public JAXBElement<ChocolateCandy> createChocolateCandy(ChocolateCandy value) {
        return new JAXBElement<>(_Chocolate_Candy_QNAME, ChocolateCandy.class, null, value);
    }

    @XmlElementDecl(namespace = "urn:Test.Namespace", name = "caramel-candy",
            substitutionHeadNamespace = "urn:Test.Namespace",
            substitutionHeadName = "candyList")
    public JAXBElement<CaramelCandy> createCaramelCandy(CaramelCandy value) {
        return new JAXBElement<>(_Caramel_Candy_QNAME, CaramelCandy.class, null, value);
    }


}
