package com.epam.task.fourth.parsing;

import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.entity.CaramelCandy;
import com.epam.task.fourth.entity.ChocolateCandy;
import com.epam.task.fourth.enums.CaramelType;
import com.epam.task.fourth.enums.ChocolateType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.security.pkcs.ParsingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    private static final String CARAMEL_CANDY = "caramel-candy";
    private static final String CHOCOLATE_CANDY = "chocolate-candy";
    private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Candy> parse(String filename) {
        List<Candy> candies = new ArrayList<>();
        try {
            addToListByTagName(candies, filename, CARAMEL_CANDY);
            addToListByTagName(candies, filename, CHOCOLATE_CANDY);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            LOGGER.error("Parsing error ", e);
        }

        return candies;
    }

    private void addToListByTagName(List<Candy> candies, String filename, String tagName)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(filename);
        Element root = doc.getDocumentElement();
        NodeList candiesList = root.getElementsByTagName(tagName);
        for (int i = 0; i < candiesList.getLength(); i++) {
            Element candyElement = (Element) candiesList.item(i);
            Candy candy = buildCandy(candyElement, tagName);
            candies.add(candy);
        }
    }


    private Candy buildCandy(Element candyElement, String candyType) throws ParsingException {
        double energy;
        switch (candyType) {
            case "chocolate-candy":
                ChocolateCandy chocolateCandy = new ChocolateCandy();
                chocolateCandy.setId(candyElement.getAttribute("id"));
                chocolateCandy.setName(getElementTextContent(candyElement, "name"));
                energy = Double.valueOf(getElementTextContent(candyElement, "energy"));
                chocolateCandy.setEnergy(energy);
                String chocolateTypeStr = getElementTextContent(candyElement, "chocolate");
                ChocolateType chocolateType = ChocolateType.valueOf(chocolateTypeStr);
                chocolateCandy.setChocolateType(chocolateType);
                return chocolateCandy;

            case "caramel-candy":
                CaramelCandy caramelCandy = new CaramelCandy();
                caramelCandy.setId(candyElement.getAttribute("id"));
                caramelCandy.setName(getElementTextContent(candyElement, "name"));
                energy = Double.valueOf(getElementTextContent(candyElement, "energy"));
                caramelCandy.setEnergy(energy);
                String caramelTypeStr = getElementTextContent(candyElement, "caramel");
                CaramelType caramelType = CaramelType.valueOf(caramelTypeStr);
                caramelCandy.setCaramelType(caramelType);
                return caramelCandy;

            default:
                throw new ParsingException("Unreachable exception");
        }
    }


    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
