#
# MailBaby Email Delivery and Management Service API
# **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
# Version: 1.1.0
# Contact: support@interserver.net
# Generated by OpenAPI Generator: https://openapi-generator.tech
#

<#
.SYNOPSIS

Account usage statistics.

.DESCRIPTION

No description available.

.PARAMETER Time
The timeframe for the statistics.

.PARAMETER WithHttpInfo

A switch when turned on will return a hash table of Response, StatusCode and Headers instead of just the Response

.OUTPUTS

MailStatsType
#>
function Get-Stats {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [ValidateSet("all", "billing", "month", "7d", "24h", "1d", "1h")]
        [String]
        ${Time},
        [Switch]
        $WithHttpInfo
    )

    Process {
        'Calling method: Get-Stats' | Write-Debug
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $LocalVarAccepts = @()
        $LocalVarContentTypes = @()
        $LocalVarQueryParameters = @{}
        $LocalVarHeaderParameters = @{}
        $LocalVarFormParameters = @{}
        $LocalVarPathParameters = @{}
        $LocalVarCookieParameters = @{}
        $LocalVarBodyParameter = $null

        $Configuration = Get-Configuration
        # HTTP header 'Accept' (if needed)
        $LocalVarAccepts = @('application/json')

        $LocalVarUri = '/mail/stats'

        if ($Time) {
            $LocalVarQueryParameters['time'] = $Time
        }

        if ($Configuration["ApiKeyPrefix"] -and $Configuration["ApiKeyPrefix"]["X-API-KEY"]) {
            $apiKeyPrefix = $Configuration["ApiKeyPrefix"]["X-API-KEY"]
        } else {
            $apiKeyPrefix = ""
        }
        if ($Configuration["ApiKey"] -and $Configuration["ApiKey"]["X-API-KEY"]) {
            $LocalVarHeaderParameters['X-API-KEY'] = $apiKeyPrefix + $Configuration["ApiKey"]["X-API-KEY"]
            Write-Verbose ("Using API key 'X-API-KEY' in the header for authentication in {0}" -f $MyInvocation.MyCommand)
        }

        $LocalVarResult = Invoke-ApiClient -Method 'GET' `
                                -Uri $LocalVarUri `
                                -Accepts $LocalVarAccepts `
                                -ContentTypes $LocalVarContentTypes `
                                -Body $LocalVarBodyParameter `
                                -HeaderParameters $LocalVarHeaderParameters `
                                -QueryParameters $LocalVarQueryParameters `
                                -FormParameters $LocalVarFormParameters `
                                -CookieParameters $LocalVarCookieParameters `
                                -ReturnType "MailStatsType" `
                                -IsBodyNullable $false

        if ($WithHttpInfo.IsPresent) {
            return $LocalVarResult
        } else {
            return $LocalVarResult["Response"]
        }
    }
}

<#
.SYNOPSIS

displays the mail log

.DESCRIPTION

No description available.

.PARAMETER Id
The ID of your mail order this will be sent through.

.PARAMETER Origin
originating ip address sending mail

.PARAMETER Mx
mx record mail was sent to

.PARAMETER From
from email address

.PARAMETER To
to/destination email address

.PARAMETER Subject
subject containing this string

.PARAMETER Mailid
mail id

.PARAMETER Skip
number of records to skip for pagination

.PARAMETER Limit
maximum number of records to return

.PARAMETER StartDate
earliest date to get emails in unix timestamp format

.PARAMETER EndDate
earliest date to get emails in unix timestamp format

.PARAMETER Replyto
Reply-To Email Address

.PARAMETER Headerfrom
Header From Email Address

.PARAMETER Delivered
Limiting the emails to wether or not they were delivered.

.PARAMETER WithHttpInfo

A switch when turned on will return a hash table of Response, StatusCode and Headers instead of just the Response

.OUTPUTS

