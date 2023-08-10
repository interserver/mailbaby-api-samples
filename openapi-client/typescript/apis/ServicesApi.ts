// TODO: better import syntax?
import {BaseAPIRequestFactory, RequiredError, COLLECTION_FORMATS} from './baseapi';
import {Configuration} from '../configuration';
import {RequestContext, HttpMethod, ResponseContext, HttpFile} from '../http/http';
import {ObjectSerializer} from '../models/ObjectSerializer';
import {ApiException} from './exception';
import {canConsumeForm, isCodeInRange} from '../util';
import {SecurityAuthentication} from '../auth/auth';


import { GetMailOrders401Response } from '../models/GetMailOrders401Response';
import { MailOrder } from '../models/MailOrder';

/**
 * no description
 */
export class ServicesApiRequestFactory extends BaseAPIRequestFactory {

    /**
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * displays a list of mail service orders
     */
    public async getMailOrders(_options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // Path Params
        const localVarPath = '/mail';

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

}

export class ServicesApiResponseProcessor {

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getMailOrders
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getMailOrders(response: ResponseContext): Promise<Array<MailOrder> > {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: Array<MailOrder> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<MailOrder>", ""
            ) as Array<MailOrder>;
            return body;
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: GetMailOrders401Response = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetMailOrders401Response", ""
            ) as GetMailOrders401Response;
            throw new ApiException<GetMailOrders401Response>(response.httpStatusCode, "Unauthorized", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: GetMailOrders401Response = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetMailOrders401Response", ""
            ) as GetMailOrders401Response;
            throw new ApiException<GetMailOrders401Response>(response.httpStatusCode, "Unauthorized", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: Array<MailOrder> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<MailOrder>", ""
            ) as Array<MailOrder>;
            return body;
        }

        throw new ApiException<string | Buffer | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

}
