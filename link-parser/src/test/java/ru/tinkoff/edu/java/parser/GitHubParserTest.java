package ru.tinkoff.edu.java.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitHubParserTest {

    @Test
    void simpleRegExTests() {
        String[] git = {"sanyarnd", "tinkoff-java-course-2022"};
        String[] sof = {"1642028"};
        StackOverFlowParser stackOverFlowParser = new StackOverFlowParser(null);
        GitHubParser gitHubParser = new GitHubParser(stackOverFlowParser);
        assertArrayEquals(git, gitHubParser.doParse("https://github.com/sanyarnd/tinkoff-java-course-2022"));
        assertArrayEquals(git, gitHubParser.doParse("https://github.com/sanyarnd/tinkoff-java-course-2022/"));
        assertArrayEquals(git, gitHubParser.doParse("http://github.com/sanyarnd/tinkoff-java-course-2022"));
        assertArrayEquals(git, gitHubParser.doParse("http://github.com/sanyarnd/tinkoff-java-course-2022/"));
        assertArrayEquals(sof, gitHubParser.doParse("https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c"));
        assertArrayEquals(sof, gitHubParser.doParse("https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c/"));
        assertArrayEquals(sof, gitHubParser.doParse("https://stackoverflow.com/questions/1642028"));
        assertArrayEquals(sof, gitHubParser.doParse("https://stackoverflow.com/questions/1642028/"));
        assertArrayEquals(sof, gitHubParser.doParse("http://stackoverflow.com/questions/1642028/what-is-the-operator-in-c"));
        assertArrayEquals(sof, gitHubParser.doParse("http://stackoverflow.com/questions/1642028/what-is-the-operator-in-c/"));
        assertArrayEquals(sof, gitHubParser.doParse("http://stackoverflow.com/questions/1642028"));
        assertArrayEquals(sof, gitHubParser.doParse("http://stackoverflow.com/questions/1642028/"));
        assertNull(gitHubParser.doParse("https://stackoverflow.com/search?q=unsupported%20link"));
    }
}