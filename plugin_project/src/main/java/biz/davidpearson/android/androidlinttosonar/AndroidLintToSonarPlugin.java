package biz.davidpearson.android.androidlinttosonar;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class AndroidLintToSonarPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        System.out.println("AndroidLintToSonarPlugin::apply() called");

        // AndroidLintToSonarPluginExtension extension = project.getExtensions().create("androidLintToSonar", AndroidLintToSonarPluginExtension.class);

        project.getTasks().create("androidLintToSonar", AndroidLintToSonarTask.class, (task) -> {
            System.out.println("AndroidLintToSonarPlugin::creating task androidLintToSonar");
            // System.out.printf("AndroidLintToSonarPlugin::received extension: %s \n", extension.toString());
            // task.setInputFiles(extension.getInputFiles());
            // task.setOutputFile(extension.getOutputFile());
        });
    }
}
