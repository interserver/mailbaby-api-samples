=begin
#MailBaby Email Delivery and Management Service API

#**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

OpenAPI spec version: 1.1.0
Contact: support@interserver.net
Generated by: https://github.com/swagger-api/swagger-codegen.git
Swagger Codegen version: 3.0.46
=end

module SwaggerClient
  class SendingApi
    attr_accessor :api_client

    def initialize(api_client = ApiClient.default)
      @api_client = api_client
    end
    # Sends an Email with Advanced Options
    # Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    # @param subject 
    # @param body 
    # @param from 
    # @param to 
    # @param replyto 
    # @param cc 
    # @param bcc 
    # @param attachments 
    # @param id 
    # @param [Hash] opts the optional parameters
    # @return [GenericResponse]
    def send_adv_mail(subject, body, from, to, replyto, cc, bcc, attachments, id, opts = {})
      data, _status_code, _headers = send_adv_mail_with_http_info(subject, body, from, to, replyto, cc, bcc, attachments, id, opts)
      data
    end

    # Sends an Email with Advanced Options
    # Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    # @param subject 
    # @param body 
    # @param from 
    # @param to 
    # @param replyto 
    # @param cc 
    # @param bcc 
    # @param attachments 
    # @param id 
    # @param [Hash] opts the optional parameters
    # @return [Array<(GenericResponse, Integer, Hash)>] GenericResponse data, response status code and response headers
    def send_adv_mail_with_http_info(subject, body, from, to, replyto, cc, bcc, attachments, id, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: SendingApi.send_adv_mail ...'
      end
      # verify the required parameter 'subject' is set
      if @api_client.config.client_side_validation && subject.nil?
        fail ArgumentError, "Missing the required parameter 'subject' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'body' is set
      if @api_client.config.client_side_validation && body.nil?
        fail ArgumentError, "Missing the required parameter 'body' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'from' is set
      if @api_client.config.client_side_validation && from.nil?
        fail ArgumentError, "Missing the required parameter 'from' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'to' is set
      if @api_client.config.client_side_validation && to.nil?
        fail ArgumentError, "Missing the required parameter 'to' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'replyto' is set
      if @api_client.config.client_side_validation && replyto.nil?
        fail ArgumentError, "Missing the required parameter 'replyto' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'cc' is set
      if @api_client.config.client_side_validation && cc.nil?
        fail ArgumentError, "Missing the required parameter 'cc' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'bcc' is set
      if @api_client.config.client_side_validation && bcc.nil?
        fail ArgumentError, "Missing the required parameter 'bcc' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'attachments' is set
      if @api_client.config.client_side_validation && attachments.nil?
        fail ArgumentError, "Missing the required parameter 'attachments' when calling SendingApi.send_adv_mail"
      end
      # verify the required parameter 'id' is set
      if @api_client.config.client_side_validation && id.nil?
        fail ArgumentError, "Missing the required parameter 'id' when calling SendingApi.send_adv_mail"
      end
      # resource path
      local_var_path = '/mail/advsend'

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['application/json'])
      # HTTP header 'Content-Type'
      header_params['Content-Type'] = @api_client.select_header_content_type(['application/x-www-form-urlencoded', 'application/json'])

      # form parameters
      form_params = opts[:form_params] || {}
      form_params['subject'] = subject
      form_params['body'] = body
      form_params['from'] = from
      form_params['to'] = @api_client.build_collection_param(to, :multi)
      form_params['replyto'] = @api_client.build_collection_param(replyto, :multi)
      form_params['cc'] = @api_client.build_collection_param(cc, :multi)
      form_params['bcc'] = @api_client.build_collection_param(bcc, :multi)
      form_params['attachments'] = @api_client.build_collection_param(attachments, :multi)
      form_params['id'] = id

      # http body (model)
      post_body = opts[:body] || @api_client.object_to_http_body(body) 

      return_type = opts[:return_type] || 'GenericResponse' 

      auth_names = opts[:auth_names] || ['apiKeyAuth']
      data, status_code, headers = @api_client.call_api(:POST, local_var_path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type)

      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: SendingApi#send_adv_mail\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
    # Sends an Email with Advanced Options
    # Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    # @param body 
    # @param [Hash] opts the optional parameters
    # @return [GenericResponse]
    def send_adv_mail(body, opts = {})
      data, _status_code, _headers = send_adv_mail_with_http_info(body, opts)
      data
    end

    # Sends an Email with Advanced Options
    # Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
    # @param body 
    # @param [Hash] opts the optional parameters
    # @return [Array<(GenericResponse, Integer, Hash)>] GenericResponse data, response status code and response headers
    def send_adv_mail_with_http_info(body, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: SendingApi.send_adv_mail ...'
      end
      # verify the required parameter 'body' is set
      if @api_client.config.client_side_validation && body.nil?
        fail ArgumentError, "Missing the required parameter 'body' when calling SendingApi.send_adv_mail"
      end
      # resource path
      local_var_path = '/mail/advsend'

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['application/json'])
      # HTTP header 'Content-Type'
      header_params['Content-Type'] = @api_client.select_header_content_type(['application/x-www-form-urlencoded', 'application/json'])

      # form parameters
      form_params = opts[:form_params] || {}
      form_params['subject'] = subject
      form_params['body'] = body
      form_params['from'] = from
      form_params['to'] = @api_client.build_collection_param(to, :multi)
      form_params['replyto'] = @api_client.build_collection_param(replyto, :multi)
      form_params['cc'] = @api_client.build_collection_param(cc, :multi)
      form_params['bcc'] = @api_client.build_collection_param(bcc, :multi)
      form_params['attachments'] = @api_client.build_collection_param(attachments, :multi)
      form_params['id'] = id

      # http body (model)
      post_body = opts[:body] || @api_client.object_to_http_body(body) 

      return_type = opts[:return_type] || 'GenericResponse' 

      auth_names = opts[:auth_names] || ['apiKeyAuth']
      data, status_code, headers = @api_client.call_api(:POST, local_var_path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type)

      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: SendingApi#send_adv_mail\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
    # Sends an Email
    # Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
    # @param to 
    # @param from 
    # @param subject 
    # @param body 
    # @param [Hash] opts the optional parameters
    # @return [GenericResponse]
    def send_mail(to, from, subject, body, opts = {})
      data, _status_code, _headers = send_mail_with_http_info(to, from, subject, body, opts)
      data
    end

    # Sends an Email
    # Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
    # @param to 
    # @param from 
    # @param subject 
    # @param body 
    # @param [Hash] opts the optional parameters
    # @return [Array<(GenericResponse, Integer, Hash)>] GenericResponse data, response status code and response headers
    def send_mail_with_http_info(to, from, subject, body, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: SendingApi.send_mail ...'
      end
      # verify the required parameter 'to' is set
      if @api_client.config.client_side_validation && to.nil?
        fail ArgumentError, "Missing the required parameter 'to' when calling SendingApi.send_mail"
      end
      # verify the required parameter 'from' is set
      if @api_client.config.client_side_validation && from.nil?
        fail ArgumentError, "Missing the required parameter 'from' when calling SendingApi.send_mail"
      end
      # verify the required parameter 'subject' is set
      if @api_client.config.client_side_validation && subject.nil?
        fail ArgumentError, "Missing the required parameter 'subject' when calling SendingApi.send_mail"
      end
      # verify the required parameter 'body' is set
      if @api_client.config.client_side_validation && body.nil?
        fail ArgumentError, "Missing the required parameter 'body' when calling SendingApi.send_mail"
      end
      # resource path
      local_var_path = '/mail/send'

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['application/json'])
      # HTTP header 'Content-Type'
      header_params['Content-Type'] = @api_client.select_header_content_type(['application/x-www-form-urlencoded', 'application/json'])

      # form parameters
      form_params = opts[:form_params] || {}
      form_params['to'] = to
      form_params['from'] = from
      form_params['subject'] = subject
      form_params['body'] = body

      # http body (model)
      post_body = opts[:body] || @api_client.object_to_http_body(body) 

      return_type = opts[:return_type] || 'GenericResponse' 

      auth_names = opts[:auth_names] || ['apiKeyAuth']
      data, status_code, headers = @api_client.call_api(:POST, local_var_path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type)

      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: SendingApi#send_mail\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
    # Sends an Email
    # Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
    # @param body 
    # @param [Hash] opts the optional parameters
    # @return [GenericResponse]
    def send_mail(body, opts = {})
      data, _status_code, _headers = send_mail_with_http_info(body, opts)
      data
    end

    # Sends an Email
    # Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
    # @param body 
    # @param [Hash] opts the optional parameters
    # @return [Array<(GenericResponse, Integer, Hash)>] GenericResponse data, response status code and response headers
    def send_mail_with_http_info(body, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: SendingApi.send_mail ...'
      end
      # verify the required parameter 'body' is set
      if @api_client.config.client_side_validation && body.nil?
        fail ArgumentError, "Missing the required parameter 'body' when calling SendingApi.send_mail"
      end
      # resource path
      local_var_path = '/mail/send'

      # query parameters
      query_params = opts[:query_params] || {}

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['application/json'])
      # HTTP header 'Content-Type'
      header_params['Content-Type'] = @api_client.select_header_content_type(['application/x-www-form-urlencoded', 'application/json'])

      # form parameters
      form_params = opts[:form_params] || {}
      form_params['to'] = to
      form_params['from'] = from
      form_params['subject'] = subject
      form_params['body'] = body

      # http body (model)
      post_body = opts[:body] || @api_client.object_to_http_body(body) 

      return_type = opts[:return_type] || 'GenericResponse' 

      auth_names = opts[:auth_names] || ['apiKeyAuth']
      data, status_code, headers = @api_client.call_api(:POST, local_var_path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type)

      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: SendingApi#send_mail\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
  end
end