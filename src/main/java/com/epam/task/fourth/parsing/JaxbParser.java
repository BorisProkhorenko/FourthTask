package com.epam.task.fourth.parsing;

import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.factories.Candies;
import com.epam.task.fourth.handlers.JaxbEventHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JaxbParser implements Parser {
    private static final URL SCHEMA_XSD = JaxbParser.class.getResource("/candiesSchema.xsd");

    @Override
    public List<Candy> parse(String filename) {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Candies.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = factory.newSchema(SCHEMA_XSD);
            unmarshaller.setSchema(schema);
            ValidationEventHandler validationEventHandler = new JaxbEventHandler();

            unmarshaller.setEventHandler(validationEventHandler);

            Candies candies = (Candies) unmarshaller.unmarshal(new File(filename));
            List<Candy> candyList = parseCandies(candies.getCandyJaxbElementList());
            return candyList;
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Candy> parseCandies(List<JAXBElement<? extends Candy>> candyList) throws JAXBException {
        List<Candy> candies = new ArrayList<>();
        for (JAXBElement element : candyList) {
            Candy candy = (Candy) element.getValue();
            candies.add(candy);
        }
        return candies;
    }

}
