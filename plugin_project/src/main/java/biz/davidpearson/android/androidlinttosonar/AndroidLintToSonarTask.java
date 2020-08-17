package biz.davidpearson.android.androidlinttosonar;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.file.FileCollection;
import org.gradle.api.file.RegularFile;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * https://docs.gradle.org/6.5/userguide/more_about_tasks.html#sec:task_input_output_annotations
 * https://guides.gradle.org/implementing-gradle-plugins/
 */
public class AndroidLintToSonarTask extends DefaultTask {


    private String[] inputFiles;
    private String outputFile;

    // @SkipWhenEmpty
    @InputFiles
    public String[] getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(String[] inputFiles) {
        this.inputFiles = inputFiles;
    }

    @OutputFile
    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    @TaskAction
    void processFiles() throws IOException {
        System.out.println("AndroidLintToSonarTask::processFiles - begin");

        // list the files
        System.out.printf("AndroidLintToSonarTask::inputFiles: %s\n", Arrays.toString(inputFiles));

        // list the output
        System.out.printf("AndroidLintToSonarTask::outputFile: %s\n", outputFile);

        // create the output - overwrite the existing?
        File oFile = getProject().file(outputFile);

        if (oFile.exists()) {
            oFile.delete();
        }
        oFile.createNewFile();

        // for each file
        for (String pFile : inputFiles) {
            File iFile = getProject().file(pFile);
            if (iFile.exists()) {
                System.out.printf("iFile: %s exists\n", iFile);
            } else {
                System.out.printf("iFile: %s does not exist\n", iFile);
            }
        }

        System.out.println("AndroidLintToSonarTask::processFiles - end");
    }
}
