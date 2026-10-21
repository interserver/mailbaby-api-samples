package com.prokarma.pkmst.cucumber;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@ActiveProfiles("test")
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report",
 "json:./report/Status-report-json/Status.json",
 "json:./report/Services-report-json/Services.json",
 "json:./report/Sending-report-json/Sending.json",
 "json:./report/Blocking-report-json/Blocking.json",
 "json:./report/History-report-json/History.json",
 })
public class PkmstTest {
}