package org.openapitools.server;

import org.openapitools.server.api.BlockingServiceImpl;
import org.openapitools.server.api.HistoryServiceImpl;
import org.openapitools.server.api.SendingServiceImpl;
import org.openapitools.server.api.ServicesServiceImpl;
import org.openapitools.server.api.StatusServiceImpl;

import io.helidon.logging.common.LogConfig;
import io.helidon.config.Config;
import io.helidon.webserver.http.HttpRouting;
import io.helidon.webserver.WebServer;

/**
* The application main class.
*/
public final class Main {

    /**
    * Cannot be instantiated.
    */
    private Main() {
    }

    /**
    * Application main entry point.
    * @param args command line arguments.
    */
    public static void main(final String[] args) {
        startServer();
    }

    /**
    * Start the server.
    * @return the created {@link WebServer} instance
    */
    static WebServer startServer() {

        // load logging configuration
        LogConfig.configureRuntime();

        // By default this will pick up application.yaml from the classpath
        Config config = Config.create();
        Config.global(config);

        WebServer webserver = WebServer.builder()
                .config(config.get("server"))
                .routing(Main::routing)
                .build()
                .start();

        System.out.println("WEB server is up! https://api.mailbaby.net");

        return webserver;
    }

    /**
     * Updates HTTP routing and implicitly registers observe providers.
     */
    static void routing(HttpRouting.Builder routing) {
        routing
            .register("/mail", new BlockingServiceImpl())
            .register("/mail", new HistoryServiceImpl())
            .register("/mail", new SendingServiceImpl())
            .register("/mail", new ServicesServiceImpl())
            .register("/ping", new StatusServiceImpl());
    }
}
