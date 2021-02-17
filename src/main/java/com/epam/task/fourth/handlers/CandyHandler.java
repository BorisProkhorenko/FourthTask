package com.epam.task.fourth.handlers;

import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.entity.CaramelCandy;
import com.epam.task.fourth.entity.ChocolateCandy;
import com.epam.task.fourth.enums.CandyEnum;
import com.epam.task.fourth.enums.CaramelType;
import com.epam.task.fourth.enums.ChocolateType;
import com.epam.task.fourth.parsing.ParsingException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class CandyHandler extends DefaultHandler {

    private List<Candy> candies;
    private Candy current;
    private CandyEnum currentEnum;


    public CandyHandler() {
        candies = new ArrayList<>();
    }

    public List<Candy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (localName) {
            case "chocolate-candy":
                current = new ChocolateCandy();
                current.setId(attributes.getValue(0));
                break;
            case "caramel-candy":
                current = new CaramelCandy();
                current.setId(attributes.getValue(0));
                break;
            default:
                currentEnum = CandyEnum.valueOf(localName.toUpperCase());
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("chocolate-candy".equals(localName) || "caramel-candy".equals(localName)) {
            candies.add(current);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String elementString = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case CANDIES:
                    break;
                case NAME:
                    current.setName(elementString);
                    break;
                case ENERGY:
                    current.setEnergy(Double.parseDouble(elementString));
                    break;
                case CARAMEL:
                    CaramelCandy caramelCandy = (CaramelCandy) current;
                    setCaramelType(caramelCandy, elementString);
                    current = caramelCandy;
                    break;
                case CHOCOLATE:
                    ChocolateCandy chocolateCandy = (ChocolateCandy) current;
                    setChocolateType(chocolateCandy, elementString);
                    current = chocolateCandy;
                    break;
                default:
                    try {
                        throw new ParsingException("Error in xml");
                    } catch (ParsingException e) {
                        e.printStackTrace();
                    }
            }
        }
        currentEnum = null;
    }

    private void setCaramelType(CaramelCandy candy, String caramelTypeStr) {
        switch (caramelTypeStr) {
            case "SOFT":
                candy.setCaramelType(CaramelType.SOFT);
                break;
            case "LOLLIPOP":
                candy.setCaramelType(CaramelType.LOLLIPOP);
                break;
        }

    }

    private void setChocolateType(ChocolateCandy candy, String chocolateTypeStr) {
        switch (chocolateTypeStr) {
            case "MILK":
                candy.setChocolateType(ChocolateType.MILK);
                break;
            case "BITTER":
                candy.setChocolateType(ChocolateType.BITTER);
                break;
            case "WHITE":
                candy.setChocolateType(ChocolateType.WHITE);
                break;
        }
    }
}
