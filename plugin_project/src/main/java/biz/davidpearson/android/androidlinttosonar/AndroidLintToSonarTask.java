package biz.davidpearson.android.androidlinttosonar;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.file.RegularFile;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

public class AndroidLintToSonarTask extends DefaultTask {

    // list of input files
    @InputFiles
    private ListProperty<RegularFile> inputFiles = getProject().getObjects().listProperty(RegularFile.class);


    // one output file - default buildDir/lintToSonar/issues.json
    @OutputFile
    private RegularFileProperty outputFile = getProject().getObjects().fileProperty();


    @TaskAction
    void processFiles() {
        System.out.println("processFiles - begin");

        // list the files

        // list the output


        System.out.println("processFiles - end");
    }
}
