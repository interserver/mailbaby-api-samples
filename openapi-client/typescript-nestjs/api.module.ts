import { DynamicModule, HttpService, HttpModule, Module, Global, Provider } from '@nestjs/common';
import { AsyncConfiguration, Configuration, ConfigurationFactory } from './configuration';

import { BlockingService } from './api/blocking.service';
import { HistoryService } from './api/history.service';
import { SendingService } from './api/sending.service';
import { ServicesService } from './api/services.service';
import { StatusService } from './api/status.service';

@Global()
@Module({
  imports:      [ HttpModule ],
  exports:      [
    BlockingService,
    HistoryService,
    SendingService,
    ServicesService,
    StatusService
  ],
  providers: [
    BlockingService,
    HistoryService,
    SendingService,
    ServicesService,
    StatusService
  ]
})
export class ApiModule {
    public static forRoot(configurationFactory: () => Configuration): DynamicModule {
        return {
            module: ApiModule,
            providers: [ { provide: Configuration, useFactory: configurationFactory } ]
        };
    }

    /**
     * Register the module asynchronously.
     */
    static forRootAsync(options: AsyncConfiguration): DynamicModule {
        const providers = [...this.createAsyncProviders(options)];
        return {
            module: ApiModule,
            imports: options.imports || [],
            providers,
            exports: providers,
        };
    }

    private static createAsyncProviders(options: AsyncConfiguration): Provider[] {
        if (options.useClass) {
            return [
                this.createAsyncConfigurationProvider(options),
                {
                    provide: options.useClass,
                    useClass: options.useClass,
                },
            ];
        }
        return [this.createAsyncConfigurationProvider(options)];
    }

    private static createAsyncConfigurationProvider(
        options: AsyncConfiguration,
    ): Provider {
        if (options.useFactory) {
            return {
                provide: Configuration,
                useFactory: options.useFactory,
                inject: options.inject || [],
            };
        }
        return {
            provide: Configuration,
            useFactory: async (optionsFactory: ConfigurationFactory) =>
                await optionsFactory.createConfiguration(),
            inject: (options.useExisting && [options.useExisting]) || (options.useClass && [options.useClass]) || [],
        };
    }

    constructor( httpService: HttpService) { }
}
