package biz.davidpearson.gradle.androidlinttosonar.processing;

import biz.davidpearson.gradle.androidlinttosonar.model.lint.Issue;
import biz.davidpearson.gradle.androidlinttosonar.model.lint.Issues;
import biz.davidpearson.gradle.androidlinttosonar.model.lint.Location;
import org.gradle.api.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ReadInput {
    public static Issues readFile(String[] inputFiles, Project project) {

        System.out.println("ReadInput.readFile");
        System.out.println("inputFiles = " + Arrays.deepToString(inputFiles) + ", project = " + project);

        Issues issues = new Issues();

        // for each file
        for (String pFile : inputFiles) {
            File iFile = project.file(pFile);
            if (iFile.exists()) {
                System.out.printf("iFile: %s exists\n", iFile);
                // System.out.println("readFile - before - issues:" + issues);

                processFile(iFile, issues);
            } else {
                System.out.printf("iFile: %s does not exist\n", iFile);
            }
        }

        // System.out.println("readFile - after - issues:" + issues);

        return issues;
    }

    private static void processFile(File iFile, Issues issues) {
        // System.out.println("processFile - issues:" + issues);

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(iFile);
            document.getDocumentElement().normalize();
            NodeList issuesNodeList = document.getElementsByTagName("issues");

            if (issuesNodeList != null && issuesNodeList.getLength() > 0) {
                // System.out.println("issuesNodeList.getLength():" + issuesNodeList.getLength());
                // System.out.println("issuesNodeList:" + issuesNodeList.toString());

                Element issuesNode = (Element) issuesNodeList.item(0);

                // System.out.println("issuesNode:" + issuesNode.toString());


                NodeList childNodeList = issuesNode.getChildNodes();
                // System.out.println("childNodeList.getLength():" + childNodeList.getLength());
                // System.out.println("childNodeList:" + childNodeList);


                for (int ii = 0; ii < childNodeList.getLength(); ii++) {
                    Node child = childNodeList.item(ii);
                    if (child.getNodeType() == Node.ELEMENT_NODE) {
                        // System.out.println("child:" + child);
                        Element childElement = (Element) child;
                        // System.out.println("childElement:" + childElement);

                        NodeList locationNodeList = childElement.getElementsByTagName("location");
                        // System.out.println("locationNodeList:" + locationNodeList);

                        Collection<Location> locations = new ArrayList<>();
                        for (int jj = 0; jj < locationNodeList.getLength(); jj++) {
                            Element locationElement = (Element) locationNodeList.item(jj);

                            if (locationElement != null) {
                                Location
                                        location =
                                        Location.LocationBuilder.aLocation()
                                                                .withFile(locationElement.getAttribute("file"))
                                                                .withLine(locationElement.getAttribute("line"))
                                                                .withColumn(locationElement.getAttribute("column"))
                                                                .build();
                                locations.add(location);
                                // System.out.println("location:" + location);
                            }
                        }

                        Issue
                                issue =
                                Issue.IssueBuilder.anIssue()
                                                  .withLocations(locations)
                                                  .withId(childElement.getAttribute("id"))
                                                  .withCategory(childElement.getAttribute("category"))
                                                  .withSeverity(childElement.getAttribute("severity"))
                                                  .withSummary(childElement.getAttribute("summary"))
                                                  .withMessage(childElement.getAttribute("message"))
                                                  .build();

                        issues.add(issue);
                        // System.out.println("issue:" + issue);
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace(System.out);
        }
    }
}
