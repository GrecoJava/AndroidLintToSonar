package biz.davidpearson.android.androidlinttosonar;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AndroidLintToSonarPluginTest {
    @Test
    public void pluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("biz.davidpearson.android.androidlinttosonar");

        assertTrue(project.getTasks().getByName("hello") instanceof GreetingTask);
        assertTrue(project.getTasks().getByName("androidLintToSonar") instanceof AndroidLintToSonarTask);
    }
}
