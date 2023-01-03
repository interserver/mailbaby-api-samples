# MailLogEntry

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **Integer** | internal db id | 
**id** | **String** | mail id | 
**from** | **String** | from address | 
**to** | **String** | to address | 
**subject** | **String** | email subject | 
**messageId** | **String** | message id | 
**created** | **String** | creation date | 
**time** | **Integer** | creation timestamp | 
**user** | **String** | user account | 
**transtype** | **String** | transaction type | 
**transhost** | **String** | transaction host | 
**originhost** | **String** | origin host | 
**origin** | **String** | origin ip | 
**_interface** | **String** | interface name | 
**date** | **String** | date processed | 
**sendingZone** | **String** | sending zone | 
**bodySize** | **Integer** | email body size in bytes | 
**sourceMd5** | **String** | md5 sum of the email | 
**seq** | **Integer** | delivery sequency | 
**domain** | **String** | to address domain | 
**recipient** | **String** | email receiver address | 
**locked** | **Integer** | locked status | 
**lockTime** | **Integer** | lock timestamp | 
**assigned** | **String** | assigned server | 
**queued** | **String** | queued timestamp | 
**_lock** | **String** | lock id | 
**logger** | **String** | logger | 
**mxPort** | **Integer** | mx port number | 
**connectionKey** | **String** | connection key | 
**mxHostname** | **String** | mx hostname | 
**sentBodyHash** | **String** | body hash | 
**sentBodySize** | **Integer** | sent body size in bytes | 
**md5Match** | **Integer** | md5 checksum matching result | 
