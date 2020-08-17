package biz.davidpearson.android.androidlinttosonar;

import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;

public class AndroidLintToSonarPluginExtension {

    private String inputFiles;
    private String outputFile = "./reports/androidLintToSonar/sonar.json";

    // @SkipWhenEmpty
    @InputFiles
    public String getInputFiles() {
        System.out.println("AndroidLintToSonarPluginExtension::getInputFiles() called");
        return inputFiles;
    }

    public void setInputFiles(String inputFiles) {
        System.out.printf("AndroidLintToSonarPluginExtension::setInputFiles(%s) called\n", inputFiles);
        this.inputFiles = inputFiles;
    }

    @OutputFile
    public String getOutputFile() {
        System.out.println("AndroidLintToSonarPluginExtension::getOutputFile() called");
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        System.out.printf("AndroidLintToSonarPluginExtension::setOutputFile(%s) called\n", outputFile);
        this.outputFile = outputFile;
    }

    @Override
    public String toString() {
        return "AndroidLintToSonarPluginExtension{" +
                "inputFiles='" + inputFiles + '\'' +
                ", outputFile='" + outputFile + '\'' +
                '}';
    }
}
