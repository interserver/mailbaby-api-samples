# Helidon SE Server with OpenAPI

## Build and run

With JDK11+
```bash
mvn package
java -jar target/openapi-java-server.jar
```

## Exercise the application

```
curl -X POST https://api.mailbaby.net/mail/rules
curl -X DELETE https://api.mailbaby.net/mail/rules/{ruleId}
curl -X POST https://api.mailbaby.net/mail/blocks/delete
curl -X GET https://api.mailbaby.net/mail/blocks
curl -X GET https://api.mailbaby.net/mail/rules
curl -X GET https://api.mailbaby.net/mail/stats
curl -X GET https://api.mailbaby.net/mail/log
curl -X POST https://api.mailbaby.net/mail/rawsend
curl -X POST https://api.mailbaby.net/mail/advsend
curl -X POST https://api.mailbaby.net/mail/send
curl -X GET https://api.mailbaby.net/mail/{id}
curl -X GET https://api.mailbaby.net/mail
curl -X GET https://api.mailbaby.net/ping

```

## Try health and metrics

```
curl -s -X GET https://api.mailbaby.net/health
{"outcome":"UP",...
. . .

# Prometheus Format
curl -s -X GET https://api.mailbaby.net/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET https://api.mailbaby.net/metrics
{"base":...
. . .
```