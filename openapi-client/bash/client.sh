#!/usr/bin/env bash

# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# !
# ! Note:
# !
# ! THIS SCRIPT HAS BEEN AUTOMATICALLY GENERATED USING
# ! openapi-generator (https://openapi-generator.tech)
# ! FROM OPENAPI SPECIFICATION IN JSON.
# !
# ! Generator version: 7.20.0
# !
# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

#
# This is a Bash client for MailBaby Email Delivery and Management Service API.
#
# LICENSE:
# https://www.gnu.org/licenses/gpl.txt
#
# CONTACT:
# support@interserver.net
#
# MORE INFORMATION:
# https://www.mail.baby/tips/
#

# For improved pattern matching in case statements
shopt -s extglob

###############################################################################
#
# Make sure Bash is at least in version 4.3
#
###############################################################################
if ! ( (("${BASH_VERSION:0:1}" == "4")) && (("${BASH_VERSION:2:1}" >= "3")) ) \
  && ! (("${BASH_VERSION:0:1}" >= "5")); then
    echo ""
    echo "Sorry - your Bash version is ${BASH_VERSION}"
    echo ""
    echo "You need at least Bash 4.3 to run this script."
    echo ""
    exit 1
fi

###############################################################################
#
# Global variables
#
###############################################################################

##
# The filename of this script for help messages
script_name=$(basename "$0")

##
# Map for headers passed after operation as KEY:VALUE
declare -A header_arguments


##
# Map for operation parameters passed after operation as PARAMETER=VALUE
# These will be mapped to appropriate path or query parameters
# The values in operation_parameters are arrays, so that multiple values
# can be provided for the same parameter if allowed by API specification
declare -A operation_parameters

##
# Declare colors with autodetection if output is terminal
if [ -t 1 ]; then
    RED="$(tput setaf 1)"
    GREEN="$(tput setaf 2)"
    YELLOW="$(tput setaf 3)"
    BLUE="$(tput setaf 4)"
    MAGENTA="$(tput setaf 5)"
    CYAN="$(tput setaf 6)"
    WHITE="$(tput setaf 7)"
    BOLD="$(tput bold)"
    OFF="$(tput sgr0)"
else
    RED=""
    GREEN=""
    YELLOW=""
    BLUE=""
    MAGENTA=""
    CYAN=""
    WHITE=""
    BOLD=""
    OFF=""
fi

declare -a result_color_table=( "$WHITE" "$WHITE" "$GREEN" "$YELLOW" "$WHITE" "$MAGENTA" "$WHITE" )

##
# This array stores the minimum number of required occurrences for parameter
# 0 - optional
# 1 - required
declare -A operation_parameters_minimum_occurrences
operation_parameters_minimum_occurrences["addRule:::type"]=1
operation_parameters_minimum_occurrences["addRule:::data"]=1
operation_parameters_minimum_occurrences["addRule:::user"]=0
operation_parameters_minimum_occurrences["deleteRule:::ruleId"]=1
operation_parameters_minimum_occurrences["delistBlock:::EmailAddressParam"]=1
operation_parameters_minimum_occurrences["getStats:::time"]=0
operation_parameters_minimum_occurrences["viewMailLog:::id"]=0
operation_parameters_minimum_occurrences["viewMailLog:::origin"]=0
operation_parameters_minimum_occurrences["viewMailLog:::mx"]=0
operation_parameters_minimum_occurrences["viewMailLog:::from"]=0
operation_parameters_minimum_occurrences["viewMailLog:::to"]=0
operation_parameters_minimum_occurrences["viewMailLog:::subject"]=0
operation_parameters_minimum_occurrences["viewMailLog:::mailid"]=0
operation_parameters_minimum_occurrences["viewMailLog:::messageId"]=0
operation_parameters_minimum_occurrences["viewMailLog:::replyto"]=0
operation_parameters_minimum_occurrences["viewMailLog:::headerfrom"]=0
operation_parameters_minimum_occurrences["viewMailLog:::delivered"]=0
operation_parameters_minimum_occurrences["viewMailLog:::skip"]=0
operation_parameters_minimum_occurrences["viewMailLog:::limit"]=0
operation_parameters_minimum_occurrences["viewMailLog:::startDate"]=0
operation_parameters_minimum_occurrences["viewMailLog:::endDate"]=0
operation_parameters_minimum_occurrences["rawMail:::SendMailRaw"]=1
operation_parameters_minimum_occurrences["sendAdvMail:::subject"]=1
operation_parameters_minimum_occurrences["sendAdvMail:::body"]=1
operation_parameters_minimum_occurrences["sendAdvMail:::from"]=1
operation_parameters_minimum_occurrences["sendAdvMail:::to"]=1
operation_parameters_minimum_occurrences["sendAdvMail:::replyto"]=0
operation_parameters_minimum_occurrences["sendAdvMail:::cc"]=0
operation_parameters_minimum_occurrences["sendAdvMail:::bcc"]=0
operation_parameters_minimum_occurrences["sendAdvMail:::attachments"]=0
operation_parameters_minimum_occurrences["sendAdvMail:::id"]=0
operation_parameters_minimum_occurrences["sendMail:::to"]=1
operation_parameters_minimum_occurrences["sendMail:::from"]=1
operation_parameters_minimum_occurrences["sendMail:::subject"]=1
operation_parameters_minimum_occurrences["sendMail:::body"]=1
operation_parameters_minimum_occurrences["sendMail:::id"]=0
operation_parameters_minimum_occurrences["getMailOrderById:::id"]=1

##
# This array stores the maximum number of allowed occurrences for parameter
# 1 - single value
# 2 - 2 values
# N - N values
# 0 - unlimited
declare -A operation_parameters_maximum_occurrences
operation_parameters_maximum_occurrences["addRule:::type"]=0
operation_parameters_maximum_occurrences["addRule:::data"]=0
operation_parameters_maximum_occurrences["addRule:::user"]=0
operation_parameters_maximum_occurrences["deleteRule:::ruleId"]=0
operation_parameters_maximum_occurrences["delistBlock:::EmailAddressParam"]=0
operation_parameters_maximum_occurrences["getStats:::time"]=0
operation_parameters_maximum_occurrences["viewMailLog:::id"]=0
operation_parameters_maximum_occurrences["viewMailLog:::origin"]=0
operation_parameters_maximum_occurrences["viewMailLog:::mx"]=0
operation_parameters_maximum_occurrences["viewMailLog:::from"]=0
operation_parameters_maximum_occurrences["viewMailLog:::to"]=0
operation_parameters_maximum_occurrences["viewMailLog:::subject"]=0
operation_parameters_maximum_occurrences["viewMailLog:::mailid"]=0
operation_parameters_maximum_occurrences["viewMailLog:::messageId"]=0
operation_parameters_maximum_occurrences["viewMailLog:::replyto"]=0
operation_parameters_maximum_occurrences["viewMailLog:::headerfrom"]=0
operation_parameters_maximum_occurrences["viewMailLog:::delivered"]=0
operation_parameters_maximum_occurrences["viewMailLog:::skip"]=0
operation_parameters_maximum_occurrences["viewMailLog:::limit"]=0
operation_parameters_maximum_occurrences["viewMailLog:::startDate"]=0
operation_parameters_maximum_occurrences["viewMailLog:::endDate"]=0
operation_parameters_maximum_occurrences["rawMail:::SendMailRaw"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::subject"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::body"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::from"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::to"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::replyto"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::cc"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::bcc"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::attachments"]=0
operation_parameters_maximum_occurrences["sendAdvMail:::id"]=0
operation_parameters_maximum_occurrences["sendMail:::to"]=0
operation_parameters_maximum_occurrences["sendMail:::from"]=0
operation_parameters_maximum_occurrences["sendMail:::subject"]=0
operation_parameters_maximum_occurrences["sendMail:::body"]=0
operation_parameters_maximum_occurrences["sendMail:::id"]=0
operation_parameters_maximum_occurrences["getMailOrderById:::id"]=0

