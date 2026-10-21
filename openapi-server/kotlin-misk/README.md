# Documentation for MailBaby Email Delivery and Management Service API

    <a id="documentation-for-api-endpoints"></a>
    ## Documentation for API Endpoints

    All URIs are relative to *https://api.mailbaby.net*

    Class | Method | HTTP request | Description
    ------------ | ------------- | ------------- | -------------
    *BlockingApi* | [**addRule**](Apis/docs/BlockingApi.md#addrule) | **Post** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix
    *BlockingApi* | [**deleteRule**](Apis/docs/BlockingApi.md#deleterule) | **Delete** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId
    *BlockingApi* | [**delistBlock**](Apis/docs/BlockingApi.md#delistblock) | **Post** /mail/blocks/delete | Delist an email address from the spam-filter block lists
    *BlockingApi* | [**getMailBlocks**](Apis/docs/BlockingApi.md#getmailblocks) | **Get** /mail/blocks | List addresses currently flagged by spam-filter block lists
    *BlockingApi* | [**getRules**](Apis/docs/BlockingApi.md#getrules) | **Get** /mail/rules | List custom deny rules (sender / domain / destination / prefix)
    *HistoryApi* | [**getStats**](Apis/docs/HistoryApi.md#getstats) | **Get** /mail/stats | Account usage, cost, and volume statistics for a time window
    *HistoryApi* | [**viewMailLog**](Apis/docs/HistoryApi.md#viewmaillog) | **Get** /mail/log | Query the mail delivery log (filterable, paginated)
    *SendingApi* | [**rawMail**](Apis/docs/SendingApi.md#rawmail) | **Post** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
    *SendingApi* | [**sendAdvMail**](Apis/docs/SendingApi.md#sendadvmail) | **Post** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
    *SendingApi* | [**sendMail**](Apis/docs/SendingApi.md#sendmail) | **Post** /mail/send | Send a simple email (single recipient, plain or HTML)
    *ServicesApi* | [**getMailOrderById**](Apis/docs/ServicesApi.md#getmailorderbyid) | **Get** /mail/{id} | Get one mail order's full detail including SMTP password
    *ServicesApi* | [**getMailOrders**](Apis/docs/ServicesApi.md#getmailorders) | **Get** /mail | List your provisioned mail orders (sending accounts)
    *StatusApi* | [**pingServer**](Apis/docs/StatusApi.md#pingserver) | **Get** /ping | Health check — verify the API is reachable
    

    <a id="documentation-for-models"></a>
    ## Documentation for Models

         - [MailBabyKotlinMisk.models.DateOrTimestamp](Models/docs/DateOrTimestamp.md)
         - [MailBabyKotlinMisk.models.DenyRuleNew](Models/docs/DenyRuleNew.md)
         - [MailBabyKotlinMisk.models.DenyRuleRecord](Models/docs/DenyRuleRecord.md)
         - [MailBabyKotlinMisk.models.EmailAddressName](Models/docs/EmailAddressName.md)
         - [MailBabyKotlinMisk.models.EmailAddressParam](Models/docs/EmailAddressParam.md)
         - [MailBabyKotlinMisk.models.EmailAddressTypes](Models/docs/EmailAddressTypes.md)
         - [MailBabyKotlinMisk.models.EmailAddressesTypes](Models/docs/EmailAddressesTypes.md)
         - [MailBabyKotlinMisk.models.ErrorMessage](Models/docs/ErrorMessage.md)
         - [MailBabyKotlinMisk.models.GenericResponse](Models/docs/GenericResponse.md)
         - [MailBabyKotlinMisk.models.MailAttachment](Models/docs/MailAttachment.md)
         - [MailBabyKotlinMisk.models.MailBlockClickHouse](Models/docs/MailBlockClickHouse.md)
         - [MailBabyKotlinMisk.models.MailBlockRspamd](Models/docs/MailBlockRspamd.md)
         - [MailBabyKotlinMisk.models.MailBlocks](Models/docs/MailBlocks.md)
         - [MailBabyKotlinMisk.models.MailLog](Models/docs/MailLog.md)
         - [MailBabyKotlinMisk.models.MailLogEntry](Models/docs/MailLogEntry.md)
         - [MailBabyKotlinMisk.models.MailOrder](Models/docs/MailOrder.md)
         - [MailBabyKotlinMisk.models.MailOrderDetail](Models/docs/MailOrderDetail.md)
         - [MailBabyKotlinMisk.models.MailStatsType](Models/docs/MailStatsType.md)
         - [MailBabyKotlinMisk.models.MailStatsVolume](Models/docs/MailStatsVolume.md)
         - [MailBabyKotlinMisk.models.SendMail](Models/docs/SendMail.md)
         - [MailBabyKotlinMisk.models.SendMailAdv](Models/docs/SendMailAdv.md)
         - [MailBabyKotlinMisk.models.SendMailRaw](Models/docs/SendMailRaw.md)
         - [MailBabyKotlinMisk.models.SendMailTo](Models/docs/SendMailTo.md)
        

<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
    <a id="apiKeyAuth"></a>
    ### apiKeyAuth

    - **Type**: API key
    - **API key parameter name**: X-API-KEY
    - **Location**: HTTP header
                    
