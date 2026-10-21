package com.prokarma.pkmst.cucumber.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ExecuteReport {

  public static void main(String[] args) {
    generateReport();
  }

  private static void generateReport() {
    String buildNumber = "1";
    String projectName = "Spring-micro-sample";
    boolean runWithJenkins = false;
    boolean parallelTesting = false;

    File reportOutputDirectory = null;
    List<String> jsonFiles = null;
    Configuration configuration = null;
    ReportBuilder reportBuilder = null;
    reportOutputDirectory = new File("./report/Status-report-html/");
    jsonFiles = new ArrayList();
    jsonFiles.add("./report/Status-report-json/Status.json");

    configuration = new Configuration(reportOutputDirectory,projectName);
    // optionally only if you need
    configuration.setParallelTesting(parallelTesting);
    configuration.setRunWithJenkins(runWithJenkins);
    configuration.setBuildNumber(buildNumber);

    reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();
    reportOutputDirectory = new File("./report/Services-report-html/");
    jsonFiles = new ArrayList();
    jsonFiles.add("./report/Services-report-json/Services.json");

    configuration = new Configuration(reportOutputDirectory,projectName);
    // optionally only if you need
    configuration.setParallelTesting(parallelTesting);
    configuration.setRunWithJenkins(runWithJenkins);
    configuration.setBuildNumber(buildNumber);

    reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();
    reportOutputDirectory = new File("./report/Sending-report-html/");
    jsonFiles = new ArrayList();
    jsonFiles.add("./report/Sending-report-json/Sending.json");

    configuration = new Configuration(reportOutputDirectory,projectName);
    // optionally only if you need
    configuration.setParallelTesting(parallelTesting);
    configuration.setRunWithJenkins(runWithJenkins);
    configuration.setBuildNumber(buildNumber);

    reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();
    reportOutputDirectory = new File("./report/Blocking-report-html/");
    jsonFiles = new ArrayList();
    jsonFiles.add("./report/Blocking-report-json/Blocking.json");

    configuration = new Configuration(reportOutputDirectory,projectName);
    // optionally only if you need
    configuration.setParallelTesting(parallelTesting);
    configuration.setRunWithJenkins(runWithJenkins);
    configuration.setBuildNumber(buildNumber);

    reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();
    reportOutputDirectory = new File("./report/History-report-html/");
    jsonFiles = new ArrayList();
    jsonFiles.add("./report/History-report-json/History.json");

    configuration = new Configuration(reportOutputDirectory,projectName);
    // optionally only if you need
    configuration.setParallelTesting(parallelTesting);
    configuration.setRunWithJenkins(runWithJenkins);
    configuration.setBuildNumber(buildNumber);

    reportBuilder = new ReportBuilder(jsonFiles, configuration);
    reportBuilder.generateReports();

  }
}