##
# The type of collection for specifying multiple values for parameter:
# - multi, csv, ssv, tsv
declare -A operation_parameters_collection_type
operation_parameters_collection_type["addRule:::type"]=""
operation_parameters_collection_type["addRule:::data"]=""
operation_parameters_collection_type["addRule:::user"]=""
operation_parameters_collection_type["deleteRule:::ruleId"]=""
operation_parameters_collection_type["delistBlock:::EmailAddressParam"]=""
operation_parameters_collection_type["getStats:::time"]=""
operation_parameters_collection_type["viewMailLog:::id"]=""
operation_parameters_collection_type["viewMailLog:::origin"]=""
operation_parameters_collection_type["viewMailLog:::mx"]=""
operation_parameters_collection_type["viewMailLog:::from"]=""
operation_parameters_collection_type["viewMailLog:::to"]=""
operation_parameters_collection_type["viewMailLog:::subject"]=""
operation_parameters_collection_type["viewMailLog:::mailid"]=""
operation_parameters_collection_type["viewMailLog:::messageId"]=""
operation_parameters_collection_type["viewMailLog:::replyto"]=""
operation_parameters_collection_type["viewMailLog:::headerfrom"]=""
operation_parameters_collection_type["viewMailLog:::delivered"]=""
operation_parameters_collection_type["viewMailLog:::skip"]=""
operation_parameters_collection_type["viewMailLog:::limit"]=""
operation_parameters_collection_type["viewMailLog:::startDate"]=""
operation_parameters_collection_type["viewMailLog:::endDate"]=""
operation_parameters_collection_type["rawMail:::SendMailRaw"]=""
operation_parameters_collection_type["sendAdvMail:::subject"]=""
operation_parameters_collection_type["sendAdvMail:::body"]=""
operation_parameters_collection_type["sendAdvMail:::from"]=""
operation_parameters_collection_type["sendAdvMail:::to"]=""
operation_parameters_collection_type["sendAdvMail:::replyto"]=""
operation_parameters_collection_type["sendAdvMail:::cc"]=""
operation_parameters_collection_type["sendAdvMail:::bcc"]=""
operation_parameters_collection_type["sendAdvMail:::attachments"]=
operation_parameters_collection_type["sendAdvMail:::id"]=""
operation_parameters_collection_type["sendMail:::to"]=""
operation_parameters_collection_type["sendMail:::from"]=""
operation_parameters_collection_type["sendMail:::subject"]=""
operation_parameters_collection_type["sendMail:::body"]=""
operation_parameters_collection_type["sendMail:::id"]=""
operation_parameters_collection_type["getMailOrderById:::id"]=""


##
# Map for body parameters passed after operation as
# PARAMETER==STRING_VALUE or PARAMETER:=NUMERIC_VALUE
# These will be mapped to top level json keys ( { "PARAMETER": "VALUE" })
declare -A body_parameters

##
# These arguments will be directly passed to cURL
curl_arguments=""

##
# The host for making the request
host=""

##
# The user credentials for basic authentication
basic_auth_credential=""

##
# The user API key
apikey_auth_credential="$false"

##
# If true, the script will only output the actual cURL command that would be
# used
print_curl=false

##
# The operation ID passed on the command line
operation=""

##
# The provided Accept header value
header_accept=""

##
# The provided Content-type header value
header_content_type=""

##
# If there is any body content on the stdin pass it to the body of the request
body_content_temp_file=""

##
# If this variable is set to true, the request will be performed even
# if parameters for required query, header or body values are not provided
# (path parameters are still required).
force=false

##
# Declare some mime types abbreviations for easier content-type and accepts
# headers specification
declare -A mime_type_abbreviations
# text/*
mime_type_abbreviations["text"]="text/plain"
mime_type_abbreviations["html"]="text/html"
mime_type_abbreviations["md"]="text/x-markdown"
mime_type_abbreviations["csv"]="text/csv"
mime_type_abbreviations["css"]="text/css"
mime_type_abbreviations["rtf"]="text/rtf"
# application/*
mime_type_abbreviations["json"]="application/json"
mime_type_abbreviations["xml"]="application/xml"
mime_type_abbreviations["yaml"]="application/yaml"
mime_type_abbreviations["js"]="application/javascript"
mime_type_abbreviations["bin"]="application/octet-stream"
mime_type_abbreviations["rdf"]="application/rdf+xml"
# image/*
mime_type_abbreviations["jpg"]="image/jpeg"
mime_type_abbreviations["png"]="image/png"
mime_type_abbreviations["gif"]="image/gif"
mime_type_abbreviations["bmp"]="image/bmp"
mime_type_abbreviations["tiff"]="image/tiff"


