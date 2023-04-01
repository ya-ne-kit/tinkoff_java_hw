package ru.tinkoff.edu.java.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GitHubParser extends Parser {


    private final String REGEX = "https?://github\\.com/(.*)/(.*)";

    public GitHubParser(Parser next) {
        super(next);
    }

    @Override
    public String[] doParse(String URL) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(URL);
        if (matcher.matches()) {
            return new String[]{URL.split("/")[3], URL.split("/")[4]};
        } else if (getNext() == null) {
            return null;
        }
        return getNext().doParse(URL);
    }
}
