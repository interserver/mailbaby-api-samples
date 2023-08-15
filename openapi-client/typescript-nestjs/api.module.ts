import { DynamicModule, HttpService, HttpModule, Module, Global } from '@nestjs/common';
import { Configuration } from './configuration';

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

    constructor( httpService: HttpService) { }
}
