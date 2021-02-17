package com.epam.task.fourth.validation;

import com.epam.task.fourth.parsing.ParsingException;
import com.epam.task.fourth.parsing.SaxParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.net.URL;


public class XmlValidator {

    private static final URL SCHEMA_XSD = XmlValidator.class.getResource("/candiesSchema.xsd");
    private static final Logger LOGGER = LogManager.getLogger();

    public boolean isValid(String filename) {
        Schema schema;
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            schema = factory.newSchema(SCHEMA_XSD);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);

            SaxParser parser = new SaxParser();
            parser.parse(filename);
            return true;

        } catch (Exception e) {
            try {
                throw new ParsingException("Parsing exception");
            } catch (ParsingException ex) {
                ex.printStackTrace();
                LOGGER.error(filename + " config error: " + e.getMessage(), e);
                return false;
            }

        }

    }

}