MailLog
#>
function Invoke-ViewMailLog {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [System.Nullable[Int64]]
        ${Id},
        [Parameter(Position = 1, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${Origin},
        [Parameter(Position = 2, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${Mx},
        [Parameter(Position = 3, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${From},
        [Parameter(Position = 4, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${To},
        [Parameter(Position = 5, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${Subject},
        [Parameter(Position = 6, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${Mailid},
        [Parameter(Position = 7, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [System.Nullable[Int32]]
        ${Skip},
        [Parameter(Position = 8, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [System.Nullable[Int32]]
        ${Limit},
        [Parameter(Position = 9, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [System.Nullable[Int64]]
        ${StartDate},
        [Parameter(Position = 10, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [System.Nullable[Int64]]
        ${EndDate},
        [Parameter(Position = 11, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${Replyto},
        [Parameter(Position = 12, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${Headerfrom},
        [Parameter(Position = 13, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [ValidateSet("0", "1")]
        [String]
        ${Delivered},
        [Switch]
        $WithHttpInfo
    )

    Process {
        'Calling method: Invoke-ViewMailLog' | Write-Debug
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $LocalVarAccepts = @()
        $LocalVarContentTypes = @()
        $LocalVarQueryParameters = @{}
        $LocalVarHeaderParameters = @{}
        $LocalVarFormParameters = @{}
        $LocalVarPathParameters = @{}
        $LocalVarCookieParameters = @{}
        $LocalVarBodyParameter = $null

        $Configuration = Get-Configuration
        # HTTP header 'Accept' (if needed)
        $LocalVarAccepts = @('application/json')

        $LocalVarUri = '/mail/log'

        if ($Id) {
            $LocalVarQueryParameters['id'] = $Id
        }

        if ($Origin) {
            $LocalVarQueryParameters['origin'] = $Origin
        }

        if ($Mx) {
            $LocalVarQueryParameters['mx'] = $Mx
        }

        if ($From) {
            $LocalVarQueryParameters['from'] = $From
        }

        if ($To) {
            $LocalVarQueryParameters['to'] = $To
        }

        if ($Subject) {
            $LocalVarQueryParameters['subject'] = $Subject
        }

        if ($Mailid) {
            $LocalVarQueryParameters['mailid'] = $Mailid
        }

        if ($Skip) {
            $LocalVarQueryParameters['skip'] = $Skip
        }

        if ($Limit) {
            $LocalVarQueryParameters['limit'] = $Limit
        }

        if ($StartDate) {
            $LocalVarQueryParameters['startDate'] = $StartDate
        }

        if ($EndDate) {
            $LocalVarQueryParameters['endDate'] = $EndDate
        }

        if ($Replyto) {
            $LocalVarQueryParameters['replyto'] = $Replyto
        }

        if ($Headerfrom) {
            $LocalVarQueryParameters['headerfrom'] = $Headerfrom
        }

        if ($Delivered) {
            $LocalVarQueryParameters['delivered'] = $Delivered
        }

        if ($Configuration["ApiKeyPrefix"] -and $Configuration["ApiKeyPrefix"]["X-API-KEY"]) {
            $apiKeyPrefix = $Configuration["ApiKeyPrefix"]["X-API-KEY"]
        } else {
            $apiKeyPrefix = ""
        }
        if ($Configuration["ApiKey"] -and $Configuration["ApiKey"]["X-API-KEY"]) {
            $LocalVarHeaderParameters['X-API-KEY'] = $apiKeyPrefix + $Configuration["ApiKey"]["X-API-KEY"]
            Write-Verbose ("Using API key 'X-API-KEY' in the header for authentication in {0}" -f $MyInvocation.MyCommand)
        }

        $LocalVarResult = Invoke-ApiClient -Method 'GET' `
                                -Uri $LocalVarUri `
                                -Accepts $LocalVarAccepts `
                                -ContentTypes $LocalVarContentTypes `
                                -Body $LocalVarBodyParameter `
                                -HeaderParameters $LocalVarHeaderParameters `
                                -QueryParameters $LocalVarQueryParameters `
                                -FormParameters $LocalVarFormParameters `
                                -CookieParameters $LocalVarCookieParameters `
                                -ReturnType "MailLog" `
                                -IsBodyNullable $false

        if ($WithHttpInfo.IsPresent) {
            return $LocalVarResult
        } else {
            return $LocalVarResult["Response"]
        }
    }
}

