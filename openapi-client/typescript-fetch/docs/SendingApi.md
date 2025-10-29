# SendingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sendAdvMail**](SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail**](SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email |



## sendAdvMail

> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;subject&#x3D;Welcome\&#39; \\ --data \&#39;body&#x3D;Hello\&#39; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;subject&#x3D;Welcome\&#39; \\ --data \&#39;body&#x3D;Hello\&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;subject&#x3D;Welcome\&#39; \\ --data \&#39;body&#x3D;Hello\&#39; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;subject&#x3D;Welcome\&#39; \\ --data \&#39;body&#x3D;Hello\&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;subject&#x3D;Welcome\&#39; \\ --data \&#39;body&#x3D;Hello\&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/x-www-form-urlencoded\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;subject&#x3D;Welcome\&#39; \\ --data \&#39;body&#x3D;Hello\&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/json\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }\&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/json\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }\&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \&#39;Accept: application/json\&#39; \\ --header \&#39;Content-Type: application/json\&#39; \\ --header \&#39;X-API-KEY: YOUR_API_KEY\&#39; \\ --data \&#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }\&#39; &#x60;&#x60;&#x60; 

### Example

```ts
import {
  Configuration,
  SendingApi,
} from '';
import type { SendAdvMailRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new SendingApi(config);

  const body = {
    // string | The subject or title of the email
    subject: subject_example,
    // string | The main email contents.
    body: body_example,
    // EmailAddressTypes
    from: ...,
    // EmailAddressesTypes
    to: ...,
    // EmailAddressesTypes (optional)
    replyto: ...,
    // EmailAddressesTypes (optional)
    cc: ...,
    // EmailAddressesTypes (optional)
    bcc: ...,
    // Array<MailAttachment> | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
    attachments: ...,
    // number | (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
    id: 789,
  } satisfies SendAdvMailRequest;

  try {
    const data = await api.sendAdvMail(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subject** | `string` | The subject or title of the email | [Defaults to `undefined`] |
| **body** | `string` | The main email contents. | [Defaults to `undefined`] |
| **from** | [EmailAddressTypes](EmailAddressTypes.md) |  | [Defaults to `undefined`] |
| **to** | [EmailAddressesTypes](EmailAddressesTypes.md) |  | [Defaults to `undefined`] |
| **replyto** | [EmailAddressesTypes](EmailAddressesTypes.md) |  | [Optional] [Defaults to `undefined`] |
| **cc** | [EmailAddressesTypes](EmailAddressesTypes.md) |  | [Optional] [Defaults to `undefined`] |
| **bcc** | [EmailAddressesTypes](EmailAddressesTypes.md) |  | [Optional] [Defaults to `undefined`] |
| **attachments** | `Array<MailAttachment>` | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [Optional] |
| **id** | `number` | (optional)  ID of the Mail order within our system to use as the Mail Account. | [Optional] [Defaults to `undefined`] |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)


## sendMail

> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example

```ts
import {
  Configuration,
  SendingApi,
} from '';
import type { SendMailRequest } from '';

async function example() {
  console.log("🚀 Testing  SDK...");
  const config = new Configuration({ 
    // To configure API key authorization: apiKeyAuth
    apiKey: "YOUR API KEY",
  });
  const api = new SendingApi(config);

  const body = {
    // string | The Contact whom is the primary recipient of this email.
    to: to_example,
    // string | The contact whom is the this email is from.
    from: from_example,
    // string | The subject or title of the email
    subject: subject_example,
    // string | The main email contents.
    body: body_example,
  } satisfies SendMailRequest;

  try {
    const data = await api.sendMail(body);
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

// Run the test
example().catch(console.error);
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **to** | `string` | The Contact whom is the primary recipient of this email. | [Defaults to `undefined`] |
| **from** | `string` | The contact whom is the this email is from. | [Defaults to `undefined`] |
| **subject** | `string` | The subject or title of the email | [Defaults to `undefined`] |
| **body** | `string` | The main email contents. | [Defaults to `undefined`] |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
- **Accept**: `application/json`


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)

