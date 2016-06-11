package ru.stqa.pft.rest;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by ilugovova on 11.06.2016.
 */
public class RestTests extends TestBase{
    @Test
    public void testCreateIssue() throws IOException {
        String path = "http://demo.bugify.com/api/issues.json";
        Set<Issue> oldIssues = getIssues(path);
        Issue newIssue = new Issue().withSubject("Test issue").withDescritption("New test issue");
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssues(path);
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }

    @Test
    public void testGetIssue() throws IOException {
        skipIfNotFixed(1);
    }




}
