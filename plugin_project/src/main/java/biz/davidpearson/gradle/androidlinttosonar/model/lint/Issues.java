package biz.davidpearson.gradle.androidlinttosonar.model.lint;

import java.util.ArrayList;
import java.util.Collection;

public class Issues {
    private Collection<Issue> issues;

    public Collection<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Collection<Issue> issues) {
        this.issues = issues;
    }

    public void add(Issue issue) {
        if (issues == null) {
            issues = new ArrayList<>();
        }
        issues.add(issue);
    }

    @Override
    public String toString() {
        return "Issues{" + "issues=" + issues + '}';
    }
}
