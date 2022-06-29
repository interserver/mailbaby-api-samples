# MailLogEntry
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **Int32** | internal db id | 
**Id** | **String** | mail id | 
**VarFrom** | **String** | from address | 
**To** | **String** | to address | 
**Subject** | **String** | email subject | 
**MessageId** | **String** | message id | 
**Created** | **String** | creation date | 
**Time** | **Int32** | creation timestamp | 
**User** | **String** | user account | 
**Transtype** | **String** | transaction type | 
**Transhost** | **String** | transaction host | 
**Originhost** | **String** | origin host | 
**Origin** | **String** | origin ip | 
**Interface** | **String** | interface name | 
**Date** | **String** | date processed | 
**SendingZone** | **String** | sending zone | 
**BodySize** | **Int32** | email body size in bytes | 
**SourceMd5** | **String** | md5 sum of the email | 
**Seq** | **Int32** | delivery sequency | 
**Domain** | **String** | to address domain | 
**Recipient** | **String** | email receiver address | 
**Locked** | **Int32** | locked status | 
**LockTime** | **Int32** | lock timestamp | 
**Assigned** | **String** | assigned server | 
**Queued** | **String** | queued timestamp | 
**Lock** | **String** | lock id | 
**Logger** | **String** | logger | 
**MxPort** | **Int32** | mx port number | 
**ConnectionKey** | **String** | connection key | 
**MxHostname** | **String** | mx hostname | 
**SentBodyHash** | **String** | body hash | 
**SentBodySize** | **Int32** | sent body size in bytes | 
**Md5Match** | **Int32** | md5 checksum matching result | 

## Examples

- Prepare the resource
```powershell
$MailLogEntry = Initialize-PSOpenAPIToolsMailLogEntry  -Id 103172 `
 -Id 17c7eda538e0005d03 `
 -VarFrom person@mysite.com `
 -To client@isp.com `
 -Subject sell 0.005 shares `
 -MessageId &lt;vmiLEebsuCbSpUxD7oN3REpaN4VbN6BrdCAbNKIrdAo@relay0.mailbaby.net&gt; `
 -Created 2021-10-14 08:50:10 `
 -Time 1634215809 `
 -User mb5658 `
 -Transtype ESMTPSA `
 -Transhost relay0.mailbaby.net `
 -Originhost 199.231.189.154 `
 -Origin 199.231.189.154 `
 -Interface feeder `
 -Date Thu, 14 Oct 2021 08:50:09 -0400 `
 -SendingZone interserver `
 -BodySize 63 `
 -SourceMd5 1d7058e6a30369f200b0c34fab2fac92 `
 -Seq 1 `
 -Domain interserver.net `
 -Recipient client@isp.com `
 -Locked 1 `
 -LockTime 1634215818533 `
 -Assigned relay1 `
 -Queued 2021-10-14T12:50:15.487Z `
 -Lock lock 17c7eda538e0005d03 001 `
 -Logger null `
 -MxPort 25 `
 -ConnectionKey 206.72.200.46:interserver.net:25 `
 -MxHostname mx.j.is.cc `
 -SentBodyHash 1d7058e6a30369f200b0c34fab2fac92 `
 -SentBodySize 63 `
 -Md5Match 1
```

- Convert the resource to JSON
```powershell
$MailLogEntry | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

