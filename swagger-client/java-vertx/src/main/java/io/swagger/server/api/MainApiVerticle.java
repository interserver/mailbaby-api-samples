package io.swagger.server.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApiVerticle extends AbstractVerticle {
    static final Logger LOGGER = LoggerFactory.getLogger(MainApiVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
    vertx.deployVerticle("io.swagger.server.api.verticle.MailBabyEmailDeliveryAndManagementService_Verticle")
      .onFailure(error -> {
        LOGGER.error("MailBabyEmailDeliveryAndManagementService_Verticle : Deployment failed");
        startPromise.fail(error);
      })
      .onSuccess(server -> {
        LOGGER.info("MailBabyEmailDeliveryAndManagementService_Verticle : Deployed");
        startPromise.complete();
      });
    }
    

}
