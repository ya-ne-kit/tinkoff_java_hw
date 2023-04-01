package ru.tinkoff.edu.java.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackOverFlowParser extends Parser {


    private final String REGEX = "https?://stackoverflow\\.com/questions/\\d+(.*)";

    public StackOverFlowParser(Parser next) {
        super(next);
    }

    @Override
    public String[] doParse(String URL) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(URL);
        if (matcher.matches()) {
            return new String[]{URL.split("/")[4]};
        } else if (getNext() == null) {
            return null;
        }
        return getNext().doParse(URL);
    }
}
