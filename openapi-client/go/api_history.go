/*
MailBaby Email Delivery and Management Service API

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

API version: 1.1.0
Contact: support@interserver.net
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package openapi

import (
	"bytes"
	"context"
	"io"
	"net/http"
	"net/url"
)


// HistoryAPIService HistoryAPI service
type HistoryAPIService service

type ApiGetStatsRequest struct {
	ctx context.Context
	ApiService *HistoryAPIService
	time *string
}

// The timeframe for the statistics.
func (r ApiGetStatsRequest) Time(time string) ApiGetStatsRequest {
	r.time = &time
	return r
}

func (r ApiGetStatsRequest) Execute() (*MailStatsType, *http.Response, error) {
	return r.ApiService.GetStatsExecute(r)
}

/*
GetStats Account usage statistics.

Returns information about the usage on your mail accounts.

 @param ctx context.Context - for authentication, logging, cancellation, deadlines, tracing, etc. Passed from http.Request or context.Background().
 @return ApiGetStatsRequest
*/
func (a *HistoryAPIService) GetStats(ctx context.Context) ApiGetStatsRequest {
	return ApiGetStatsRequest{
		ApiService: a,
		ctx: ctx,
	}
}

// Execute executes the request
//  @return MailStatsType
func (a *HistoryAPIService) GetStatsExecute(r ApiGetStatsRequest) (*MailStatsType, *http.Response, error) {
	var (
		localVarHTTPMethod   = http.MethodGet
		localVarPostBody     interface{}
		formFiles            []formFile
		localVarReturnValue  *MailStatsType
	)

	localBasePath, err := a.client.cfg.ServerURLWithContext(r.ctx, "HistoryAPIService.GetStats")
	if err != nil {
		return localVarReturnValue, nil, &GenericOpenAPIError{error: err.Error()}
	}

	localVarPath := localBasePath + "/mail/stats"

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	if r.time != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "time", r.time, "form", "")
	}
	// to determine the Content-Type header
	localVarHTTPContentTypes := []string{}

	// set Content-Type header
	localVarHTTPContentType := selectHeaderContentType(localVarHTTPContentTypes)
	if localVarHTTPContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHTTPContentType
	}

	// to determine the Accept header
	localVarHTTPHeaderAccepts := []string{"application/json"}

	// set Accept header
	localVarHTTPHeaderAccept := selectHeaderAccept(localVarHTTPHeaderAccepts)
	if localVarHTTPHeaderAccept != "" {
		localVarHeaderParams["Accept"] = localVarHTTPHeaderAccept
	}
	if r.ctx != nil {
		// API Key Authentication
		if auth, ok := r.ctx.Value(ContextAPIKeys).(map[string]APIKey); ok {
			if apiKey, ok := auth["apiKeyAuth"]; ok {
				var key string
				if apiKey.Prefix != "" {
					key = apiKey.Prefix + " " + apiKey.Key
				} else {
					key = apiKey.Key
				}
				localVarHeaderParams["X-API-KEY"] = key
			}
		}
	}
	req, err := a.client.prepareRequest(r.ctx, localVarPath, localVarHTTPMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, formFiles)
	if err != nil {
		return localVarReturnValue, nil, err
	}

	localVarHTTPResponse, err := a.client.callAPI(req)
	if err != nil || localVarHTTPResponse == nil {
		return localVarReturnValue, localVarHTTPResponse, err
	}

	localVarBody, err := io.ReadAll(localVarHTTPResponse.Body)
	localVarHTTPResponse.Body.Close()
	localVarHTTPResponse.Body = io.NopCloser(bytes.NewBuffer(localVarBody))
	if err != nil {
		return localVarReturnValue, localVarHTTPResponse, err
	}

	if localVarHTTPResponse.StatusCode >= 300 {
		newErr := &GenericOpenAPIError{
			body:  localVarBody,
			error: localVarHTTPResponse.Status,
		}
		if localVarHTTPResponse.StatusCode == 401 {
			var v ErrorMessage
			err = a.client.decode(&v, localVarBody, localVarHTTPResponse.Header.Get("Content-Type"))
			if err != nil {
				newErr.error = err.Error()
				return localVarReturnValue, localVarHTTPResponse, newErr
			}
					newErr.error = formatErrorMessage(localVarHTTPResponse.Status, &v)
					newErr.model = v
			return localVarReturnValue, localVarHTTPResponse, newErr
		}
		if localVarHTTPResponse.StatusCode == 404 {
			var v ErrorMessage
			err = a.client.decode(&v, localVarBody, localVarHTTPResponse.Header.Get("Content-Type"))
			if err != nil {
				newErr.error = err.Error()
				return localVarReturnValue, localVarHTTPResponse, newErr
			}
					newErr.error = formatErrorMessage(localVarHTTPResponse.Status, &v)
					newErr.model = v
		}
		return localVarReturnValue, localVarHTTPResponse, newErr
	}

	err = a.client.decode(&localVarReturnValue, localVarBody, localVarHTTPResponse.Header.Get("Content-Type"))
	if err != nil {
		newErr := &GenericOpenAPIError{
			body:  localVarBody,
			error: err.Error(),
		}
		return localVarReturnValue, localVarHTTPResponse, newErr
	}

	return localVarReturnValue, localVarHTTPResponse, nil
}

