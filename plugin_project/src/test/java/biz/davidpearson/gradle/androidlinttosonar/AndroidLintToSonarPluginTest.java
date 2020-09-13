package biz.davidpearson.gradle.androidlinttosonar;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndroidLintToSonarPluginTest {
    @Test
    public void pluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("biz.davidpearson.android.androidlinttosonar");

        assertTrue(project.getTasks().getByName("androidLintToSonar") instanceof AndroidLintToSonarTask);
    }
}
