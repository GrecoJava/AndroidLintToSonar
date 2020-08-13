package biz.davidpearson.android.androidlinttosonar;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class AndroidLintToSonarPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().create("hello", GreetingTask.class, (task) -> {
            task.setMessage("Hello");
            task.setRecipient("World");
        });
        project.getTasks().create("androidLintToSonar", AndroidLintToSonarTask.class, (task) -> {

        });
    }
}
