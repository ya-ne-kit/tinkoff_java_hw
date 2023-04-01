package ru.tinkoff.edu.java.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GitHubParser extends Parser {

    public GitHubParser(Parser next) {
        super(next);
    }

    @Override
    public String[] doParse(String URL) {
        String regex="https?://github\\.com/(.*)/(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(URL);
        if (matcher.matches()) {
            return new String[] {URL.split("/")[3], URL.split("/")[4]};
        } else if (next == null) {
            return null;
        }
        return this.getNext().doParse(URL);
    }
}
