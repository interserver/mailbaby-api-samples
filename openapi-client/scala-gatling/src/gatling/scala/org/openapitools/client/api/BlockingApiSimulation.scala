package org.openapitools.client.api

import org.openapitools.client.model._
import com.typesafe.config.ConfigFactory

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.PopulationBuilder

import java.io.File

import scala.collection.mutable

class BlockingApiSimulation extends Simulation {

    def getCurrentDirectory = new File("").getAbsolutePath
    def userDataDirectory = getCurrentDirectory + "/src/gatling/resources/data"

    // basic test setup
    val configName = System.getProperty("testConfig", "baseline")
    val config = ConfigFactory.load(configName).withFallback(ConfigFactory.load("default"))
    val durationSeconds = config.getInt("performance.durationSeconds")
    val rampUpSeconds = config.getInt("performance.rampUpSeconds")
    val rampDownSeconds = config.getInt("performance.rampDownSeconds")
    val authentication = config.getString("performance.authorizationHeader")
    val acceptHeader = config.getString("performance.acceptType")
    val contentTypeHeader = config.getString("performance.contentType")
    val rateMultiplier = config.getDouble("performance.rateMultiplier")
    val instanceMultiplier = config.getDouble("performance.instanceMultiplier")

    // global assertion data
    val globalResponseTimeMinLTE = config.getInt("performance.global.assertions.responseTime.min.lte")
    val globalResponseTimeMinGTE = config.getInt("performance.global.assertions.responseTime.min.gte")
    val globalResponseTimeMaxLTE = config.getInt("performance.global.assertions.responseTime.max.lte")
    val globalResponseTimeMaxGTE = config.getInt("performance.global.assertions.responseTime.max.gte")
    val globalResponseTimeMeanLTE = config.getInt("performance.global.assertions.responseTime.mean.lte")
    val globalResponseTimeMeanGTE = config.getInt("performance.global.assertions.responseTime.mean.gte")
    val globalResponseTimeFailedRequestsPercentLTE = config.getDouble("performance.global.assertions.failedRequests.percent.lte")
    val globalResponseTimeFailedRequestsPercentGTE = config.getDouble("performance.global.assertions.failedRequests.percent.gte")
    val globalResponseTimeSuccessfulRequestsPercentLTE = config.getDouble("performance.global.assertions.successfulRequests.percent.lte")
    val globalResponseTimeSuccessfulRequestsPercentGTE = config.getDouble("performance.global.assertions.successfulRequests.percent.gte")

// Setup http protocol configuration
    val httpConf = http
        .baseURL("https://api.mailbaby.net")
        .doNotTrackHeader("1")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .acceptEncodingHeader("gzip, deflate")
        .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")
        .acceptHeader(acceptHeader)
        .contentTypeHeader(contentTypeHeader)

    // set authorization header if it has been modified from config
    if(!authentication.equals("~MANUAL_ENTRY")){
        httpConf.authorizationHeader(authentication)
    }

    // Setup all the operations per second for the test to ultimately be generated from configs
    val addRulePerSecond = config.getDouble("performance.operationsPerSecond.addRule") * rateMultiplier * instanceMultiplier
    val deleteRulePerSecond = config.getDouble("performance.operationsPerSecond.deleteRule") * rateMultiplier * instanceMultiplier
    val delistBlockPerSecond = config.getDouble("performance.operationsPerSecond.delistBlock") * rateMultiplier * instanceMultiplier
    val getMailBlocksPerSecond = config.getDouble("performance.operationsPerSecond.getMailBlocks") * rateMultiplier * instanceMultiplier
    val getRulesPerSecond = config.getDouble("performance.operationsPerSecond.getRules") * rateMultiplier * instanceMultiplier

    val scenarioBuilders: mutable.MutableList[PopulationBuilder] = new mutable.MutableList[PopulationBuilder]()

    // Set up CSV feeders
    val deleteRulePATHFeeder = csv(userDataDirectory + File.separator + "deleteRule-pathParams.csv").random

    // Setup all scenarios

    
    val scnaddRule = scenario("addRuleSimulation")
        .exec(http("addRule")
        .httpRequest("POST","/mail/rules")
)

    // Run scnaddRule with warm up and reach a constant rate for entire duration
    scenarioBuilders += scnaddRule.inject(
        rampUsersPerSec(1) to(addRulePerSecond) during(rampUpSeconds),
        constantUsersPerSec(addRulePerSecond) during(durationSeconds),
        rampUsersPerSec(addRulePerSecond) to(1) during(rampDownSeconds)
    )

    
    val scndeleteRule = scenario("deleteRuleSimulation")
        .feed(deleteRulePATHFeeder)
        .exec(http("deleteRule")
        .httpRequest("DELETE","/mail/rules/${ruleId}")
)

    // Run scndeleteRule with warm up and reach a constant rate for entire duration
    scenarioBuilders += scndeleteRule.inject(
        rampUsersPerSec(1) to(deleteRulePerSecond) during(rampUpSeconds),
        constantUsersPerSec(deleteRulePerSecond) during(durationSeconds),
        rampUsersPerSec(deleteRulePerSecond) to(1) during(rampDownSeconds)
    )

    
    val scndelistBlock = scenario("delistBlockSimulation")
        .exec(http("delistBlock")
        .httpRequest("POST","/mail/blocks/delete")
)

    // Run scndelistBlock with warm up and reach a constant rate for entire duration
    scenarioBuilders += scndelistBlock.inject(
        rampUsersPerSec(1) to(delistBlockPerSecond) during(rampUpSeconds),
        constantUsersPerSec(delistBlockPerSecond) during(durationSeconds),
        rampUsersPerSec(delistBlockPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scngetMailBlocks = scenario("getMailBlocksSimulation")
        .exec(http("getMailBlocks")
        .httpRequest("GET","/mail/blocks")
)

    // Run scngetMailBlocks with warm up and reach a constant rate for entire duration
    scenarioBuilders += scngetMailBlocks.inject(
        rampUsersPerSec(1) to(getMailBlocksPerSecond) during(rampUpSeconds),
        constantUsersPerSec(getMailBlocksPerSecond) during(durationSeconds),
        rampUsersPerSec(getMailBlocksPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scngetRules = scenario("getRulesSimulation")
        .exec(http("getRules")
        .httpRequest("GET","/mail/rules")
)

    // Run scngetRules with warm up and reach a constant rate for entire duration
    scenarioBuilders += scngetRules.inject(
        rampUsersPerSec(1) to(getRulesPerSecond) during(rampUpSeconds),
        constantUsersPerSec(getRulesPerSecond) during(durationSeconds),
        rampUsersPerSec(getRulesPerSecond) to(1) during(rampDownSeconds)
    )

    setUp(
        scenarioBuilders.toList
    ).protocols(httpConf).assertions(
        global.responseTime.min.lte(globalResponseTimeMinLTE),
        global.responseTime.min.gte(globalResponseTimeMinGTE),
        global.responseTime.max.lte(globalResponseTimeMaxLTE),
        global.responseTime.max.gte(globalResponseTimeMaxGTE),
        global.responseTime.mean.lte(globalResponseTimeMeanLTE),
        global.responseTime.mean.gte(globalResponseTimeMeanGTE),
        global.failedRequests.percent.lte(globalResponseTimeFailedRequestsPercentLTE),
        global.failedRequests.percent.gte(globalResponseTimeFailedRequestsPercentGTE),
        global.successfulRequests.percent.lte(globalResponseTimeSuccessfulRequestsPercentLTE),
        global.successfulRequests.percent.gte(globalResponseTimeSuccessfulRequestsPercentGTE)
    )
}
