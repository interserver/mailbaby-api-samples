package org.openapitools.vertxweb.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.openapi.RouterBuilder;
import io.vertx.ext.web.openapi.RouterBuilderOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openapitools.vertxweb.server.api.BlockingApiHandler;
import org.openapitools.vertxweb.server.api.BlockingApiImpl;
import org.openapitools.vertxweb.server.api.HistoryApiHandler;
import org.openapitools.vertxweb.server.api.HistoryApiImpl;
import org.openapitools.vertxweb.server.api.SendingApiHandler;
import org.openapitools.vertxweb.server.api.SendingApiImpl;
import org.openapitools.vertxweb.server.api.ServicesApiHandler;
import org.openapitools.vertxweb.server.api.ServicesApiImpl;
import org.openapitools.vertxweb.server.api.StatusApiHandler;
import org.openapitools.vertxweb.server.api.StatusApiImpl;

public class HttpServerVerticle extends AbstractVerticle {

    private static final Logger logger = LoggerFactory.getLogger(HttpServerVerticle.class);
    private static final String specFile = "src/main/resources/openapi.yaml";

    
    private final BlockingApiHandler blockingHandler = new BlockingApiHandler(new BlockingApiImpl());
    private final HistoryApiHandler historyHandler = new HistoryApiHandler(new HistoryApiImpl());
    private final SendingApiHandler sendingHandler = new SendingApiHandler(new SendingApiImpl());
    private final ServicesApiHandler servicesHandler = new ServicesApiHandler(new ServicesApiImpl());
    private final StatusApiHandler statusHandler = new StatusApiHandler(new StatusApiImpl());

    @Override
    public void start(Promise<Void> startPromise) {
        RouterBuilder.create(vertx, specFile)
            .map(builder -> {
              builder.setOptions(new RouterBuilderOptions()
                  // For production use case, you need to enable this flag and provide the proper security handler
                  .setRequireSecurityHandlers(false)
              );
              
              blockingHandler.mount(builder);
              historyHandler.mount(builder);
              sendingHandler.mount(builder);
              servicesHandler.mount(builder);
              statusHandler.mount(builder);

              Router router = builder.createRouter();
              router.errorHandler(400, this::validationFailureHandler);

              return router;
            })
            .compose(router ->
                vertx.createHttpServer()
                    .requestHandler(router)
                    .listen(8080)
            )
            .onSuccess(server -> logger.info("Http verticle deploy successful"))
            .onFailure(t -> logger.error("Http verticle failed to deploy", t))
            // Complete the start promise
            .<Void>mapEmpty().onComplete(startPromise);
    }

    private void validationFailureHandler(RoutingContext rc) {
         rc.response().setStatusCode(400)
                 .end("Bad Request : " + rc.failure().getMessage());
    }
}
