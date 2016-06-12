package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by ilugovova on 12.06.2016.
 */
public class GithubTests {

    @Test
    public void testCommits () throws IOException {
        Github github = new RtGithub("52d37b08b6cf16bc93b5330d4ecc5c48eb1c3b78");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("Admeya", "java_pft")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }

    }
}
