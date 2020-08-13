package biz.davidpearson.android.androidlinttosonar

import junit.framework.Assert.assertTrue
import org.gradle.testkit.runner.GradleRunner
import org.junit.Test
import java.io.File

/**
 * blatantly based on [AndroidLintReporterPluginFunctionalTest](https://github.com/worker8/AndroidLintReporter/blob/master/src/functionalTest/kotlin/android_lint_reporter/AndroidLintReporterPluginFunctionalTest.kt)
 */
class AndroidLintToSonarPluginFunctionalTest {

    @Test
    fun `can run task`() {
        //
        val projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.android.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = ""
                outputFile = ""
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments()
        runner.withProjectDir(projectDir)

        val results = runner.build()

        println("output: ${results.output}")

        assertTrue(true)
    }
}