package com.epam.task.fourth.parsing;

import com.epam.task.fourth.entity.Candy;

import java.util.List;

public interface Parser {

    List<Candy> parse(String filename);
}
