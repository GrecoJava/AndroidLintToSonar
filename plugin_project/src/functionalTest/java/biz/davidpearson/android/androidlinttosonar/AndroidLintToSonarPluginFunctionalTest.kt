package biz.davidpearson.android.androidlinttosonar

import org.gradle.testkit.runner.GradleRunner
import org.junit.Assert.assertTrue
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
                inputFiles = ["../../src/functionalTest/resources/lint-bad-report.xml",
                              "../../src/functionalTest/resources/lint-report.xml",
                              "../../src/functionalTest/resources/lint-report-empty.xml",
                              "../../src/functionalTest/resources/lint-report-large.xml",
                              "../../src/functionalTest/resources/lint-results_absolute_path.xml",
                              "../../src/functionalTest/resources/lint-unknown-rule-report.xml",
                              ]
                outputFile = "./reports/androidLintToSonar/sonar.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        val results = runner.build()

        println("output: ${results.output}")

        assertTrue(true)
    }
}