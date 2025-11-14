export * from './blockingApi';
import { BlockingApi } from './blockingApi';
export * from './historyApi';
import { HistoryApi } from './historyApi';
export * from './sendingApi';
import { SendingApi } from './sendingApi';
export * from './servicesApi';
import { ServicesApi } from './servicesApi';
export * from './statusApi';
import { StatusApi } from './statusApi';
import * as http from 'http';

export class HttpError extends Error {
    constructor (public response: http.IncomingMessage, public body: any, public statusCode?: number) {
        super('HTTP request failed');
        this.name = 'HttpError';
    }
}

export { RequestFile } from '../model/models';

export const APIS = [BlockingApi, HistoryApi, SendingApi, ServicesApi, StatusApi];
