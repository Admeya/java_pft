package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

/**
 * Created by ilugovova on 11.06.2016.
 */
public class TestBase {
    protected Set<Issue> getIssues(String path) throws IOException {
        String json = getExecutor().execute(Request.Get(path)).returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }

    protected String getIssue(String path) throws IOException {
        String json = getExecutor().execute(Request.Get(path)).returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        String issue = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0).getAsJsonObject().get("state_name").getAsString();
        return issue;
    }

    protected Executor getExecutor() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==","");
    }

    protected int createIssue(Issue newIssue) throws IOException {
        String json = getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json")
                .bodyForm(new BasicNameValuePair("subject",newIssue.getSubject()),
                        new BasicNameValuePair("description", newIssue.getDescritption())))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        return  parsed.getAsJsonObject().get("issue_id").getAsInt();
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    protected boolean isIssueOpen(int issueId) throws IOException {
        if (getIssue(String.format("http://demo.bugify.com/api/issues/%s.json",issueId)).equals("Closed")) {
            return false;
        } else {
            return true;
        }
    }
}
