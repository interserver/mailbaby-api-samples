package org.openapitools.api;

import org.openapitools.api.ApiUtils
import org.openapitools.model.EmailAddressTypes
import org.openapitools.model.EmailAddressesTypes
import org.openapitools.model.ErrorMessage
import org.openapitools.model.GenericResponse
import org.openapitools.model.MailAttachment

class SendingApi {
    String basePath = "https://api.mailbaby.net"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

    def sendAdvMail ( String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, Long id, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/advsend"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (subject == null) {
            throw new RuntimeException("missing required params subject")
        }
        // verify required params are set
        if (body == null) {
            throw new RuntimeException("missing required params body")
        }
        // verify required params are set
        if (from == null) {
            throw new RuntimeException("missing required params from")
        }
        // verify required params are set
        if (to == null) {
            throw new RuntimeException("missing required params to")
        }




        contentType = 'application/x-www-form-urlencoded';
        bodyParams = [:]
        bodyParams.put("subject", subject)
        bodyParams.put("body", body)
        bodyParams.put("from", from)
        bodyParams.put("to", to)
        bodyParams.put("replyto", replyto)
        bodyParams.put("cc", cc)
        bodyParams.put("bcc", bcc)
        bodyParams.put("attachments", attachments)
        bodyParams.put("id", id)

        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

    def sendMail ( String to, String from, String subject, String body, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/mail/send"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def contentType

        // verify required params are set
        if (to == null) {
            throw new RuntimeException("missing required params to")
        }
        // verify required params are set
        if (from == null) {
            throw new RuntimeException("missing required params from")
        }
        // verify required params are set
        if (subject == null) {
            throw new RuntimeException("missing required params subject")
        }
        // verify required params are set
        if (body == null) {
            throw new RuntimeException("missing required params body")
        }




        contentType = 'application/x-www-form-urlencoded';
        bodyParams = [:]
        bodyParams.put("to", to)
        bodyParams.put("from", from)
        bodyParams.put("subject", subject)
        bodyParams.put("body", body)

        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, contentType,
                    "POST", "",
                    GenericResponse.class )

    }

}
