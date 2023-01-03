# MailBabyEmailDeliveryApi.MailLogEntry

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Number** | internal db id | 
**id** | **String** | mail id | 
**from** | **String** | from address | 
**to** | **String** | to address | 
**subject** | **String** | email subject | 
**messageId** | **String** | message id | 
**created** | **String** | creation date | 
**time** | **Number** | creation timestamp | 
**user** | **String** | user account | 
**transtype** | **String** | transaction type | 
**transhost** | **String** | transaction host | 
**originhost** | **String** | origin host | 
**origin** | **String** | origin ip | 
**_interface** | **String** | interface name | 
**_date** | **String** | date processed | 
**sendingZone** | **String** | sending zone | 
**bodySize** | **Number** | email body size in bytes | 
**sourceMd5** | **String** | md5 sum of the email | 
**seq** | **Number** | delivery sequency | 
**domain** | **String** | to address domain | 
**recipient** | **String** | email receiver address | 
**locked** | **Number** | locked status | 
**lockTime** | **Number** | lock timestamp | 
**assigned** | **String** | assigned server | 
**queued** | **String** | queued timestamp | 
**lock** | **String** | lock id | 
**logger** | **String** | logger | 
**mxPort** | **Number** | mx port number | 
**connectionKey** | **String** | connection key | 
**mxHostname** | **String** | mx hostname | 
**sentBodyHash** | **String** | body hash | 
**sentBodySize** | **Number** | sent body size in bytes | 
**md5Match** | **Number** | md5 checksum matching result | 
