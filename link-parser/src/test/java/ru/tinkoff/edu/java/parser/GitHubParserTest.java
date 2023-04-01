package ru.tinkoff.edu.java.parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GitHubParserTest {

    @Test
    void regTest() {
        StackOverFlowParser stackOverFlowParser = new StackOverFlowParser(null);
        GitHubParser gitHubParser = new GitHubParser(stackOverFlowParser);
        String[] result = gitHubParser.doParse("https://github.com/sanyarnd/tinkoff-java-course-2022");
        System.out.println(result != null ? Arrays.stream(result).toList() : "null");
        result = gitHubParser.doParse("https://github.com/sanyarnd/tinkoff-java-course-2022/");
        System.out.println(result != null ? Arrays.stream(result).toList() : "null");
        result = gitHubParser.doParse("https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c");
        System.out.println(result != null ? Arrays.stream(result).toList() : "null");
        result = gitHubParser.doParse("https://stackoverflow.com/questions/1642028");
        System.out.println(result != null ? Arrays.stream(result).toList() : "null");
        result = gitHubParser.doParse("https://stackoverflow.com/questions/1642028/");
        System.out.println(result != null ? Arrays.stream(result).toList() : "null");
        result = gitHubParser.doParse("https://stackoverflow.com/search?q=unsupported%20link");
        System.out.println(result != null ? Arrays.stream(result).toList() : "null");
    }
}