package ru.tinkoff.edu.java.parser;

public abstract class Parser {

    private final Parser next;

    public Parser(Parser next) {
        this.next = next;
    }

    public abstract String[] doParse(String URL);

    public Parser getNext() {
        return next;
    }
}
