package com.epam.task.fourth.parsing;

public class ParsingException extends Throwable {
    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParsingException(String message) {
        super(message);
    }
}