##############################################################################
#
# Escape special URL characters
# Based on table at http://www.w3schools.com/tags/ref_urlencode.asp
#
##############################################################################
url_escape() {
    local raw_url="$1"

    value=$(sed -e 's/ /%20/g' \
       -e 's/!/%21/g' \
       -e 's/"/%22/g' \
       -e 's/#/%23/g' \
       -e 's/\&/%26/g' \
       -e 's/'\''/%28/g' \
       -e 's/(/%28/g' \
       -e 's/)/%29/g' \
       -e 's/:/%3A/g' \
       -e 's/\\t/%09/g' \
       -e 's/?/%3F/g' <<<"$raw_url");

    echo "$value"
}

##############################################################################
#
# Lookup the mime type abbreviation in the mime_type_abbreviations array.
# If not present assume the user provided a valid mime type
#
##############################################################################
lookup_mime_type() {
    local mime_type="$1"

    if [[ ${mime_type_abbreviations[$mime_type]} ]]; then
        echo "${mime_type_abbreviations[$mime_type]}"
    else
        echo "$mime_type"
    fi
}

##############################################################################
#
# Converts an associative array into a list of cURL header
# arguments (-H "KEY: VALUE")
#
##############################################################################
header_arguments_to_curl() {
    local headers_curl=""
    local api_key_header=""
    local api_key_header_in_cli=""
    api_key_header="X-API-KEY"

    for key in "${!header_arguments[@]}"; do
        headers_curl+="-H \"${key}: ${header_arguments[${key}]}\" "
        if [[ "${key}XX" == "${api_key_header}XX" ]]; then
            api_key_header_in_cli="YES"
        fi
    done
    #
    # If the api_key was not provided in the header, try one from the
    # environment variable
    #
    if [[ -z $api_key_header_in_cli && -n $apikey_auth_credential ]]; then
        headers_curl+="-H \"${api_key_header}: ${apikey_auth_credential}\""
    fi
    headers_curl+=" "

    echo "${headers_curl}"
}

##############################################################################
#
# Converts an associative array into a simple JSON with keys as top
# level object attributes
#
# \todo Add conversion of more complex attributes using paths
#
##############################################################################
body_parameters_to_json() {
    if [[ $RAW_BODY == "1" ]]; then
        echo "-d '${body_parameters["RAW_BODY"]}'"
    else
        local body_json="-d '{"
        local count=0
        for key in "${!body_parameters[@]}"; do
            if [[ $((count++)) -gt 0 ]]; then
                body_json+=", "
            fi
            body_json+="\"${key}\": ${body_parameters[${key}]}"
        done
        body_json+="}'"

        if [[ "${#body_parameters[@]}" -eq 0 ]]; then
            echo ""
        else
            echo "${body_json}"
        fi
    fi
}

##############################################################################
#
# Converts an associative array into form urlencoded string
#
##############################################################################
body_parameters_to_form_urlencoded() {
    local body_form_urlencoded="-d '"
    local count=0
    for key in "${!body_parameters[@]}"; do
        if [[ $((count++)) -gt 0 ]]; then
            body_form_urlencoded+="&"
        fi
        body_form_urlencoded+="${key}=${body_parameters[${key}]}"
    done
    body_form_urlencoded+="'"

    if [[ "${#body_parameters[@]}" -eq 0 ]]; then
        echo ""
    else
        echo "${body_form_urlencoded}"
    fi
}

##############################################################################
#
# Helper method for showing error because for example echo in
# build_request_path() is evaluated as part of command line not printed on
# output. Anyway better idea for resource clean up ;-).
#
##############################################################################
ERROR_MSG=""
function finish {
    if [[ -n "$ERROR_MSG" ]]; then
        echo >&2 "${OFF}${RED}$ERROR_MSG"
        echo >&2 "${OFF}Check usage: '${script_name} --help'"
    fi
}
trap finish EXIT


##############################################################################
#
# Validate and build request path including query parameters
#
##############################################################################
build_request_path() {
    local path_template=$1
    local -n path_params=$2
    local -n query_params=$3


    #
    # Check input parameters count against minimum and maximum required
    #
    if [[ "$force" = false ]]; then
        local was_error=""
        for qparam in "${query_params[@]}" "${path_params[@]}"; do
            local parameter_values
            mapfile -t parameter_values < <(sed -e 's/'":::"'/\n/g' <<<"${operation_parameters[$qparam]}")

            #
            # Check if the number of provided values is not less than minimum required
            #
            if [[ ${#parameter_values[@]} -lt ${operation_parameters_minimum_occurrences["${operation}:::${qparam}"]} ]]; then
                echo "ERROR: Too few values provided for '${qparam}' parameter."
                was_error=true
            fi

            #
            # Check if the number of provided values is not more than maximum
            #
            if [[ ${operation_parameters_maximum_occurrences["${operation}:::${qparam}"]} -gt 0 \
                  && ${#parameter_values[@]} -gt ${operation_parameters_maximum_occurrences["${operation}:::${qparam}"]} ]]; then
                echo "ERROR: Too many values provided for '${qparam}' parameter"
                was_error=true
            fi
        done
        if [[ -n "$was_error" ]]; then
            exit 1
        fi
    fi

    # First replace all path parameters in the path
    for pparam in "${path_params[@]}"; do
        local path_regex="(.*)(\\{$pparam\\})(.*)"
        if [[ $path_template =~ $path_regex ]]; then
            path_template=${BASH_REMATCH[1]}${operation_parameters[$pparam]}${BASH_REMATCH[3]}
        fi
    done

    local query_request_part=""

    for qparam in "${query_params[@]}"; do
        if [[ "${operation_parameters[$qparam]}" == "" ]]; then
            continue
        fi

        # Get the array of parameter values
        local parameter_value=""
        local parameter_values
        mapfile -t parameter_values < <(sed -e 's/'":::"'/\n/g' <<<"${operation_parameters[$qparam]}")



        #
        # Append parameters without specific cardinality
        #
        local collection_type="${operation_parameters_collection_type["${operation}:::${qparam}"]}"
        if [[ "${collection_type}" == "" ]]; then
            local vcount=0
            for qvalue in "${parameter_values[@]}"; do
                if [[ $((vcount++)) -gt 0 ]]; then
                    parameter_value+="&"
                fi
                parameter_value+="${qparam}=${qvalue}"
            done
        #
        # Append parameters specified as 'multi' collections i.e. param=value1&param=value2&...
        #
        elif [[ "${collection_type}" == "multi" ]]; then
            local vcount=0
            for qvalue in "${parameter_values[@]}"; do
                if [[ $((vcount++)) -gt 0 ]]; then
                    parameter_value+="&"
                fi
                parameter_value+="${qparam}=${qvalue}"
            done
        #
        # Append parameters specified as 'csv' collections i.e. param=value1,value2,...
        #
        elif [[ "${collection_type}" == "csv" ]]; then
            parameter_value+="${qparam}="
            local vcount=0
            for qvalue in "${parameter_values[@]}"; do
                if [[ $((vcount++)) -gt 0 ]]; then
                    parameter_value+=","
                fi
                parameter_value+="${qvalue}"
            done
        #
        # Append parameters specified as 'ssv' collections i.e. param="value1 value2 ..."
        #
        elif [[ "${collection_type}" == "ssv" ]]; then
            parameter_value+="${qparam}="
            local vcount=0
            for qvalue in "${parameter_values[@]}"; do
                if [[ $((vcount++)) -gt 0 ]]; then
                    parameter_value+=" "
                fi
                parameter_value+="${qvalue}"
            done
        #
        # Append parameters specified as 'tsv' collections i.e. param="value1\tvalue2\t..."
        #
        elif [[ "${collection_type}" == "tsv" ]]; then
            parameter_value+="${qparam}="
            local vcount=0
            for qvalue in "${parameter_values[@]}"; do
                if [[ $((vcount++)) -gt 0 ]]; then
                    parameter_value+="\\t"
                fi
                parameter_value+="${qvalue}"
            done
        else
            echo "Unsupported collection format \"${collection_type}\""
            exit 1
        fi

        if [[ -n "${parameter_value}" ]]; then
            if [[ -n "${query_request_part}" ]]; then
                query_request_part+="&"
            fi
            query_request_part+="${parameter_value}"
        fi

    done


    # Now append query parameters - if any
    if [[ -n "${query_request_part}" ]]; then
        path_template+="?${query_request_part}"
    fi

    echo "$path_template"
}



###############################################################################
#
# Print main help message
#
###############################################################################
print_help() {
cat <<EOF

${BOLD}${WHITE}MailBaby Email Delivery and Management Service API command line client (API version 1.4.0)${OFF}

${BOLD}${WHITE}Usage${OFF}

  ${GREEN}${script_name}${OFF} [-h|--help] [-V|--version] [--about] [${RED}<curl-options>${OFF}]
           [-ac|--accept ${GREEN}<mime-type>${OFF}] [-ct,--content-type ${GREEN}<mime-type>${OFF}]
           [--host ${CYAN}<url>${OFF}] [--dry-run] [-nc|--no-colors] ${YELLOW}<operation>${OFF} [-h|--help]
           [${BLUE}<headers>${OFF}] [${MAGENTA}<parameters>${OFF}] [${MAGENTA}<body-parameters>${OFF}]

  - ${CYAN}<url>${OFF} - endpoint of the REST service without basepath

  - ${RED}<curl-options>${OFF} - any valid cURL options can be passed before ${YELLOW}<operation>${OFF}
  - ${GREEN}<mime-type>${OFF} - either full mime-type or one of supported abbreviations:
                   (text, html, md, csv, css, rtf, json, xml, yaml, js, bin,
                    rdf, jpg, png, gif, bmp, tiff)
  - ${BLUE}<headers>${OFF} - HTTP headers can be passed in the form ${YELLOW}HEADER${OFF}:${BLUE}VALUE${OFF}
  - ${MAGENTA}<parameters>${OFF} - REST operation parameters can be passed in the following
                   forms:
                   * ${YELLOW}KEY${OFF}=${BLUE}VALUE${OFF} - path or query parameters
  - ${MAGENTA}<body-parameters>${OFF} - simple JSON body content (first level only) can be build
                        using the following arguments:
                        * ${YELLOW}KEY${OFF}==${BLUE}VALUE${OFF} - body parameters which will be added to body
                                      JSON as '{ ..., "${YELLOW}KEY${OFF}": "${BLUE}VALUE${OFF}", ... }'
                        * ${YELLOW}KEY${OFF}:=${BLUE}VALUE${OFF} - body parameters which will be added to body
                                      JSON as '{ ..., "${YELLOW}KEY${OFF}": ${BLUE}VALUE${OFF}, ... }'

EOF
    echo -e "${BOLD}${WHITE}Authentication methods${OFF}"
    echo -e ""
    echo -e "  - ${BLUE}Api-key${OFF} - add '${RED}X-API-KEY:<api-key>${OFF}' after ${YELLOW}<operation>${OFF}"
    echo -e "              or export ${RED}false='<api-key>'${OFF}"
    echo ""
    echo -e "${BOLD}${WHITE}Operations (grouped by tags)${OFF}"
    echo ""
    echo -e "${BOLD}${WHITE}[blocking]${OFF}"
read -r -d '' ops <<EOF
  ${CYAN}addRule${OFF};Creates a new email deny rule (AUTH)
  ${CYAN}deleteRule${OFF};Removes a deny mail rule (AUTH)
  ${CYAN}delistBlock${OFF};Removes an email address from the block lists (AUTH)
  ${CYAN}getMailBlocks${OFF};Displays a list of blocked email addresses (AUTH)
  ${CYAN}getRules${OFF};Displays a listing of deny email rules (AUTH)
EOF
echo "  $ops" | column -t -s ';'
    echo ""
    echo -e "${BOLD}${WHITE}[history]${OFF}"
read -r -d '' ops <<EOF
  ${CYAN}getStats${OFF};Account usage statistics (AUTH)
  ${CYAN}viewMailLog${OFF};Displays the mail log (AUTH)
EOF
echo "  $ops" | column -t -s ';'
    echo ""
    echo -e "${BOLD}${WHITE}[sending]${OFF}"
read -r -d '' ops <<EOF
  ${CYAN}rawMail${OFF};Sends a raw RFC 822 email (AUTH)
  ${CYAN}sendAdvMail${OFF};Sends an Email with Advanced Options (AUTH)
  ${CYAN}sendMail${OFF};Sends an Email (AUTH)
EOF
echo "  $ops" | column -t -s ';'
    echo ""
    echo -e "${BOLD}${WHITE}[services]${OFF}"
read -r -d '' ops <<EOF
  ${CYAN}getMailOrderById${OFF};Displays details for a single mail order (AUTH)
  ${CYAN}getMailOrders${OFF};Displays a list of mail service orders (AUTH)
EOF
echo "  $ops" | column -t -s ';'
    echo ""
    echo -e "${BOLD}${WHITE}[status]${OFF}"
read -r -d '' ops <<EOF
  ${CYAN}pingServer${OFF};Checks if the server is running (AUTH)
EOF
echo "  $ops" | column -t -s ';'
    echo ""
    echo -e "${BOLD}${WHITE}Options${OFF}"
    echo -e "  -h,--help\\t\\t\\t\\tPrint this help"
    echo -e "  -V,--version\\t\\t\\t\\tPrint API version"
    echo -e "  --about\\t\\t\\t\\tPrint the information about service"
    echo -e "  --host ${CYAN}<url>${OFF}\\t\\t\\t\\tSpecify the host URL "
echo -e "              \\t\\t\\t\\t(e.g. 'https://api.mailbaby.net')"

    echo -e "  --force\\t\\t\\t\\tForce command invocation in spite of missing"
    echo -e "         \\t\\t\\t\\trequired parameters or wrong content type"
    echo -e "  --dry-run\\t\\t\\t\\tPrint out the cURL command without"
    echo -e "           \\t\\t\\t\\texecuting it"
    echo -e "  -nc,--no-colors\\t\\t\\tEnforce print without colors, otherwise autodetected"
    echo -e "  -ac,--accept ${YELLOW}<mime-type>${OFF}\\t\\tSet the 'Accept' header in the request"
    echo -e "  -ct,--content-type ${YELLOW}<mime-type>${OFF}\\tSet the 'Content-type' header in "
    echo -e "                                \\tthe request"
    echo ""
}


##############################################################################
#
# Print REST service description
#
##############################################################################
print_about() {
    echo ""
    echo -e "${BOLD}${WHITE}MailBaby Email Delivery and Management Service API command line client (API version 1.4.0)${OFF}"
    echo ""
    echo -e "License: GNU GPLv3"
    echo -e "Contact: support@interserver.net"
    echo ""
read -r -d '' appdescription <<EOF

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**

# Overview

This is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).

# Mail Orders

Every sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric 'id' and a corresponding SMTP username ('mb<id>').  Most calls accept an optional 'id' parameter; when omitted the API automatically selects the first active order on your account. Use 'GET /mail' to list all orders, and 'GET /mail/{id}' to inspect a single order including its current SMTP password.

# Sending Email

Three sending methods are available depending on your use-case:
| Endpoint | Best for | |----------|----------| | 'POST /mail/send' | Simple single-recipient messages | | 'POST /mail/advsend' | Multiple recipients, CC/BCC, attachments, named contacts | | 'POST /mail/rawsend' | Pre-built RFC 822 messages (e.g. DKIM-signed payloads) |

After a successful send each endpoint returns a 'GenericResponse' whose 'text' field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in 'GET /mail/log' via the 'mailid' query parameter.

# Filtering & Logs

'GET /mail/log' provides paginated access to every message accepted by the relay for your account.  Combine any of the query parameters to narrow results — e.g. 'from', 'to', 'subject', 'messageId', 'origin', 'mx', 'startDate'/'endDate', and 'delivered'.

# Blocking

Two independent mechanisms exist for suppressing unwanted email:
- **Block lists** ('GET /mail/blocks', 'POST /mail/blocks/delete') — addresses flagged by the
  system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects).
- **Deny rules** ('GET /mail/rules', 'POST /mail/rules', 'DELETE /mail/rules/{ruleId}') —
  custom rules you configure to reject specific senders, domains, destination addresses, or
  subject-line prefixes before a message is even attempted.


# Authentication

In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.
We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.
Pass your key in the 'X-API-KEY' HTTP request header for every protected call.
EOF
echo "$appdescription" | paste -sd' ' - | fold -sw 80
}


##############################################################################
#
# Print REST api version
#
##############################################################################
print_version() {
    echo ""
    echo -e "${BOLD}MailBaby Email Delivery and Management Service API command line client (API version 1.4.0)${OFF}"
    echo ""
}

##############################################################################
#
# Print help for addRule operation
#
##############################################################################
print_addRule_help() {
    echo ""
    echo -e "${BOLD}${WHITE}addRule - Creates a new email deny rule${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.

The 'type' field selects the matching strategy:
- **'email'** — exact match against the SMTP envelope 'MAIL FROM' address. - **'domain'** — matches any sender address at the specified domain. - **'destination'** — exact match against the SMTP envelope 'RCPT TO' address. - **'startswith'** — matches any sender address whose local-part (the portion
  before the '@') starts with the given string.  Only alphanumeric characters
  and '+', '_', '.', '-' are permitted in the prefix.


If 'username' is provided it must be the SMTP username of one of your active mail orders (e.g. 'mb20682').  If omitted the rule is associated with your first active order.

On success the response 'text' field contains the newly created rule's 'id', which can later be passed to 'DELETE /mail/rules/{ruleId}' to remove it." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Rule created successfully${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=404
    echo -e "${result_color_table[${code:0:1}]}  404;The specified resource was not found or does not belong to your account.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for deleteRule operation
#
##############################################################################
print_deleteRule_help() {
    echo ""
    echo -e "${BOLD}${WHITE}deleteRule - Removes a deny mail rule${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Permanently removes a single deny rule identified by its numeric 'ruleId'.

The 'ruleId' is the 'id' field returned by 'GET /mail/rules' or the 'text' field from a successful 'POST /mail/rules' response.

Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo -e "  * ${GREEN}ruleId${OFF} ${BLUE}[integer]${OFF} ${RED}(required)${OFF} ${CYAN}(default: null)${OFF} - The numeric ID of the deny rule to delete.  Obtain this from the 'id' field in 'GET /mail/rules' or the 'text' field of a 'POST /mail/rules' response. ${YELLOW}Specify as: ruleId=value${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Rule deleted successfully${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=404
    echo -e "${result_color_table[${code:0:1}]}  404;The specified resource was not found or does not belong to your account.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for delistBlock operation
#
##############################################################################
print_delistBlock_help() {
    echo ""
    echo -e "${BOLD}${WHITE}delistBlock - Removes an email address from the block lists${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Delists an email address from all three block list stores:
1. The rspamd spam-filter database ('fromemail' / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.

Use 'GET /mail/blocks' to discover which addresses are currently blocked.  The 'from' field in any returned block entry is a valid input for this call.

**Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo -e "  * ${GREEN}body${OFF} ${BLUE}[application/json,multipart/form-data]${OFF} ${RED}(required)${OFF}${OFF} - " | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Address successfully delisted${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=404
    echo -e "${result_color_table[${code:0:1}]}  404;The specified resource was not found or does not belong to your account.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for getMailBlocks operation
#
##############################################################################
print_getMailBlocks_help() {
    echo ""
    echo -e "${BOLD}${WHITE}getMailBlocks - Displays a list of blocked email addresses${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:

- **'local'** — messages flagged by the 'LOCAL_BL_RCPT' rspamd rule.  These are
  messages sent to recipients on your account's local block list.
- **'mbtrap'** — messages flagged by the 'MBTRAP' rspamd rule.  These are messages
  that triggered MailBaby's internal trap / honeypot detection.
- **'subject'** — senders whose recent messages contain spam-indicative subjects
  (strings containing '@', 'smtp', 'socks4', or 'socks5') with high repetition
  (more than 4 identical subjects from the same sender in the last 3 days).


The 'local' and 'mbtrap' results cover the last 5 days.  The 'subject' results cover the last 3 days.

A sender address returned in any of these lists can be delisted using 'POST /mail/blocks/delete' with the 'email' field set to that address." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;OK${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for getRules operation
#
##############################################################################
print_getRules_help() {
    echo ""
    echo -e "${BOLD}${WHITE}getRules - Displays a listing of deny email rules${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.

Four rule types are supported:
| 'type' | 'data' format | Effect | |--------|---------------|--------| | 'email' | 'user@domain.com' | Rejects any message from this exact sender address | | 'domain' | 'domain.com' | Rejects any message from any address at this domain | | 'destination' | 'user@domain.com' | Rejects any message addressed to this recipient | | 'startswith' | 'prefix' | Rejects any message whose sender address begins with this string (alphanumeric, '+', '_', '.', '-' only) |

Use 'POST /mail/rules' to add new rules and 'DELETE /mail/rules/{ruleId}' to remove them.  The 'id' field in each returned record is the value needed for the delete call." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;OK${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for getStats operation
#
##############################################################################
print_getStats_help() {
    echo ""
    echo -e "${BOLD}${WHITE}getStats - Account usage statistics${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.

The response includes:
- **'usage'** — total messages accepted by the relay during the current billing
  cycle (used for cost calculation).
- **'cost'** — estimated cost for the billing cycle based on the base plan price
  plus per-email charges.
- **'received'** / **'sent'** — count of messages accepted by the relay /
  successfully delivered to the destination MX within the selected 'time' window.
- **'volume'** — top-500 breakdown of message counts grouped by source IP ('ip'),
  destination address ('to'), and sender address ('from') within the selected window.


**Time windows** (controlled by the 'time' parameter):
| Value | Window | |-------|--------| | '1h' | Last 1 hour (default) | | '24h' | Last 24 hours | | '7d' | Last 7 days | | 'month' | Current calendar month (1st to now) | | 'day' | Today (midnight to now) | | 'billing' | Current billing cycle (last invoice date to next invoice date) | | 'all' | All time |" | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo -e "  * ${GREEN}time${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: 1h)${OFF} - The time window to scope 'received', 'sent', and 'volume' statistics. Does not affect 'usage' or 'cost', which are always calculated over the current billing cycle.  Defaults to '1h'.${YELLOW} Specify as: time=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;OK${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for viewMailLog operation
#
##############################################################################
print_viewMailLog_help() {
    echo ""
    echo -e "${BOLD}${WHITE}viewMailLog - Displays the mail log${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.

**Pagination** is controlled by 'skip' and 'limit'.  The response includes a 'total' count so clients can determine how many pages exist.

**Date filtering** uses Unix timestamps ('startDate' / 'endDate').  For example, to retrieve emails sent in January 2024: 'startDate=1704067200&endDate=1706745599'.

**Delivery status** can be filtered with the 'delivered' parameter: 'delivered=1' returns only successfully delivered messages; 'delivered=0' returns messages still in queue or that failed.

**Address filtering** distinguishes between the SMTP envelope address ('from', 'to') and message headers ('headerfrom' for the 'From:' header, 'replyto' for 'Reply-To:'). These may differ when a message is sent on behalf of another address.

The 'mailid' parameter corresponds to the 'id' field in the returned 'MailLogEntry' objects, **not** the '_id' field.  It also matches the transaction ID returned in the 'text' field of a successful send response from '/mail/send', '/mail/advsend', or '/mail/rawsend'.

The 'messageId' parameter searches the 'Message-ID' email header (case-insensitive substring match)." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo -e "  * ${GREEN}id${OFF} ${BLUE}[integer]${OFF} ${CYAN}(default: null)${OFF} - The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from 'GET /mail' or 'GET /mail/{id}'.${YELLOW} Specify as: id=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}origin${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.${YELLOW} Specify as: origin=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}mx${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by the MX hostname the relay attempted delivery to.  For example 'mx.google.com' would return messages destined for Gmail recipients. Maps to 'mxHostname' in the 'MailLogEntry' response.${YELLOW} Specify as: mx=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}from${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by SMTP envelope 'MAIL FROM' address (exact match).  This is the address the relay used for bounce handling and may differ from the 'From:' message header.  For header-level filtering use 'headerfrom'.${YELLOW} Specify as: from=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}to${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by SMTP envelope 'RCPT TO' address (exact match).  This is the delivery address used by the relay and may differ from the 'To:' header when BCC recipients are involved.${YELLOW} Specify as: to=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}subject${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by email 'Subject' header (exact match).  To search for a substring, include it in the full subject text.${YELLOW} Specify as: subject=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}mailid${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by the relay-assigned mail ID string (exact match).  This corresponds to the 'id' field in 'MailLogEntry' and to the 'text' value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as '185997065c60008840'.${YELLOW} Specify as: mailid=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}messageId${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by the 'Message-ID' email header using a substring (case-insensitive) match.  The 'Message-ID' is assigned by the sending mail client and is visible in the 'messageId' field of 'MailLogEntry'.  Useful when you know the message ID generated by your application but not the relay 'mailid'.${YELLOW} Specify as: messageId=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}replyto${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by the 'Reply-To' message header address (exact match).  Only returns messages where this header was explicitly set.${YELLOW} Specify as: replyto=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}headerfrom${OFF} ${BLUE}[string]${OFF} ${CYAN}(default: null)${OFF} - Filter by the 'From' message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope 'from' parameter when sending on behalf of another address.${YELLOW} Specify as: headerfrom=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}delivered${OFF} ${BLUE}[integer]${OFF} ${CYAN}(default: null)${OFF} - Filter by delivery status.  '1' returns only messages that were successfully delivered to the destination MX.  '0' returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.${YELLOW} Specify as: delivered=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}skip${OFF} ${BLUE}[integer]${OFF} ${CYAN}(default: 0)${OFF} - Number of records to skip for pagination.  Use in combination with 'limit' to page through large result sets.  Defaults to '0' (no skip).${YELLOW} Specify as: skip=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}limit${OFF} ${BLUE}[integer]${OFF} ${CYAN}(default: 100)${OFF} - Maximum number of records to return per page.  Defaults to '100'. Maximum allowed value is '10000'.  The response also includes a 'total' field with the full matched count so you can calculate the number of pages.${YELLOW} Specify as: limit=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}startDate${OFF} ${BLUE}[integer]${OFF} ${CYAN}(default: null)${OFF} - Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a 'time' value **greater than or equal to** this value will be included.${YELLOW} Specify as: startDate=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e "  * ${GREEN}endDate${OFF} ${BLUE}[integer]${OFF} ${CYAN}(default: null)${OFF} - Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a 'time' value **less than or equal to** this value will be included.${YELLOW} Specify as: endDate=value${OFF}" \
        | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Paginated list of mail log entries${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for rawMail operation
#
##############################################################################
print_rawMail_help() {
    echo ""
    echo -e "${BOLD}${WHITE}rawMail - Sends a raw RFC 822 email${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.

This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.

The 'From' and recipient addresses are parsed automatically from the message headers ('From', 'To', 'Cc', 'Bcc').  You do **not** need to specify them separately.

If an 'id' is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.

On success the response 'text' field contains the relay transaction ID.  This ID can be used with 'GET /mail/log' (via the 'mailid' query parameter) to look up the delivery record." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo -e "  * ${GREEN}body${OFF} ${BLUE}[application/json,multipart/form-data]${OFF} ${RED}(required)${OFF}${OFF} - " | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Email accepted for delivery${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=404
    echo -e "${result_color_table[${code:0:1}]}  404;The specified resource was not found or does not belong to your account.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for sendAdvMail operation
#
##############################################################################
print_sendAdvMail_help() {
    echo ""
    echo -e "${BOLD}${WHITE}sendAdvMail - Sends an Email with Advanced Options${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.

**Content-type flexibility** — the request body may be submitted as either 'application/x-www-form-urlencoded' or 'application/json'.  When using form encoding, address fields ('from', 'to', 'replyto', 'cc', 'bcc') accept both a plain RFC 822 comma-separated string (e.g. '\"Joe <joe@example.com>, jane@example.com\"') and the structured '[{\"email\":\"...\",\"name\":\"...\"}]' array format.  When using JSON, both formats are equally supported.

**HTML detection** is automatic — if 'body' contains HTML tags the 'Content-Type' is set to 'text/html'; otherwise 'text/plain'.

**Attachments** must be base64-encoded.  Each attachment requires at least a 'data' field; the optional 'filename' field controls the attachment name shown to recipients.

If an 'id' is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.

On success the response 'text' field contains the relay transaction ID which can be looked up in 'GET /mail/log' via the 'mailid' query parameter.

## Examples

### Form — basic string addresses
'''sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' \\
  -d 'body=Hello' \\
  -d from=user@domain.com \\
  -d to=support@interserver.net
'''
### Form — RFC 822 named addresses
'''sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' \\
  -d 'body=Hello' \\
  -d 'from=Joe <user@domain.com>' \\
  -d 'to=Jane <support@interserver.net>'
'''
### Form — multiple recipients as array
'''sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/x-www-form-urlencoded' \\
  -d 'subject=Welcome' -d 'body=Hello' \\
  -d from=user@domain.com \\
  -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\
  -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net'
'''
### JSON — structured objects
'''sh curl -X POST https://api.mailbaby.net/mail/advsend \\
  -H 'X-API-KEY: YOUR_API_KEY' \\
  -H 'Content-Type: application/json' \\
  -d '{
    \"subject\": \"Welcome\",
    \"body\": \"<h1>Hello</h1>\",
    \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},
    \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],
    \"cc\": [{\"email\": \"manager@client.com\"}],
    \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]
  }'
'''" | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Email accepted for delivery${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=404
    echo -e "${result_color_table[${code:0:1}]}  404;The specified resource was not found or does not belong to your account.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for sendMail operation
#
##############################################################################
print_sendMail_help() {
    echo ""
    echo -e "${BOLD}${WHITE}sendMail - Sends an Email${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.

**HTML detection** is automatic — if the 'body' value contains any HTML tags the message will be sent as 'text/html'; otherwise it is sent as 'text/plain'.

The 'from' address is also automatically set as the 'Reply-To' header.

*Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use 'POST /mail/advsend' instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use 'POST /mail/rawsend'.

On success the response 'text' field contains the relay transaction ID.  This ID can be used with 'GET /mail/log' (via the 'mailid' query parameter) to look up the delivery record." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Email accepted for delivery${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=404
    echo -e "${result_color_table[${code:0:1}]}  404;The specified resource was not found or does not belong to your account.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for getMailOrderById operation
#
##############################################################################
print_getMailOrderById_help() {
    echo ""
    echo -e "${BOLD}${WHITE}getMailOrderById - Displays details for a single mail order${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Returns the full detail record for one specific mail order identified by its numeric 'id'.  In addition to the fields returned by 'GET /mail', this endpoint also includes the current **SMTP password** for the order.

The 'username' and 'password' values returned here can be used directly to authenticate against 'relay.mailbaby.net:25' (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.

The 'id' path parameter is the same integer 'id' value returned by 'GET /mail'." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo -e "${BOLD}${WHITE}Parameters${OFF}"
    echo -e "  * ${GREEN}id${OFF} ${BLUE}[integer]${OFF} ${RED}(required)${OFF} ${CYAN}(default: null)${OFF} - The numeric ID of the mail order. ${YELLOW}Specify as: id=value${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;OK${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=400
    echo -e "${result_color_table[${code:0:1}]}  400;Bad request — one or more input parameters were missing or invalid.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=404
    echo -e "${result_color_table[${code:0:1}]}  404;The specified resource was not found or does not belong to your account.${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for getMailOrders operation
#
##############################################################################
print_getMailOrders_help() {
    echo ""
    echo -e "${BOLD}${WHITE}getMailOrders - Displays a list of mail service orders${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric 'id', the 'status' ('active' or 'canceled'), the SMTP 'username' (always 'mb<id>'), and an optional human-readable 'comment'.

The 'id' values returned here are used as the 'id' input parameter on all sending endpoints ('/mail/send', '/mail/advsend', '/mail/rawsend') as well as the log and stats queries.  When the 'id' parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.

To retrieve full details — including the current SMTP password — for a single order use 'GET /mail/{id}'." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;OK${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=401
    echo -e "${result_color_table[${code:0:1}]}  401;Authentication failed.  Ensure you are sending a valid 'X-API-KEY' header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security).${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}
##############################################################################
#
# Print help for pingServer operation
#
##############################################################################
print_pingServer_help() {
    echo ""
    echo -e "${BOLD}${WHITE}pingServer - Checks if the server is running${OFF}${BLUE}(AUTH - HEADER)${OFF}" | paste -sd' ' - | fold -sw 80 | sed '2,$s/^/    /'
    echo -e ""
    echo -e "A lightweight health-check endpoint.  Returns a plain-text '200 OK' when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks." | paste -sd' ' - | fold -sw 80
    echo -e ""
    echo ""
    echo -e "${BOLD}${WHITE}Responses${OFF}"
    code=200
    echo -e "${result_color_table[${code:0:1}]}  200;Server is up and running${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
    code=0
    echo -e "${result_color_table[${code:0:1}]}  0;Something is wrong${OFF}" | paste -sd' ' - | column -t -s ';' | fold -sw 80 | sed '2,$s/^/       /'
}


##############################################################################
#
# Call addRule operation
#
##############################################################################
call_addRule() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/rules" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="POST"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    body_form_urlencoded=$(body_parameters_to_form_urlencoded)
    if [[ "$print_curl" = true ]]; then
        echo "curl ${body_form_urlencoded} ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl ${body_form_urlencoded} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call deleteRule operation
#
##############################################################################
call_deleteRule() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=(ruleId)
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/rules/{ruleId}" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="DELETE"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call delistBlock operation
#
##############################################################################
call_delistBlock() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/blocks/delete" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="POST"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    local body_json_curl=""

    #
    # Check if the user provided 'Content-type' headers in the
    # command line. If not try to set them based on the OpenAPI specification
    # if values produces and consumes are defined unambiguously
    #


    if [[ -z $header_content_type && "$force" = false ]]; then
        :
        echo "ERROR: Request's content-type not specified!!!"
        echo "This operation expects content-type in one of the following formats:"
        echo -e "\\t- application/json"
        echo -e "\\t- multipart/form-data"
        echo ""
        echo "Use '--content-type' to set proper content type"
        exit 1
    else
        headers_curl="${headers_curl} -H 'Content-type: ${header_content_type}'"
    fi


    #
    # If we have received some body content over pipe, pass it from the
    # temporary file to cURL
    #
    if [[ -n $body_content_temp_file ]]; then
        if [[ "$print_curl" = true ]]; then
            echo "cat ${body_content_temp_file} | curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\" -d @-"
        else
            eval "cat ${body_content_temp_file} | curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\" -d @-"
        fi
        rm "${body_content_temp_file}"
    #
    # If not, try to build the content body from arguments KEY==VALUE and KEY:=VALUE
    #
    else
        body_json_curl=$(body_parameters_to_json)
        if [[ "$print_curl" = true ]]; then
            echo "curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} ${body_json_curl} \"${host}${path}\""
        else
            eval "curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} ${body_json_curl} \"${host}${path}\""
        fi
    fi
}

##############################################################################
#
# Call getMailBlocks operation
#
##############################################################################
call_getMailBlocks() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/blocks" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="GET"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call getRules operation
#
##############################################################################
call_getRules() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/rules" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="GET"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call getStats operation
#
##############################################################################
call_getStats() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(time  )
    local path

    if ! path=$(build_request_path "/mail/stats" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="GET"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call viewMailLog operation
#
##############################################################################
call_viewMailLog() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(id origin mx from to subject mailid messageId replyto headerfrom delivered skip limit startDate endDate  )
    local path

    if ! path=$(build_request_path "/mail/log" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="GET"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call rawMail operation
#
##############################################################################
call_rawMail() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/rawsend" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="POST"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    local body_json_curl=""

    #
    # Check if the user provided 'Content-type' headers in the
    # command line. If not try to set them based on the OpenAPI specification
    # if values produces and consumes are defined unambiguously
    #


    if [[ -z $header_content_type && "$force" = false ]]; then
        :
        echo "ERROR: Request's content-type not specified!!!"
        echo "This operation expects content-type in one of the following formats:"
        echo -e "\\t- application/json"
        echo -e "\\t- multipart/form-data"
        echo ""
        echo "Use '--content-type' to set proper content type"
        exit 1
    else
        headers_curl="${headers_curl} -H 'Content-type: ${header_content_type}'"
    fi


    #
    # If we have received some body content over pipe, pass it from the
    # temporary file to cURL
    #
    if [[ -n $body_content_temp_file ]]; then
        if [[ "$print_curl" = true ]]; then
            echo "cat ${body_content_temp_file} | curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\" -d @-"
        else
            eval "cat ${body_content_temp_file} | curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\" -d @-"
        fi
        rm "${body_content_temp_file}"
    #
    # If not, try to build the content body from arguments KEY==VALUE and KEY:=VALUE
    #
    else
        body_json_curl=$(body_parameters_to_json)
        if [[ "$print_curl" = true ]]; then
            echo "curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} ${body_json_curl} \"${host}${path}\""
        else
            eval "curl ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} ${body_json_curl} \"${host}${path}\""
        fi
    fi
}

##############################################################################
#
# Call sendAdvMail operation
#
##############################################################################
call_sendAdvMail() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/advsend" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="POST"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    body_form_urlencoded=$(body_parameters_to_form_urlencoded)
    if [[ "$print_curl" = true ]]; then
        echo "curl ${body_form_urlencoded} ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl ${body_form_urlencoded} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call sendMail operation
#
##############################################################################
call_sendMail() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/send" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="POST"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    body_form_urlencoded=$(body_parameters_to_form_urlencoded)
    if [[ "$print_curl" = true ]]; then
        echo "curl ${body_form_urlencoded} ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl ${body_form_urlencoded} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call getMailOrderById operation
#
##############################################################################
call_getMailOrderById() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=(id)
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail/{id}" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="GET"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call getMailOrders operation
#
##############################################################################
call_getMailOrders() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/mail" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="GET"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}

##############################################################################
#
# Call pingServer operation
#
##############################################################################
call_pingServer() {
    # ignore error about 'path_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local path_parameter_names=()
    # ignore error about 'query_parameter_names' being unused; passed by reference
    # shellcheck disable=SC2034
    local query_parameter_names=(  )
    local path

    if ! path=$(build_request_path "/ping" path_parameter_names query_parameter_names); then
        ERROR_MSG=$path
        exit 1
    fi
    local method="GET"
    local headers_curl
    headers_curl=$(header_arguments_to_curl)
    if [[ -n $header_accept ]]; then
        headers_curl="${headers_curl} -H 'Accept: ${header_accept}'"
    fi

    local basic_auth_option=""
    if [[ -n $basic_auth_credential ]]; then
        basic_auth_option="-u ${basic_auth_credential}"
    fi
    if [[ "$print_curl" = true ]]; then
        echo "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    else
        eval "curl -d '' ${basic_auth_option} ${curl_arguments} ${headers_curl} -X ${method} \"${host}${path}\""
    fi
}



##############################################################################
#
# Main
#
##############################################################################


# Check dependencies
type curl >/dev/null 2>&1 || { echo >&2 "ERROR: You do not have 'cURL' installed."; exit 1; }
type sed >/dev/null 2>&1 || { echo >&2 "ERROR: You do not have 'sed' installed."; exit 1; }
type column >/dev/null 2>&1 || { echo >&2 "ERROR: You do not have 'bsdmainutils' installed."; exit 1; }

#
# Process command line
#
# Pass all arguments before 'operation' to cURL except the ones we override
#
take_user=false
take_host=false
take_accept_header=false
take_contenttype_header=false

for key in "$@"; do
# Take the value of -u|--user argument
if [[ "$take_user" = true ]]; then
    basic_auth_credential="$key"
    take_user=false
    continue
fi
# Take the value of --host argument
if [[ "$take_host" = true ]]; then
    host="$key"
    take_host=false
    continue
fi
# Take the value of --accept argument
if [[ "$take_accept_header" = true ]]; then
    header_accept=$(lookup_mime_type "$key")
    take_accept_header=false
    continue
fi
# Take the value of --content-type argument
if [[ "$take_contenttype_header" = true ]]; then
    header_content_type=$(lookup_mime_type "$key")
    take_contenttype_header=false
    continue
fi
case $key in
    -h|--help)
    if [[ "x$operation" == "x" ]]; then
        print_help
        exit 0
    else
        eval "print_${operation}_help"
        exit 0
    fi
    ;;
    -V|--version)
    print_version
    exit 0
    ;;
    --about)
    print_about
    exit 0
    ;;
    -u|--user)
    take_user=true
    ;;
    --host)
    take_host=true
    ;;
    --force)
    force=true
    ;;
    -ac|--accept)
    take_accept_header=true
    ;;
    -ct|--content-type)
    take_contenttype_header=true
    ;;
    --dry-run)
    print_curl=true
    ;;
    -nc|--no-colors)
        RED=""
        GREEN=""
        YELLOW=""
        BLUE=""
        MAGENTA=""
        CYAN=""
        WHITE=""
        BOLD=""
        OFF=""
        result_color_table=( "" "" "" "" "" "" "" )
    ;;
    addRule)
    operation="addRule"
    ;;
    deleteRule)
    operation="deleteRule"
    ;;
    delistBlock)
    operation="delistBlock"
    ;;
    getMailBlocks)
    operation="getMailBlocks"
    ;;
    getRules)
    operation="getRules"
    ;;
    getStats)
    operation="getStats"
    ;;
    viewMailLog)
    operation="viewMailLog"
    ;;
    rawMail)
    operation="rawMail"
    ;;
    sendAdvMail)
    operation="sendAdvMail"
    ;;
    sendMail)
    operation="sendMail"
    ;;
    getMailOrderById)
    operation="getMailOrderById"
    ;;
    getMailOrders)
    operation="getMailOrders"
    ;;
    pingServer)
    operation="pingServer"
    ;;
    *==*)
    # Parse body arguments and convert them into top level
    # JSON properties passed in the body content as strings
    if [[ "$operation" ]]; then
        IFS='==' read -r body_key sep body_value <<< "$key"
        body_parameters[${body_key}]="\"${body_value}\""
    fi
    ;;
    --body=*)
    # Parse value of body as argument and convert it into only
    # the raw body content
    if [[ "$operation" ]]; then
        IFS='--body=' read -r body_value <<< "$key"
        body_value=${body_value##--body=}
        body_parameters["RAW_BODY"]="${body_value}"
        RAW_BODY=1
    fi
    ;;
    *:=*)
    # Parse body arguments and convert them into top level
    # JSON properties passed in the body content without quotes
    if [[ "$operation" ]]; then
        # ignore error about 'sep' being unused
        # shellcheck disable=SC2034
        IFS=':=' read -r body_key sep body_value <<< "$key"
        body_parameters[${body_key}]=${body_value}
    fi
    ;;
    +([^=]):*)
    # Parse header arguments and convert them into curl
    # only after the operation argument
    if [[ "$operation" ]]; then
        IFS=':' read -r header_name header_value <<< "$key"
        #
        # If the header key is the same as the api_key expected by API in the
        # header, override the ${apikey_auth_credential} variable
        #
        if [[ $header_name == "X-API-KEY" ]]; then
            apikey_auth_credential=$header_value
        fi
        header_arguments[$header_name]=$header_value
    else
        curl_arguments+=" $key"
    fi
    ;;
    -)
    body_content_temp_file=$(mktemp)
    cat - > "$body_content_temp_file"
    ;;
    *=*)
    # Parse operation arguments and convert them into curl
    # only after the operation argument
    if [[ "$operation" ]]; then
        IFS='=' read -r parameter_name parameter_value <<< "$key"
        if [[ -z "${operation_parameters[$parameter_name]+foo}" ]]; then
            operation_parameters[$parameter_name]=$(url_escape "${parameter_value}")
        else
            operation_parameters[$parameter_name]+=":::"$(url_escape "${parameter_value}")
        fi
    else
        curl_arguments+=" $key"
    fi
    ;;
    *)
    # If we are before the operation, treat the arguments as cURL arguments
    if [[ "x$operation" == "x" ]]; then
        # Maintain quotes around cURL arguments if necessary
        space_regexp="[[:space:]]"
        if [[ $key =~ $space_regexp ]]; then
            curl_arguments+=" \"$key\""
        else
            curl_arguments+=" $key"
        fi
    fi
    ;;
esac
done


# Check if user provided host name
if [[ -z "$host" ]]; then
    ERROR_MSG="ERROR: No hostname provided!!! You have to  provide on command line option '--host ...'"
    exit 1
fi

# Check if user specified operation ID
if [[ -z "$operation" ]]; then
    ERROR_MSG="ERROR: No operation specified!!!"
    exit 1
fi


# Run cURL command based on the operation ID
case $operation in
    addRule)
    call_addRule
    ;;
    deleteRule)
    call_deleteRule
    ;;
    delistBlock)
    call_delistBlock
    ;;
    getMailBlocks)
    call_getMailBlocks
    ;;
    getRules)
    call_getRules
    ;;
    getStats)
    call_getStats
    ;;
    viewMailLog)
    call_viewMailLog
    ;;
    rawMail)
    call_rawMail
    ;;
    sendAdvMail)
    call_sendAdvMail
    ;;
    sendMail)
    call_sendMail
    ;;
    getMailOrderById)
    call_getMailOrderById
    ;;
    getMailOrders)
    call_getMailOrders
    ;;
    pingServer)
    call_pingServer
    ;;
    *)
    ERROR_MSG="ERROR: Unknown operation: $operation"
    exit 1
esac
