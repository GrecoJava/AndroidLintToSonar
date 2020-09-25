package biz.davidpearson.gradle.androidlinttosonar

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import java.io.File

/**
 * blatantly based on [AndroidLintReporterPluginFunctionalTest](https://github.com/worker8/AndroidLintReporter/blob/master/src/functionalTest/kotlin/android_lint_reporter/AndroidLintReporterPluginFunctionalTest.kt)
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AndroidLintToSonarPluginFunctionalTest {
    private val projectDir = File("build/functionalTest")

    @BeforeAll
    internal fun beforeAll() {
        projectDir.resolve("reports").deleteRecursively()
    }

    @Suppress("FunctionName")
    @Test
    fun `all inputs`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = [
                              "../../src/functionalTest/resources/lint-results.xml",
                              "../../src/functionalTest/resources/lint-results-absolute-path.xml",
                              "../../src/functionalTest/resources/lint-results-bad-report.xml",
                              "../../src/functionalTest/resources/lint-results-empty.xml",
                              "../../src/functionalTest/resources/lint-results-large.xml",
                              "../../src/functionalTest/resources/lint-results-unknown-rule.xml",
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-all.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual =
            projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-all.json").readText(Charsets.UTF_8)

        // validate the output
        val expectedResults =
            projectDir.resolve("../../src/functionalTest/resources/expected_results/sonar-lint-results-all.json")
                .readText(Charsets.UTF_8)
        JSONAssert.assertEquals(expectedResults, actual, JSONCompareMode.STRICT)
    }

    @Suppress("FunctionName")
    @Test
    fun `lint bad report`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = ["../../src/functionalTest/resources/lint-results-bad-report.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-bad-report.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual =
            projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-bad-report.json")
                .readText(Charsets.UTF_8)

        // validate the output
        JSONAssert.assertEquals("{ \"issues\": []}", actual, JSONCompareMode.STRICT)
    }

    @Suppress("FunctionName")
    @Test
    fun `lint report`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = [
                              "../../src/functionalTest/resources/lint-results.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual = projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results.json").readText(Charsets.UTF_8)

        // validate the output
        val expectedResults =
            projectDir.resolve("../../src/functionalTest/resources/expected_results/sonar-lint-results.json")
                .readText(Charsets.UTF_8)
        JSONAssert.assertEquals(expectedResults, actual, JSONCompareMode.STRICT)
    }


    @Suppress("FunctionName")
    @Test
    fun `lint report empty`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = [
                              "../../src/functionalTest/resources/lint-results-empty.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-report-empty.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual =
            projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-report-empty.json")
                .readText(Charsets.UTF_8)

        // validate the output
        JSONAssert.assertEquals("{ \"issues\": []}", actual, JSONCompareMode.STRICT)
    }


    @Suppress("FunctionName")
    @Test
    fun `lint report large`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = [
                              "../../src/functionalTest/resources/lint-results-large.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-large.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual =
            projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-large.json").readText(Charsets.UTF_8)

        // validate the output
        val expectedResults =
            projectDir.resolve("../../src/functionalTest/resources/expected_results/sonar-lint-results-large.json")
                .readText(Charsets.UTF_8)
        JSONAssert.assertEquals(expectedResults, actual, JSONCompareMode.STRICT)
    }


    @Suppress("FunctionName")
    @Test
    fun `lint results absolute path`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = [
                              "../../src/functionalTest/resources/lint-results-absolute-path.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-absolute-path.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual = projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-absolute-path.json")
            .readText(Charsets.UTF_8)

        // validate the output
        val expectedResults =
            projectDir.resolve("../../src/functionalTest/resources/expected_results/sonar-lint-results-absolute-path.json")
                .readText(Charsets.UTF_8)
        JSONAssert.assertEquals(expectedResults, actual, JSONCompareMode.STRICT)
    }

    @Suppress("FunctionName")
    @Test
    fun `lint unknown rule report`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = [
                              "../../src/functionalTest/resources/lint-results-unknown-rule.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-unknown-rule.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual = projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-unknown-rule.json")
            .readText(Charsets.UTF_8)

        // validate the output
        val expectedResults =
            projectDir.resolve("../../src/functionalTest/resources/expected_results/sonar-lint-results-unknown-rule.json")
                .readText(Charsets.UTF_8)
        JSONAssert.assertEquals(expectedResults, actual, JSONCompareMode.STRICT)
    }

    @Suppress("FunctionName")
    @Test
    fun `lint file does not exist`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = ["../../src/functionalTest/resources/lint-results-does_not_exist.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-does-not-exist.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual =
            projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-does-not-exist.json")
                .readText(Charsets.UTF_8)

        // validate the output
        JSONAssert.assertEquals("{ \"issues\": []}", actual, JSONCompareMode.STRICT)
    }

    @Suppress("FunctionName")
    @Test
    fun `lint report 20200919`() {
        //
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText(
            """
            plugins {
                id("biz.davidpearson.gradle.androidlinttosonar")
            }
            androidLintToSonar {
                inputFiles = [
                              "../../src/functionalTest/resources/lint-results-20200919.xml"
                              ]
                outputFile = "./reports/androidLintToSonar/sonar-lint-results-20200919.json"
            }
        """
        )

        // run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(listOf("androidLintToSonar"))
        runner.withProjectDir(projectDir)

        runner.build()
        // val results = runner.build()

        // println("output: ${results.output} ++++++")

        // obtain JSON file contents
        val actual = projectDir.resolve("./reports/androidLintToSonar/sonar-lint-results-20200919.json")
            .readText(Charsets.UTF_8)

        // validate the output
        val expectedResults =
            projectDir.resolve("../../src/functionalTest/resources/expected_results/sonar-lint-results-20200919.json")
                .readText(Charsets.UTF_8)
        JSONAssert.assertEquals(expectedResults, actual, JSONCompareMode.STRICT)
    }


}