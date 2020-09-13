package biz.davidpearson.gradle.androidlinttosonar.processing;

import biz.davidpearson.gradle.androidlinttosonar.model.lint.Issue;
import biz.davidpearson.gradle.androidlinttosonar.model.lint.Issues;
import biz.davidpearson.gradle.androidlinttosonar.model.lint.Location;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class WriteOutput {
    private static final String PREAMBLE = "{ \"issues\": [";
    private static final String CONCLUSION = "]}";

    /**
     * pre-condition: output file exists
     * <p>
     * process: append to output file
     */
    public static void writeFile(@NotNull Issues issues, @NotNull File oFile) {
        System.out.println("WriteOutput.writeFile");

        try (BufferedWriter output = new BufferedWriter(new FileWriter(oFile))) {
            output.write(PREAMBLE);
            // loop over issues
            boolean isFirst = true;

            if (issues.getIssues() != null) {
                for (Issue issue : issues.getIssues()) {
                    if (!isFirst) {
                        output.write(",");
                    }

                    output.write(issueToJson(issue));
                    isFirst = false;
                }
            }

            output.write(CONCLUSION);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private static String issueToJson(@NotNull Issue issue) {

        return "{" +
       "\"engineId\":\"Android Lint\"," +
       "\"ruleId\":" +
       JSONObject.quote(issue.getId()) +
       "," +
       "\"severity\":" +
       JSONObject.quote(severityToSeverity(issue.getSeverity())) +
       "," +
       "\"type\":" +
       JSONObject.quote(categoryToType(issue.getCategory())) +
       "," +
       issueLocationsToJson(issue.getLocations(),
                             "summary: " + issue.getSummary() + " message: " + issue.getMessage()) +
       "}";
    }

    private static String issueLocationsToJson(@NotNull Collection<Location> locations, @NotNull String message) {

        StringBuilder primaryLocationBuff = new StringBuilder();
        StringBuilder secondaryLocationBuff = new StringBuilder(", \"secondaryLocations\": [ ");
        int kk = 0;
        boolean isSecond = true;
        for (Location location : locations) {
            if (kk == 0) {
                primaryLocationBuff.append("\"primaryLocation\":{\"message\":")
                                   .append(JSONObject.quote(message))
                                   .append(",")
                                   .append("\"filePath\":")
                                   .append(JSONObject.quote(location.getFile()))
                                   .append(",")
                                   .append("\"textRange\":{")
                                   .append("\"startLine\":");
                if (location.getLine() != null && location.getLine().isEmpty()) {
                    primaryLocationBuff.append("\"1\"");
                } else {
                    primaryLocationBuff.append(JSONObject.quote(location.getLine()));
                }

                if (location.getColumn() != null && !location.getColumn().isEmpty()) {
                    primaryLocationBuff.append(",\"startColumn\":").append(JSONObject.quote(location.getColumn()));
                }

                primaryLocationBuff.append("}").append("}");
            } else {
                if (!isSecond) {
                    secondaryLocationBuff.append(",");
                }
                secondaryLocationBuff.append("{\"message\":")
                                     .append(JSONObject.quote(message))
                                     .append(",")
                                     .append("\"filePath\":")
                                     .append(JSONObject.quote(location.getFile()));
                if (location.getLine() != null && !location.getLine().isEmpty()) {
                    secondaryLocationBuff.append(",")
                                         .append("\"textRange\":{")
                                         .append("\"startLine\":")
                                         .append(JSONObject.quote(location.getLine()));
                    if (location.getColumn() != null && !location.getColumn().isEmpty()) {
                        secondaryLocationBuff.append(",\"startColumn\":")
                                             .append(JSONObject.quote(location.getColumn()));
                    }
                    secondaryLocationBuff.append("}");
                }
                secondaryLocationBuff.append("}");
                isSecond = false;
            }
            kk++;
        }
        secondaryLocationBuff.append("]");

        if (locations.size() > 1) {
            return (primaryLocationBuff.append(secondaryLocationBuff)).toString();
        } else {
            return primaryLocationBuff.toString();
        }
    }

    /**
     * convert Android Lint severity value to Sonar severity value
     */
    private static String severityToSeverity(String severity) {
        String retVal = "INFORMATION";
        switch (severity) {
            case "FATAL":
                retVal = "BLOCKER";
                break;
            case "ERROR":
                retVal = "CRITICAL";
                break;
            case "WARNING":
                retVal = "MINOR";
                break;
            case "INFORMATION":
            case "IGNORE":
                retVal = "INFORMATION";
                break;
        }
        return retVal;
    }

    private static String categoryToType(String category) {
        String retVal = "CODE_SMELL";

        switch (category) {

            case "LINT":
            case "CORRECTNESS":
            case "MESSAGES":
            case "INTEROPERABILITY":
            case "INTEROPERABILITY_KOTLIN":
            case "INTEROPERABILITY_JAVA":
            case "CHROME_OS":
            case "APP_SIZE":
                retVal = "BUG";
                break;
            case "SECURITY":
            case "COMPLIANCE":
            case "PERFORMANCE":
            case "A11Y":
                retVal = "VULNERABILITY";
                break;
            case "USABILITY":
            case "I18N":
            case "ICONS":
            case "TYPOGRAPHY":
            case "RTL":
            case "TESTING":
                retVal = "CODE_SMELL";
                break;
        }

        return retVal;
    }
}
