package com.epam.task.fourth.parsing;

import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.handlers.CandyHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    @Override
    public List<Candy> parse(String filename) {
        CandyHandler candyHandler = new CandyHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(candyHandler);
            reader.parse(filename);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return candyHandler.getCandies();

    }

}

