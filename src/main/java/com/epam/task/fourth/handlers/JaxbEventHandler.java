package com.epam.task.fourth.handlers;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class JaxbEventHandler implements ValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        throw new RuntimeException(event.getMessage(),
                event.getLinkedException());
    }
}
