import { DynamicModule, Module, Provider } from '@nestjs/common';
import { ApiImplementations } from './api-implementations'
import { BlockingApi } from './api';
import { BlockingApiController } from './controllers';
import { HistoryApi } from './api';
import { HistoryApiController } from './controllers';
import { SendingApi } from './api';
import { SendingApiController } from './controllers';
import { ServicesApi } from './api';
import { ServicesApiController } from './controllers';
import { StatusApi } from './api';
import { StatusApiController } from './controllers';

export type ApiModuleConfiguration = {
  /**
  * your Api implementations
  */
  apiImplementations: ApiImplementations,
  /**
  * additional Providers that may be used by your implementations
  */
  providers?: Provider[],
}

@Module({})
export class ApiModule {
  static forRoot(configuration: ApiModuleConfiguration): DynamicModule {
      const providers: Provider[] = [
        {
          provide: BlockingApi,
          useClass: configuration.apiImplementations.blockingApi
        },
        {
          provide: HistoryApi,
          useClass: configuration.apiImplementations.historyApi
        },
        {
          provide: SendingApi,
          useClass: configuration.apiImplementations.sendingApi
        },
        {
          provide: ServicesApi,
          useClass: configuration.apiImplementations.servicesApi
        },
        {
          provide: StatusApi,
          useClass: configuration.apiImplementations.statusApi
        },
        ...(configuration.providers || []),
      ];

      return {
        module: ApiModule,
        controllers: [
          BlockingApiController,
          HistoryApiController,
          SendingApiController,
          ServicesApiController,
          StatusApiController,
        ],
        providers: [...providers],
        exports: [...providers]
      }
    }
}