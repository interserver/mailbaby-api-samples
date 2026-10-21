import com.google.inject.AbstractModule;

import controllers.*;
import openapitools.SecurityAPIUtils;

public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(BlockingApiControllerImpInterface.class).to(BlockingApiControllerImp.class);
        bind(HistoryApiControllerImpInterface.class).to(HistoryApiControllerImp.class);
        bind(SendingApiControllerImpInterface.class).to(SendingApiControllerImp.class);
        bind(ServicesApiControllerImpInterface.class).to(ServicesApiControllerImp.class);
        bind(StatusApiControllerImpInterface.class).to(StatusApiControllerImp.class);
        bind(SecurityAPIUtils.class);
    }
}