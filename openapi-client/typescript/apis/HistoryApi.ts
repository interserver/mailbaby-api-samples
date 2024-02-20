// TODO: better import syntax?
import {BaseAPIRequestFactory, RequiredError, COLLECTION_FORMATS} from './baseapi';
import {Configuration} from '../configuration';
import {RequestContext, HttpMethod, ResponseContext, HttpFile, HttpInfo} from '../http/http';
import {ObjectSerializer} from '../models/ObjectSerializer';
import {ApiException} from './exception';
import {canConsumeForm, isCodeInRange} from '../util';
import {SecurityAuthentication} from '../auth/auth';


import { ErrorMessage } from '../models/ErrorMessage';
import { GetStats200ResponseInner } from '../models/GetStats200ResponseInner';
import { MailLog } from '../models/MailLog';

/**
 * no description
 */
export class HistoryApiRequestFactory extends BaseAPIRequestFactory {

    /**
     * Returns information about the usage on your mail accounts.
     * Account usage statistics.
     */
    public async getStats(_options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // Path Params
        const localVarPath = '/mail/stats';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        let authMethod: SecurityAuthentication | undefined;
        // Apply auth methods
        authMethod = _config.authMethods["apiKeyAuth"]
        if (authMethod?.applySecurityAuthentication) {
            await authMethod?.applySecurityAuthentication(requestContext);
        }
        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param id The ID of your mail order this will be sent through.
     * @param origin originating ip address sending mail
     * @param mx mx record mail was sent to
     * @param _from from email address
     * @param to to/destination email address
     * @param subject subject containing this string
     * @param mailid mail id
     * @param skip number of records to skip for pagination
     * @param limit maximum number of records to return
     * @param startDate earliest date to get emails in unix timestamp format
     * @param endDate earliest date to get emails in unix timestamp format
     */
    public async viewMailLog(id?: number, origin?: string, mx?: string, _from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;












        // Path Params
        const localVarPath = '/mail/log';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (id !== undefined) {
            requestContext.setQueryParam("id", ObjectSerializer.serialize(id, "number", "int64"));
        }

        // Query Params
        if (origin !== undefined) {
            requestContext.setQueryParam("origin", ObjectSerializer.serialize(origin, "string", ""));
        }

        // Query Params
        if (mx !== undefined) {
            requestContext.setQueryParam("mx", ObjectSerializer.serialize(mx, "string", ""));
        }

        // Query Params
        if (_from !== undefined) {
            requestContext.setQueryParam("from", ObjectSerializer.serialize(_from, "string", ""));
        }

        // Query Params
        if (to !== undefined) {
            requestContext.setQueryParam("to", ObjectSerializer.serialize(to, "string", ""));
        }

        // Query Params
        if (subject !== undefined) {
            requestContext.setQueryParam("subject", ObjectSerializer.serialize(subject, "string", ""));
        }

        // Query Params
        if (mailid !== undefined) {
            requestContext.setQueryParam("mailid", ObjectSerializer.serialize(mailid, "string", ""));
        }

        // Query Params
        if (skip !== undefined) {
            requestContext.setQueryParam("skip", ObjectSerializer.serialize(skip, "number", "int32"));
        }

        // Query Params
        if (limit !== undefined) {
            requestContext.setQueryParam("limit", ObjectSerializer.serialize(limit, "number", "int32"));
        }

        // Query Params
        if (startDate !== undefined) {
            requestContext.setQueryParam("startDate", ObjectSerializer.serialize(startDate, "number", "int64"));
        }

        // Query Params
        if (endDate !== undefined) {
            requestContext.setQueryParam("endDate", ObjectSerializer.serialize(endDate, "number", "int64"));
        }


        let authMethod: SecurityAuthentication | undefined;
        // Apply auth methods
        authMethod = _config.authMethods["apiKeyAuth"]
        if (authMethod?.applySecurityAuthentication) {
            await authMethod?.applySecurityAuthentication(requestContext);
        }
        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

}

export class HistoryApiResponseProcessor {

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getStats
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getStatsWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Array<GetStats200ResponseInner> >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: Array<GetStats200ResponseInner> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<GetStats200ResponseInner>", ""
            ) as Array<GetStats200ResponseInner>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: ErrorMessage = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ErrorMessage", ""
            ) as ErrorMessage;
            throw new ApiException<ErrorMessage>(response.httpStatusCode, "Unauthorized", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: ErrorMessage = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ErrorMessage", ""
            ) as ErrorMessage;
            throw new ApiException<ErrorMessage>(response.httpStatusCode, "Unauthorized", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: Array<GetStats200ResponseInner> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<GetStats200ResponseInner>", ""
            ) as Array<GetStats200ResponseInner>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Buffer | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to viewMailLog
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async viewMailLogWithHttpInfo(response: ResponseContext): Promise<HttpInfo<MailLog >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: MailLog = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "MailLog", ""
            ) as MailLog;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            throw new ApiException<undefined>(response.httpStatusCode, "bad input parameter", undefined, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: MailLog = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "MailLog", ""
            ) as MailLog;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Buffer | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

}
