// tslint:disable
/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import { HttpMethods, QueryConfig, ResponseBody, ResponseText } from 'redux-query';
import * as runtime from '../runtime';
import {
    GetMailOrders401Response,
    GetMailOrders401ResponseFromJSON,
    GetMailOrders401ResponseToJSON,
    GetStats200ResponseInner,
    GetStats200ResponseInnerFromJSON,
    GetStats200ResponseInnerToJSON,
    MailLog,
    MailLogFromJSON,
    MailLogToJSON,
} from '../models';

export interface ViewMailLogRequest {
    id?: number;
    origin?: string;
    mx?: string;
    from?: string;
    to?: string;
    subject?: string;
    mailid?: string;
    skip?: number;
    limit?: number;
    startDate?: number;
    endDate?: number;
}


/**
 * displays a list of blocked email addresses
 */
function getStatsRaw<T>( requestConfig: runtime.TypedQueryConfig<T, Array<GetStats200ResponseInner>> = {}): QueryConfig<T> {
    let queryParameters = null;


    const headerParameters : runtime.HttpHeaders = {};


    const { meta = {} } = requestConfig;

    meta.authType = ['api_key', 'header'];
    const config: QueryConfig<T> = {
        url: `${runtime.Configuration.basePath}/mail/stats`,
        meta,
        update: requestConfig.update,
        queryKey: requestConfig.queryKey,
        optimisticUpdate: requestConfig.optimisticUpdate,
        force: requestConfig.force,
        rollback: requestConfig.rollback,
        options: {
            method: 'GET',
            headers: headerParameters,
        },
        body: queryParameters,
    };

    const { transform: requestTransform } = requestConfig;
    if (requestTransform) {
        config.transform = (body: ResponseBody, text: ResponseBody) => requestTransform(body.map(GetStats200ResponseInnerFromJSON), text);
    }

    return config;
}

/**
* displays a list of blocked email addresses
*/
export function getStats<T>( requestConfig?: runtime.TypedQueryConfig<T, Array<GetStats200ResponseInner>>): QueryConfig<T> {
    return getStatsRaw( requestConfig);
}

/**
 * Get a listing of the emails sent through this system 
 * displays the mail log
 */
function viewMailLogRaw<T>(requestParameters: ViewMailLogRequest, requestConfig: runtime.TypedQueryConfig<T, MailLog> = {}): QueryConfig<T> {
    let queryParameters = null;

    queryParameters = {};


    if (requestParameters.id !== undefined) {
        queryParameters['id'] = requestParameters.id;
    }


    if (requestParameters.origin !== undefined) {
        queryParameters['origin'] = requestParameters.origin;
    }


    if (requestParameters.mx !== undefined) {
        queryParameters['mx'] = requestParameters.mx;
    }


    if (requestParameters.from !== undefined) {
        queryParameters['from'] = requestParameters.from;
    }


    if (requestParameters.to !== undefined) {
        queryParameters['to'] = requestParameters.to;
    }


    if (requestParameters.subject !== undefined) {
        queryParameters['subject'] = requestParameters.subject;
    }


    if (requestParameters.mailid !== undefined) {
        queryParameters['mailid'] = requestParameters.mailid;
    }


    if (requestParameters.skip !== undefined) {
        queryParameters['skip'] = requestParameters.skip;
    }


    if (requestParameters.limit !== undefined) {
        queryParameters['limit'] = requestParameters.limit;
    }


    if (requestParameters.startDate !== undefined) {
        queryParameters['startDate'] = requestParameters.startDate;
    }


    if (requestParameters.endDate !== undefined) {
        queryParameters['endDate'] = requestParameters.endDate;
    }

    const headerParameters : runtime.HttpHeaders = {};


    const { meta = {} } = requestConfig;

    meta.authType = ['api_key', 'header'];
    const config: QueryConfig<T> = {
        url: `${runtime.Configuration.basePath}/mail/log`,
        meta,
        update: requestConfig.update,
        queryKey: requestConfig.queryKey,
        optimisticUpdate: requestConfig.optimisticUpdate,
        force: requestConfig.force,
        rollback: requestConfig.rollback,
        options: {
            method: 'GET',
            headers: headerParameters,
        },
        body: queryParameters,
    };

    const { transform: requestTransform } = requestConfig;
    if (requestTransform) {
        config.transform = (body: ResponseBody, text: ResponseBody) => requestTransform(MailLogFromJSON(body), text);
    }

    return config;
}

/**
* Get a listing of the emails sent through this system 
* displays the mail log
*/
export function viewMailLog<T>(requestParameters: ViewMailLogRequest, requestConfig?: runtime.TypedQueryConfig<T, MailLog>): QueryConfig<T> {
    return viewMailLogRaw(requestParameters, requestConfig);
}
