// TODO: better import syntax?
import {BaseAPIRequestFactory, RequiredError, COLLECTION_FORMATS} from './baseapi';
import {Configuration} from '../configuration';
import {RequestContext, HttpMethod, ResponseContext, HttpFile, HttpInfo} from '../http/http';
import {ObjectSerializer} from '../models/ObjectSerializer';
import {ApiException} from './exception';
import {canConsumeForm, isCodeInRange} from '../util';
import {SecurityAuthentication} from '../auth/auth';


import { EmailAddressTypes } from '../models/EmailAddressTypes';
import { EmailAddressesTypes } from '../models/EmailAddressesTypes';
import { ErrorMessage } from '../models/ErrorMessage';
import { GenericResponse } from '../models/GenericResponse';
import { MailAttachment } from '../models/MailAttachment';

/**
 * no description
 */
export class SendingApiRequestFactory extends BaseAPIRequestFactory {

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 
     * Sends an Email with Advanced Options
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param _from 
     * @param to 
     * @param replyto 
     * @param cc 
     * @param bcc 
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    public async sendAdvMail(subject: string, body: string, _from: EmailAddressTypes, to: EmailAddressesTypes, replyto?: EmailAddressesTypes, cc?: EmailAddressesTypes, bcc?: EmailAddressesTypes, attachments?: Array<MailAttachment>, id?: number, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'subject' is not null or undefined
        if (subject === null || subject === undefined) {
            throw new RequiredError("SendingApi", "sendAdvMail", "subject");
        }


        // verify required parameter 'body' is not null or undefined
        if (body === null || body === undefined) {
            throw new RequiredError("SendingApi", "sendAdvMail", "body");
        }


        // verify required parameter '_from' is not null or undefined
        if (_from === null || _from === undefined) {
            throw new RequiredError("SendingApi", "sendAdvMail", "_from");
        }


        // verify required parameter 'to' is not null or undefined
        if (to === null || to === undefined) {
            throw new RequiredError("SendingApi", "sendAdvMail", "to");
        }







        // Path Params
        const localVarPath = '/mail/advsend';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Form Params
        const useForm = canConsumeForm([
            'application/x-www-form-urlencoded',
            'application/json',
        ]);

        let localVarFormParams
        if (useForm) {
            localVarFormParams = new FormData();
        } else {
            localVarFormParams = new URLSearchParams();
        }

        if (subject !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('subject', subject as any);
        }
        if (body !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('body', body as any);
        }
        if (_from !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('from', _from as any);
        }
        if (to !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('to', to as any);
        }
        if (replyto !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('replyto', replyto as any);
        }
        if (cc !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('cc', cc as any);
        }
        if (bcc !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('bcc', bcc as any);
        }
        if (attachments) {
            // TODO: replace .append with .set
            localVarFormParams.append('attachments', attachments.join(COLLECTION_FORMATS["csv"]));
        }
        if (id !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('id', id as any);
        }

        requestContext.setBody(localVarFormParams);

        if(!useForm) {
            const contentType = ObjectSerializer.getPreferredMediaType([
                "application/x-www-form-urlencoded",
            
                "application/json"
            ]);
            requestContext.setHeaderParam("Content-Type", contentType);
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

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param to The Contact whom is the primary recipient of this email.
     * @param _from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     */
    public async sendMail(to: string, _from: string, subject: string, body: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'to' is not null or undefined
        if (to === null || to === undefined) {
            throw new RequiredError("SendingApi", "sendMail", "to");
        }


        // verify required parameter '_from' is not null or undefined
        if (_from === null || _from === undefined) {
            throw new RequiredError("SendingApi", "sendMail", "_from");
        }


        // verify required parameter 'subject' is not null or undefined
        if (subject === null || subject === undefined) {
            throw new RequiredError("SendingApi", "sendMail", "subject");
        }


        // verify required parameter 'body' is not null or undefined
        if (body === null || body === undefined) {
            throw new RequiredError("SendingApi", "sendMail", "body");
        }


        // Path Params
        const localVarPath = '/mail/send';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Form Params
        const useForm = canConsumeForm([
            'application/x-www-form-urlencoded',
            'application/json',
        ]);

        let localVarFormParams
        if (useForm) {
            localVarFormParams = new FormData();
        } else {
            localVarFormParams = new URLSearchParams();
        }

        if (to !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('to', to as any);
        }
        if (_from !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('from', _from as any);
        }
        if (subject !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('subject', subject as any);
        }
        if (body !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('body', body as any);
        }

        requestContext.setBody(localVarFormParams);

        if(!useForm) {
            const contentType = ObjectSerializer.getPreferredMediaType([
                "application/x-www-form-urlencoded",
            
                "application/json"
            ]);
            requestContext.setHeaderParam("Content-Type", contentType);
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

export class SendingApiResponseProcessor {

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to sendAdvMail
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async sendAdvMailWithHttpInfo(response: ResponseContext): Promise<HttpInfo<GenericResponse >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: GenericResponse = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GenericResponse", ""
            ) as GenericResponse;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: ErrorMessage = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ErrorMessage", ""
            ) as ErrorMessage;
            throw new ApiException<ErrorMessage>(response.httpStatusCode, "Error message when there was a problem with the input parameters.", body, response.headers);
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
            throw new ApiException<ErrorMessage>(response.httpStatusCode, "The specified resource was not found", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: GenericResponse = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GenericResponse", ""
            ) as GenericResponse;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Buffer | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to sendMail
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async sendMailWithHttpInfo(response: ResponseContext): Promise<HttpInfo<GenericResponse >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: GenericResponse = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GenericResponse", ""
            ) as GenericResponse;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: ErrorMessage = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ErrorMessage", ""
            ) as ErrorMessage;
            throw new ApiException<ErrorMessage>(response.httpStatusCode, "Error message when there was a problem with the input parameters.", body, response.headers);
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
            throw new ApiException<ErrorMessage>(response.httpStatusCode, "The specified resource was not found", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: GenericResponse = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GenericResponse", ""
            ) as GenericResponse;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Buffer | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

}