type ApiViewMailLogRequest struct {
	ctx context.Context
	ApiService *HistoryAPIService
	id *int64
	origin *string
	mx *string
	from *string
	to *string
	subject *string
	mailid *string
	skip *int32
	limit *int32
	startDate *int64
	endDate *int64
	replyto *string
	headerfrom *string
	delivered *string
}

// The ID of your mail order this will be sent through.
func (r ApiViewMailLogRequest) Id(id int64) ApiViewMailLogRequest {
	r.id = &id
	return r
}

// originating ip address sending mail
func (r ApiViewMailLogRequest) Origin(origin string) ApiViewMailLogRequest {
	r.origin = &origin
	return r
}

// mx record mail was sent to
func (r ApiViewMailLogRequest) Mx(mx string) ApiViewMailLogRequest {
	r.mx = &mx
	return r
}

// from email address
func (r ApiViewMailLogRequest) From(from string) ApiViewMailLogRequest {
	r.from = &from
	return r
}

// to/destination email address
func (r ApiViewMailLogRequest) To(to string) ApiViewMailLogRequest {
	r.to = &to
	return r
}

// subject containing this string
func (r ApiViewMailLogRequest) Subject(subject string) ApiViewMailLogRequest {
	r.subject = &subject
	return r
}

// mail id
func (r ApiViewMailLogRequest) Mailid(mailid string) ApiViewMailLogRequest {
	r.mailid = &mailid
	return r
}

// number of records to skip for pagination
func (r ApiViewMailLogRequest) Skip(skip int32) ApiViewMailLogRequest {
	r.skip = &skip
	return r
}

// maximum number of records to return
func (r ApiViewMailLogRequest) Limit(limit int32) ApiViewMailLogRequest {
	r.limit = &limit
	return r
}

// earliest date to get emails in unix timestamp format
func (r ApiViewMailLogRequest) StartDate(startDate int64) ApiViewMailLogRequest {
	r.startDate = &startDate
	return r
}

// earliest date to get emails in unix timestamp format
func (r ApiViewMailLogRequest) EndDate(endDate int64) ApiViewMailLogRequest {
	r.endDate = &endDate
	return r
}

// Reply-To Email Address
func (r ApiViewMailLogRequest) Replyto(replyto string) ApiViewMailLogRequest {
	r.replyto = &replyto
	return r
}

// Header From Email Address
func (r ApiViewMailLogRequest) Headerfrom(headerfrom string) ApiViewMailLogRequest {
	r.headerfrom = &headerfrom
	return r
}

// Limiting the emails to wether or not they were delivered.
func (r ApiViewMailLogRequest) Delivered(delivered string) ApiViewMailLogRequest {
	r.delivered = &delivered
	return r
}

func (r ApiViewMailLogRequest) Execute() (*MailLog, *http.Response, error) {
	return r.ApiService.ViewMailLogExecute(r)
}

/*
ViewMailLog displays the mail log

Get a listing of the emails sent through this system


 @param ctx context.Context - for authentication, logging, cancellation, deadlines, tracing, etc. Passed from http.Request or context.Background().
 @return ApiViewMailLogRequest
*/
func (a *HistoryAPIService) ViewMailLog(ctx context.Context) ApiViewMailLogRequest {
	return ApiViewMailLogRequest{
		ApiService: a,
		ctx: ctx,
	}
}

