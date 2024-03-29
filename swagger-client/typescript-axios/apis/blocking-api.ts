/* tslint:disable */
/* eslint-disable */
/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

import globalAxios, { AxiosResponse, AxiosInstance, AxiosRequestConfig } from 'axios';
import { Configuration } from '../configuration';
// Some imports not used depending on template conditions
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, RequestArgs, BaseAPI, RequiredError } from '../base';
import { DenyRuleNew } from '../models';
import { DenyRuleRecord } from '../models';
import { ErrorMessage } from '../models';
import { GenericResponse } from '../models';
import { MailBlocks } from '../models';
/**
 * BlockingApi - axios parameter creator
 * @export
 */
export const BlockingApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * Adds a new email deny rule into the system to block new emails that match the given criteria
         * @summary Creates a new email deny rule.
         * @param {string} user 
         * @param {string} type 
         * @param {string} data 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        addRuleForm: async (user: string, type: string, data: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'user' is not null or undefined
            if (user === null || user === undefined) {
                throw new RequiredError('user','Required parameter user was null or undefined when calling addRuleForm.');
            }
            // verify required parameter 'type' is not null or undefined
            if (type === null || type === undefined) {
                throw new RequiredError('type','Required parameter type was null or undefined when calling addRuleForm.');
            }
            // verify required parameter 'data' is not null or undefined
            if (data === null || data === undefined) {
                throw new RequiredError('data','Required parameter data was null or undefined when calling addRuleForm.');
            }
            const localVarPath = `/mail/rules`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;
            const localVarFormParams = new URLSearchParams();

            // authentication apiKeyAuth required
            if (configuration && configuration.apiKey) {
                const localVarApiKeyValue = typeof configuration.apiKey === 'function'
                    ? await configuration.apiKey("X-API-KEY")
                    : await configuration.apiKey;
                localVarHeaderParameter["X-API-KEY"] = localVarApiKeyValue;
            }


            if (user !== undefined) { 
                localVarFormParams.set('user', user as any);
            }

            if (type !== undefined) { 
                localVarFormParams.set('type', type as any);
            }

            if (data !== undefined) { 
                localVarFormParams.set('data', data as any);
            }
            localVarHeaderParameter['Content-Type'] = 'application/x-www-form-urlencoded';
            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = localVarFormParams.toString();

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
        /**
         * Adds a new email deny rule into the system to block new emails that match the given criteria
         * @summary Creates a new email deny rule.
         * @param {DenyRuleNew} body These are the fields needed to create a new email deny rule.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        addRule: async (body: DenyRuleNew, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'body' is not null or undefined
            if (body === null || body === undefined) {
                throw new RequiredError('body','Required parameter body was null or undefined when calling addRule.');
            }
            const localVarPath = `/mail/rules`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;
            const localVarFormParams = new URLSearchParams();

            // authentication apiKeyAuth required
            if (configuration && configuration.apiKey) {
                const localVarApiKeyValue = typeof configuration.apiKey === 'function'
                    ? await configuration.apiKey("X-API-KEY")
                    : await configuration.apiKey;
                localVarHeaderParameter["X-API-KEY"] = localVarApiKeyValue;
            }

            localVarHeaderParameter['Content-Type'] = 'application/x-www-form-urlencoded';

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            const needsSerialization = (typeof body !== "string") || localVarRequestOptions.headers['Content-Type'] === 'application/json';
            localVarRequestOptions.data =  needsSerialization ? JSON.stringify(body !== undefined ? body : {}) : (body || "");

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
        /**
         * Removes one of the configured deny mail rules from the system.
         * @summary Removes an deny mail rule.
         * @param {number} ruleId The ID of the Rules entry.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        deleteRule: async (ruleId: number, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'ruleId' is not null or undefined
            if (ruleId === null || ruleId === undefined) {
                throw new RequiredError('ruleId','Required parameter ruleId was null or undefined when calling deleteRule.');
            }
            const localVarPath = `/mail/rules/{ruleId}`
                .replace(`{${"ruleId"}}`, encodeURIComponent(String(ruleId)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'DELETE', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication apiKeyAuth required
            if (configuration && configuration.apiKey) {
                const localVarApiKeyValue = typeof configuration.apiKey === 'function'
                    ? await configuration.apiKey("X-API-KEY")
                    : await configuration.apiKey;
                localVarHeaderParameter["X-API-KEY"] = localVarApiKeyValue;
            }

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
        /**
         * Removes an email address from the various block lists. 
         * @summary Removes an email address from the blocked list
         * @param {string} body 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        delistBlock: async (body: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'body' is not null or undefined
            if (body === null || body === undefined) {
                throw new RequiredError('body','Required parameter body was null or undefined when calling delistBlock.');
            }
            const localVarPath = `/mail/blocks/delete`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication apiKeyAuth required
            if (configuration && configuration.apiKey) {
                const localVarApiKeyValue = typeof configuration.apiKey === 'function'
                    ? await configuration.apiKey("X-API-KEY")
                    : await configuration.apiKey;
                localVarHeaderParameter["X-API-KEY"] = localVarApiKeyValue;
            }

            localVarHeaderParameter['Content-Type'] = 'application/json';

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            const needsSerialization = (typeof body !== "string") || localVarRequestOptions.headers['Content-Type'] === 'application/json';
            localVarRequestOptions.data =  needsSerialization ? JSON.stringify(body !== undefined ? body : {}) : (body || "");

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary displays a list of blocked email addresses
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getMailBlocks: async (options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/mail/blocks`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication apiKeyAuth required
            if (configuration && configuration.apiKey) {
                const localVarApiKeyValue = typeof configuration.apiKey === 'function'
                    ? await configuration.apiKey("X-API-KEY")
                    : await configuration.apiKey;
                localVarHeaderParameter["X-API-KEY"] = localVarApiKeyValue;
            }

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
        /**
         * Returns a listing of all the deny block rules you have configured.
         * @summary Displays a listing of deny email rules.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getRules: async (options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/mail/rules`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions :AxiosRequestConfig = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication apiKeyAuth required
            if (configuration && configuration.apiKey) {
                const localVarApiKeyValue = typeof configuration.apiKey === 'function'
                    ? await configuration.apiKey("X-API-KEY")
                    : await configuration.apiKey;
                localVarHeaderParameter["X-API-KEY"] = localVarApiKeyValue;
            }

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.params) {
                query.set(key, options.params[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * BlockingApi - functional programming interface
 * @export
 */
export const BlockingApiFp = function(configuration?: Configuration) {
    return {
        /**
         * Adds a new email deny rule into the system to block new emails that match the given criteria
         * @summary Creates a new email deny rule.
         * @param {string} user 
         * @param {string} type 
         * @param {string} data 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async addRuleForm(user: string, type: string, data: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<GenericResponse>>> {
            const localVarAxiosArgs = await BlockingApiAxiosParamCreator(configuration).addRuleForm(user, type, data, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         * Adds a new email deny rule into the system to block new emails that match the given criteria
         * @summary Creates a new email deny rule.
         * @param {DenyRuleNew} body These are the fields needed to create a new email deny rule.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async addRule(body: DenyRuleNew, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<GenericResponse>>> {
            const localVarAxiosArgs = await BlockingApiAxiosParamCreator(configuration).addRule(body, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         * Removes one of the configured deny mail rules from the system.
         * @summary Removes an deny mail rule.
         * @param {number} ruleId The ID of the Rules entry.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async deleteRule(ruleId: number, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<GenericResponse>>> {
            const localVarAxiosArgs = await BlockingApiAxiosParamCreator(configuration).deleteRule(ruleId, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         * Removes an email address from the various block lists. 
         * @summary Removes an email address from the blocked list
         * @param {string} body 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async delistBlock(body: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<GenericResponse>>> {
            const localVarAxiosArgs = await BlockingApiAxiosParamCreator(configuration).delistBlock(body, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         * 
         * @summary displays a list of blocked email addresses
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getMailBlocks(options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<MailBlocks>>> {
            const localVarAxiosArgs = await BlockingApiAxiosParamCreator(configuration).getMailBlocks(options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         * Returns a listing of all the deny block rules you have configured.
         * @summary Displays a listing of deny email rules.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getRules(options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => Promise<AxiosResponse<Array<DenyRuleRecord>>>> {
            const localVarAxiosArgs = await BlockingApiAxiosParamCreator(configuration).getRules(options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs :AxiosRequestConfig = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
    }
};

/**
 * BlockingApi - factory interface
 * @export
 */
export const BlockingApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    return {
        /**
         * Adds a new email deny rule into the system to block new emails that match the given criteria
         * @summary Creates a new email deny rule.
         * @param {string} user 
         * @param {string} type 
         * @param {string} data 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async addRuleForm(user: string, type: string, data: string, options?: AxiosRequestConfig): Promise<AxiosResponse<GenericResponse>> {
            return BlockingApiFp(configuration).addRuleForm(user, type, data, options).then((request) => request(axios, basePath));
        },
        /**
         * Adds a new email deny rule into the system to block new emails that match the given criteria
         * @summary Creates a new email deny rule.
         * @param {DenyRuleNew} body These are the fields needed to create a new email deny rule.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async addRule(body: DenyRuleNew, options?: AxiosRequestConfig): Promise<AxiosResponse<GenericResponse>> {
            return BlockingApiFp(configuration).addRule(body, options).then((request) => request(axios, basePath));
        },
        /**
         * Removes one of the configured deny mail rules from the system.
         * @summary Removes an deny mail rule.
         * @param {number} ruleId The ID of the Rules entry.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async deleteRule(ruleId: number, options?: AxiosRequestConfig): Promise<AxiosResponse<GenericResponse>> {
            return BlockingApiFp(configuration).deleteRule(ruleId, options).then((request) => request(axios, basePath));
        },
        /**
         * Removes an email address from the various block lists. 
         * @summary Removes an email address from the blocked list
         * @param {string} body 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async delistBlock(body: string, options?: AxiosRequestConfig): Promise<AxiosResponse<GenericResponse>> {
            return BlockingApiFp(configuration).delistBlock(body, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary displays a list of blocked email addresses
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getMailBlocks(options?: AxiosRequestConfig): Promise<AxiosResponse<MailBlocks>> {
            return BlockingApiFp(configuration).getMailBlocks(options).then((request) => request(axios, basePath));
        },
        /**
         * Returns a listing of all the deny block rules you have configured.
         * @summary Displays a listing of deny email rules.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getRules(options?: AxiosRequestConfig): Promise<AxiosResponse<Array<DenyRuleRecord>>> {
            return BlockingApiFp(configuration).getRules(options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * BlockingApi - object-oriented interface
 * @export
 * @class BlockingApi
 * @extends {BaseAPI}
 */
export class BlockingApi extends BaseAPI {
    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * @summary Creates a new email deny rule.
     * @param {string} user 
     * @param {string} type 
     * @param {string} data 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof BlockingApi
     */
    public async addRuleForm(user: string, type: string, data: string, options?: AxiosRequestConfig) : Promise<AxiosResponse<GenericResponse>> {
        return BlockingApiFp(this.configuration).addRuleForm(user, type, data, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * @summary Creates a new email deny rule.
     * @param {DenyRuleNew} body These are the fields needed to create a new email deny rule.
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof BlockingApi
     */
    public async addRule(body: DenyRuleNew, options?: AxiosRequestConfig) : Promise<AxiosResponse<GenericResponse>> {
        return BlockingApiFp(this.configuration).addRule(body, options).then((request) => request(this.axios, this.basePath));
    }
    /**
     * Removes one of the configured deny mail rules from the system.
     * @summary Removes an deny mail rule.
     * @param {number} ruleId The ID of the Rules entry.
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof BlockingApi
     */
    public async deleteRule(ruleId: number, options?: AxiosRequestConfig) : Promise<AxiosResponse<GenericResponse>> {
        return BlockingApiFp(this.configuration).deleteRule(ruleId, options).then((request) => request(this.axios, this.basePath));
    }
    /**
     * Removes an email address from the various block lists. 
     * @summary Removes an email address from the blocked list
     * @param {string} body 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof BlockingApi
     */
    public async delistBlock(body: string, options?: AxiosRequestConfig) : Promise<AxiosResponse<GenericResponse>> {
        return BlockingApiFp(this.configuration).delistBlock(body, options).then((request) => request(this.axios, this.basePath));
    }
    /**
     * 
     * @summary displays a list of blocked email addresses
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof BlockingApi
     */
    public async getMailBlocks(options?: AxiosRequestConfig) : Promise<AxiosResponse<MailBlocks>> {
        return BlockingApiFp(this.configuration).getMailBlocks(options).then((request) => request(this.axios, this.basePath));
    }
    /**
     * Returns a listing of all the deny block rules you have configured.
     * @summary Displays a listing of deny email rules.
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof BlockingApi
     */
    public async getRules(options?: AxiosRequestConfig) : Promise<AxiosResponse<Array<DenyRuleRecord>>> {
        return BlockingApiFp(this.configuration).getRules(options).then((request) => request(this.axios, this.basePath));
    }
}
