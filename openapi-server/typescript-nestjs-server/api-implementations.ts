import { Type } from '@nestjs/common';
import { BlockingApi } from './api';
import { HistoryApi } from './api';
import { SendingApi } from './api';
import { ServicesApi } from './api';
import { StatusApi } from './api';

/**
 * Provide this type to {@link ApiModule} to provide your API implementations
**/
export type ApiImplementations = {
  blockingApi: Type<BlockingApi>
  historyApi: Type<HistoryApi>
  sendingApi: Type<SendingApi>
  servicesApi: Type<ServicesApi>
  statusApi: Type<StatusApi>
};
