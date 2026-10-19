require "json"

module OpenAPIClient
  module Api
  class Mail::Rules
    def initialize(@conn : Connection); end

    # Create a deny rule to block a sender, domain, destination, or prefix **Use this to prevent future relay attempts that match a pattern.** Required: &#x60;type&#x60; (&#x60;email&#x60;, &#x60;domain&#x60;, &#x60;destination&#x60;, or &#x60;startswith&#x60;) and &#x60;data&#x60; (the value to match). Optional: &#x60;user&#x60; (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#39;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it. 
    def create(user : String? = nil, _type : String? = nil, data : String? = nil) : Response(OpenAPIClient::GenericResponse)
      @conn.request(OpenAPIClient::GenericResponse,
        method: :POST,
        path: "/mail/rules",
        form: Hash(String, Crest::ParamsValue){ "user" => user, "type" => _type, "data" => data },
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # Delete a deny rule by its numeric ruleId **Destructive — permanently removes the rule.** Required: &#x60;ruleId&#x60; (path param; obtain from the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field returned by &#x60;POST /mail/rules&#x60;). Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.  The &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
    def delete(rule_id : Int32) : Response(OpenAPIClient::GenericResponse)
      @conn.request(OpenAPIClient::GenericResponse,
        method: :DELETE,
        path: "/mail/rules/{ruleId}".sub("{ruleId}", OpenAPIClient.enc(rule_id)),
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end

    # List custom deny rules (sender / domain / destination / prefix) **Use this to inspect or pick a &#x60;ruleId&#x60; to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |  Use &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call. 
    def list() : Response(Array(OpenAPIClient::DenyRuleRecord))
      @conn.request(Array(OpenAPIClient::DenyRuleRecord),
        method: :GET,
        path: "/mail/rules",
        accept: %w[application/json],
        auth: %w[apiKeyAuth])
    end
  end
  end

end
