package biz.davidpearson.gradle.androidlinttosonar.model.lint;

import java.util.Collection;

public class Issue {
    private String id;
    private String severity;
    private String category;
    private String summary;
    private String message;
    private Collection<Location> locations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Issue{" +
               "id='" +
               id +
               '\'' +
               ", severity='" +
               severity +
               '\'' +
               ", category='" +
               category +
               '\'' +
               ", summary='" +
               summary +
               '\'' +
               ", message='" +
               message +
               '\'' +
               ", locations=" +
               locations +
               '}';
    }

    public static final class IssueBuilder {
        private String id;
        private String severity;
        private String category;
        private String summary;
        private String message;
        private Collection<Location> locations;

        private IssueBuilder() {
        }

        public static IssueBuilder anIssue() {
            return new IssueBuilder();
        }

        public IssueBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public IssueBuilder withSeverity(String severity) {
            this.severity = severity;
            return this;
        }

        public IssueBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public IssueBuilder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public IssueBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public IssueBuilder withLocations(Collection<Location> locations) {
            this.locations = locations;
            return this;
        }

        public Issue build() {
            Issue issue = new Issue();
            issue.setId(id);
            issue.setSeverity(severity);
            issue.setCategory(category);
            issue.setSummary(summary);
            issue.setMessage(message);
            issue.setLocations(locations);
            return issue;
        }
    }
}
