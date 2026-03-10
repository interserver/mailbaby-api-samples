# \ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_order_by_id**](ServicesApi.md#get_mail_order_by_id) | **GET** /mail/{id} | Displays details for a single mail order
[**get_mail_orders**](ServicesApi.md#get_mail_orders) | **GET** /mail | Displays a list of mail service orders



## get_mail_order_by_id

> models::MailOrderDetail get_mail_order_by_id(id)
Displays details for a single mail order

Returns the full detail record for one specific mail order identified by its numeric `id`.  In addition to the fields returned by `GET /mail`, this endpoint also includes the current **SMTP password** for the order.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**id** | **i64** | The numeric ID of the mail order. | [required] |

### Return type

[**models::MailOrderDetail**](MailOrderDetail.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## get_mail_orders

> Vec<models::MailOrder> get_mail_orders()
Displays a list of mail service orders

Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional human-readable `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 

### Parameters

This endpoint does not need any parameter.

### Return type

[**Vec<models::MailOrder>**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

