

# MailLogEntry

An email record

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Int** | internal db id | 
**id** | **String** | mail id | 
**from** | **String** | from address | 
**to** | **String** | to address | 
**subject** | **String** | email subject | 
**messageId** | **String** | message id | 
**created** | **String** | creation date | 
**time** | **Int** | creation timestamp | 
**user** | **String** | user account | 
**transtype** | **String** | transaction type | 
**transhost** | **String** | transaction host | 
**originhost** | **String** | origin host | 
**origin** | **String** | origin ip | 
**interface** | **String** | interface name | 
**date** | **String** | date processed | 
**sendingZone** | **String** | sending zone | 
**bodySize** | **Int** | email body size in bytes | 
**sourceMd5** | **String** | md5 sum of the email | 
**seq** | **Int** | delivery sequency | 
**domain** | **String** | to address domain | 
**recipient** | **String** | email receiver address | 
**locked** | **Int** | locked status | 
**lockTime** | **Int** | lock timestamp | 
**assigned** | **String** | assigned server | 
**queued** | **String** | queued timestamp | 
**lock** | **String** | lock id | 
**logger** | **String** | logger | 
**mxPort** | **Int** | mx port number | 
**connectionKey** | **String** | connection key | 
**mxHostname** | **String** | mx hostname | 
**sentBodyHash** | **String** | body hash | 
**sentBodySize** | **Int** | sent body size in bytes | 
**md5Match** | **Int** | md5 checksum matching result | 