// Execute executes the request
//  @return MailLog
func (a *HistoryAPIService) ViewMailLogExecute(r ApiViewMailLogRequest) (*MailLog, *http.Response, error) {
	var (
		localVarHTTPMethod   = http.MethodGet
		localVarPostBody     interface{}
		formFiles            []formFile
		localVarReturnValue  *MailLog
	)

	localBasePath, err := a.client.cfg.ServerURLWithContext(r.ctx, "HistoryAPIService.ViewMailLog")
	if err != nil {
		return localVarReturnValue, nil, &GenericOpenAPIError{error: err.Error()}
	}

	localVarPath := localBasePath + "/mail/log"

	localVarHeaderParams := make(map[string]string)
	localVarQueryParams := url.Values{}
	localVarFormParams := url.Values{}

	if r.id != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "id", r.id, "form", "")
	}
	if r.origin != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "origin", r.origin, "form", "")
	}
	if r.mx != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "mx", r.mx, "form", "")
	}
	if r.from != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "from", r.from, "form", "")
	}
	if r.to != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "to", r.to, "form", "")
	}
	if r.subject != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "subject", r.subject, "form", "")
	}
	if r.mailid != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "mailid", r.mailid, "form", "")
	}
	if r.skip != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "skip", r.skip, "form", "")
	} else {
		var defaultValue int32 = 0
		r.skip = &defaultValue
	}
	if r.limit != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "limit", r.limit, "form", "")
	} else {
		var defaultValue int32 = 100
		r.limit = &defaultValue
	}
	if r.startDate != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "startDate", r.startDate, "form", "")
	}
	if r.endDate != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "endDate", r.endDate, "form", "")
	}
	if r.replyto != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "replyto", r.replyto, "form", "")
	}
	if r.headerfrom != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "headerfrom", r.headerfrom, "form", "")
	}
	if r.delivered != nil {
		parameterAddToHeaderOrQuery(localVarQueryParams, "delivered", r.delivered, "form", "")
	}
	// to determine the Content-Type header
	localVarHTTPContentTypes := []string{}

	// set Content-Type header
	localVarHTTPContentType := selectHeaderContentType(localVarHTTPContentTypes)
	if localVarHTTPContentType != "" {
		localVarHeaderParams["Content-Type"] = localVarHTTPContentType
	}

	// to determine the Accept header
	localVarHTTPHeaderAccepts := []string{"application/json"}

	// set Accept header
	localVarHTTPHeaderAccept := selectHeaderAccept(localVarHTTPHeaderAccepts)
	if localVarHTTPHeaderAccept != "" {
		localVarHeaderParams["Accept"] = localVarHTTPHeaderAccept
	}
	if r.ctx != nil {
		// API Key Authentication
		if auth, ok := r.ctx.Value(ContextAPIKeys).(map[string]APIKey); ok {
			if apiKey, ok := auth["apiKeyAuth"]; ok {
				var key string
				if apiKey.Prefix != "" {
					key = apiKey.Prefix + " " + apiKey.Key
				} else {
					key = apiKey.Key
				}
				localVarHeaderParams["X-API-KEY"] = key
			}
		}
	}
	req, err := a.client.prepareRequest(r.ctx, localVarPath, localVarHTTPMethod, localVarPostBody, localVarHeaderParams, localVarQueryParams, localVarFormParams, formFiles)
	if err != nil {
		return localVarReturnValue, nil, err
	}

	localVarHTTPResponse, err := a.client.callAPI(req)
	if err != nil || localVarHTTPResponse == nil {
		return localVarReturnValue, localVarHTTPResponse, err
	}

	localVarBody, err := io.ReadAll(localVarHTTPResponse.Body)
	localVarHTTPResponse.Body.Close()
	localVarHTTPResponse.Body = io.NopCloser(bytes.NewBuffer(localVarBody))
	if err != nil {
		return localVarReturnValue, localVarHTTPResponse, err
	}

	if localVarHTTPResponse.StatusCode >= 300 {
		newErr := &GenericOpenAPIError{
			body:  localVarBody,
			error: localVarHTTPResponse.Status,
		}
		return localVarReturnValue, localVarHTTPResponse, newErr
	}

	err = a.client.decode(&localVarReturnValue, localVarBody, localVarHTTPResponse.Header.Get("Content-Type"))
	if err != nil {
		newErr := &GenericOpenAPIError{
			body:  localVarBody,
			error: err.Error(),
		}
		return localVarReturnValue, localVarHTTPResponse, newErr
	}

	return localVarReturnValue, localVarHTTPResponse, nil
}
