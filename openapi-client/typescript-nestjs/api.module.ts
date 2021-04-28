import { DynamicModule, HttpService, HttpModule, Module, Global } from '@nestjs/common';
import { Configuration } from './configuration';

import { DefaultService } from './api/default.service';

@Global()
@Module({
  imports:      [ HttpModule ],
  exports:      [
    DefaultService
  ],
  providers: [
    DefaultService
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
