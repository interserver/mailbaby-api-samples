import {interfaces} from 'inversify';

import { BlockingService } from './api/blocking.service';
import { HistoryService } from './api/history.service';
import { SendingService } from './api/sending.service';
import { ServicesService } from './api/services.service';
import { StatusService } from './api/status.service';

export class ApiServiceBinder {
    public static with(container: interfaces.Container) {
        container.bind<BlockingService>('BlockingService').to(BlockingService).inSingletonScope();
        container.bind<HistoryService>('HistoryService').to(HistoryService).inSingletonScope();
        container.bind<SendingService>('SendingService').to(SendingService).inSingletonScope();
        container.bind<ServicesService>('ServicesService').to(ServicesService).inSingletonScope();
        container.bind<StatusService>('StatusService').to(StatusService).inSingletonScope();
    }
}
