package org.openapitools.client.api

import org.openapitools.client.model._
import com.typesafe.config.ConfigFactory

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.PopulationBuilder

import java.io.File

import scala.collection.mutable

class DefaultApiSimulation extends Simulation {

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
    val getMailOrdersPerSecond = config.getDouble("performance.operationsPerSecond.getMailOrders") * rateMultiplier * instanceMultiplier
    val pingServerPerSecond = config.getDouble("performance.operationsPerSecond.pingServer") * rateMultiplier * instanceMultiplier
    val placeMailOrderPerSecond = config.getDouble("performance.operationsPerSecond.placeMailOrder") * rateMultiplier * instanceMultiplier
    val sendAdvMailByIdPerSecond = config.getDouble("performance.operationsPerSecond.sendAdvMailById") * rateMultiplier * instanceMultiplier
    val sendMailByIdPerSecond = config.getDouble("performance.operationsPerSecond.sendMailById") * rateMultiplier * instanceMultiplier
    val validateMailOrderPerSecond = config.getDouble("performance.operationsPerSecond.validateMailOrder") * rateMultiplier * instanceMultiplier
    val viewMailLogByIdPerSecond = config.getDouble("performance.operationsPerSecond.viewMailLogById") * rateMultiplier * instanceMultiplier

    val scenarioBuilders: mutable.MutableList[PopulationBuilder] = new mutable.MutableList[PopulationBuilder]()

    // Set up CSV feeders
    val getMailOrdersQUERYFeeder = csv(userDataDirectory + File.separator + "getMailOrders-queryParams.csv").random
    val sendMailByIdQUERYFeeder = csv(userDataDirectory + File.separator + "sendMailById-queryParams.csv").random
    val viewMailLogByIdQUERYFeeder = csv(userDataDirectory + File.separator + "viewMailLogById-queryParams.csv").random

    // Setup all scenarios

    
    val scngetMailOrders = scenario("getMailOrdersSimulation")
        .feed(getMailOrdersQUERYFeeder)
        .exec(http("getMailOrders")
        .httpRequest("GET","/mail")
        .queryParam("id","${id}")
)

    // Run scngetMailOrders with warm up and reach a constant rate for entire duration
    scenarioBuilders += scngetMailOrders.inject(
        rampUsersPerSec(1) to(getMailOrdersPerSecond) during(rampUpSeconds),
        constantUsersPerSec(getMailOrdersPerSecond) during(durationSeconds),
        rampUsersPerSec(getMailOrdersPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scnpingServer = scenario("pingServerSimulation")
        .exec(http("pingServer")
        .httpRequest("GET","/ping")
)

    // Run scnpingServer with warm up and reach a constant rate for entire duration
    scenarioBuilders += scnpingServer.inject(
        rampUsersPerSec(1) to(pingServerPerSecond) during(rampUpSeconds),
        constantUsersPerSec(pingServerPerSecond) during(durationSeconds),
        rampUsersPerSec(pingServerPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scnplaceMailOrder = scenario("placeMailOrderSimulation")
        .exec(http("placeMailOrder")
        .httpRequest("POST","/mail/order")
)

    // Run scnplaceMailOrder with warm up and reach a constant rate for entire duration
    scenarioBuilders += scnplaceMailOrder.inject(
        rampUsersPerSec(1) to(placeMailOrderPerSecond) during(rampUpSeconds),
        constantUsersPerSec(placeMailOrderPerSecond) during(durationSeconds),
        rampUsersPerSec(placeMailOrderPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scnsendAdvMailById = scenario("sendAdvMailByIdSimulation")
        .exec(http("sendAdvMailById")
        .httpRequest("POST","/mail/advsend")
)

    // Run scnsendAdvMailById with warm up and reach a constant rate for entire duration
    scenarioBuilders += scnsendAdvMailById.inject(
        rampUsersPerSec(1) to(sendAdvMailByIdPerSecond) during(rampUpSeconds),
        constantUsersPerSec(sendAdvMailByIdPerSecond) during(durationSeconds),
        rampUsersPerSec(sendAdvMailByIdPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scnsendMailById = scenario("sendMailByIdSimulation")
        .feed(sendMailByIdQUERYFeeder)
        .exec(http("sendMailById")
        .httpRequest("POST","/mail/send")
        .queryParam("id","${id}")
        .queryParam("fromName","${fromName}")
        .queryParam("body","${body}")
        .queryParam("subject","${subject}")
        .queryParam("toName","${toName}")
        .queryParam("to","${to}")
        .queryParam("from","${from}")
)

    // Run scnsendMailById with warm up and reach a constant rate for entire duration
    scenarioBuilders += scnsendMailById.inject(
        rampUsersPerSec(1) to(sendMailByIdPerSecond) during(rampUpSeconds),
        constantUsersPerSec(sendMailByIdPerSecond) during(durationSeconds),
        rampUsersPerSec(sendMailByIdPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scnvalidateMailOrder = scenario("validateMailOrderSimulation")
        .exec(http("validateMailOrder")
        .httpRequest("GET","/mail/order")
)

    // Run scnvalidateMailOrder with warm up and reach a constant rate for entire duration
    scenarioBuilders += scnvalidateMailOrder.inject(
        rampUsersPerSec(1) to(validateMailOrderPerSecond) during(rampUpSeconds),
        constantUsersPerSec(validateMailOrderPerSecond) during(durationSeconds),
        rampUsersPerSec(validateMailOrderPerSecond) to(1) during(rampDownSeconds)
    )

    
    val scnviewMailLogById = scenario("viewMailLogByIdSimulation")
        .feed(viewMailLogByIdQUERYFeeder)
        .exec(http("viewMailLogById")
        .httpRequest("GET","/mail/log")
        .queryParam("id","${id}")
        .queryParam("searchString","${searchString}")
        .queryParam("limit","${limit}")
        .queryParam("skip","${skip}")
)

    // Run scnviewMailLogById with warm up and reach a constant rate for entire duration
    scenarioBuilders += scnviewMailLogById.inject(
        rampUsersPerSec(1) to(viewMailLogByIdPerSecond) during(rampUpSeconds),
        constantUsersPerSec(viewMailLogByIdPerSecond) during(durationSeconds),
        rampUsersPerSec(viewMailLogByIdPerSecond) to(1) during(rampDownSeconds)
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
