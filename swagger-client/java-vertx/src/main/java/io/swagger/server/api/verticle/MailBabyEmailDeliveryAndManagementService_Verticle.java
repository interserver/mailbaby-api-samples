package io.swagger.server.api.verticle;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.openapi.RouterBuilder;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.openapi.RouterBuilderOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailBabyEmailDeliveryAndManagementService_Verticle extends AbstractVerticle {
    static final Logger LOGGER = LoggerFactory.getLogger(MailBabyEmailDeliveryAndManagementService_Verticle.class);

    HttpServer server;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      RouterBuilder.create(this.vertx, "openapi.yaml")
      .flatMap(routerBuilder -> { 
    
        RouterBuilderOptions factoryOptions = new RouterBuilderOptions()
          .setRequireSecurityHandlers(false)
          .setMountResponseContentTypeHandler(true);
        routerBuilder.setOptions(factoryOptions);

        routerBuilder.mountServicesFromExtensions();

        return Future.succeededFuture(routerBuilder.createRouter());
      })
      .flatMap(openapiRouter -> {
        Router router = Router.router(vertx);

        server = vertx.createHttpServer(new HttpServerOptions().setPort(8080).setHost("localhost"))
          .requestHandler(router);

        router.route("/*").subRouter(openapiRouter);

        router.route().last().handler(context ->
          context.response()
            .setStatusCode(404)
            .end(new JsonObject()
              .put("message", "Resource not found")
              .encode())
        );

        
      return server.listen()
          .onSuccess(server -> LOGGER.info("MailBabyEmailDeliveryAndManagementService_Verticle started on port " + server.actualPort()));
      })
      .onSuccess(server -> startPromise.complete())
      .onFailure(startPromise::fail);
    }

  @Override
  public void stop(Promise<Void> stopPromise) throws Exception {
    this.server.close()
      .onSuccess(server -> stopPromise.complete())
      .onFailure(stopPromise::fail);
  }

}
