# openapi::MailLogEntry

An email record

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **integer** | internal db id | 
**id** | **character** | mail id | 
**from** | **character** | from address | 
**to** | **character** | to address | 
**subject** | **character** | email subject | 
**messageId** | **character** | message id | 
**created** | **character** | creation date | 
**time** | **integer** | creation timestamp | 
**user** | **character** | user account | 
**transtype** | **character** | transaction type | 
**transhost** | **character** | transaction host | 
**originhost** | **character** | origin host | 
**origin** | **character** | origin ip | 
**interface** | **character** | interface name | 
**date** | **character** | date processed | 
**sendingZone** | **character** | sending zone | 
**bodySize** | **integer** | email body size in bytes | 
**sourceMd5** | **character** | md5 sum of the email | 
**seq** | **integer** | delivery sequency | 
**domain** | **character** | to address domain | 
**recipient** | **character** | email receiver address | 
**locked** | **integer** | locked status | 
**lockTime** | **integer** | lock timestamp | 
**assigned** | **character** | assigned server | 
**queued** | **character** | queued timestamp | 
**_lock** | **character** | lock id | 
**logger** | **character** | logger | 
**mxPort** | **integer** | mx port number | 
**connectionKey** | **character** | connection key | 
**mxHostname** | **character** | mx hostname | 
**sentBodyHash** | **character** | body hash | 
**sentBodySize** | **integer** | sent body size in bytes | 
**md5Match** | **integer** | md5 checksum matching result | 


