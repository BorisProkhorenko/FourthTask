package com.epam.task.fourth.parsing;

import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.handlers.CandyHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Candy> parse(String filename) {
        CandyHandler candyHandler = new CandyHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(candyHandler);
            reader.parse(filename);
        } catch (SAXException | IOException e) {
            LOGGER.error("Parsing error ", e);
        }

        return candyHandler.getCandies();

    }

}

