=begin
#MailBaby Email Delivery and Management Service API

#**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 

OpenAPI spec version: 1.1.0
Contact: support@interserver.net
Generated by: https://github.com/swagger-api/swagger-codegen.git
Swagger Codegen version: 3.0.71
=end

module SwaggerClient
  class HistoryApi
    attr_accessor :api_client

    def initialize(api_client = ApiClient.default)
      @api_client = api_client
    end
    # Account usage statistics.
    # Returns information about the usage on your mail accounts.
    # @param [Hash] opts the optional parameters
    # @option opts [String] :time The timeframe for the statistics.
    # @return [MailStatsType]
    def get_stats(opts = {})
      data, _status_code, _headers = get_stats_with_http_info(opts)
      data
    end

    # Account usage statistics.
    # Returns information about the usage on your mail accounts.
    # @param [Hash] opts the optional parameters
    # @option opts [String] :time The timeframe for the statistics.
    # @return [Array<(MailStatsType, Integer, Hash)>] MailStatsType data, response status code and response headers
    def get_stats_with_http_info(opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: HistoryApi.get_stats ...'
      end
      if @api_client.config.client_side_validation && opts[:'time'] && !['all', 'billing', 'month', '7d', '24h', '1d', '1h'].include?(opts[:'time'])
        fail ArgumentError, 'invalid value for "time", must be one of all, billing, month, 7d, 24h, 1d, 1h'
      end
      # resource path
      local_var_path = '/mail/stats'

      # query parameters
      query_params = opts[:query_params] || {}
      query_params[:'time'] = opts[:'time'] if !opts[:'time'].nil?

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['application/json'])

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:body] 

      return_type = opts[:return_type] || 'MailStatsType' 

      auth_names = opts[:auth_names] || ['apiKeyAuth']
      data, status_code, headers = @api_client.call_api(:GET, local_var_path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type)

      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: HistoryApi#get_stats\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
    # displays the mail log
    # Get a listing of the emails sent through this system 
    # @param [Hash] opts the optional parameters
    # @option opts [Integer] :id The ID of your mail order this will be sent through.
    # @option opts [String] :origin originating ip address sending mail
    # @option opts [String] :mx mx record mail was sent to
    # @option opts [String] :from from email address
    # @option opts [String] :to to/destination email address
    # @option opts [String] :subject subject containing this string
    # @option opts [String] :mailid mail id
    # @option opts [Integer] :skip number of records to skip for pagination (default to 0)
    # @option opts [Integer] :limit maximum number of records to return (default to 100)
    # @option opts [Integer] :start_date earliest date to get emails in unix timestamp format
    # @option opts [Integer] :end_date earliest date to get emails in unix timestamp format
    # @option opts [String] :replyto Reply-To Email Address
    # @option opts [String] :headerfrom Header From Email Address
    # @option opts [String] :delivered Limiting the emails to wether or not they were delivered.
    # @return [MailLog]
    def view_mail_log(opts = {})
      data, _status_code, _headers = view_mail_log_with_http_info(opts)
      data
    end

    # displays the mail log
    # Get a listing of the emails sent through this system 
    # @param [Hash] opts the optional parameters
    # @option opts [Integer] :id The ID of your mail order this will be sent through.
    # @option opts [String] :origin originating ip address sending mail
    # @option opts [String] :mx mx record mail was sent to
    # @option opts [String] :from from email address
    # @option opts [String] :to to/destination email address
    # @option opts [String] :subject subject containing this string
    # @option opts [String] :mailid mail id
    # @option opts [Integer] :skip number of records to skip for pagination
    # @option opts [Integer] :limit maximum number of records to return
    # @option opts [Integer] :start_date earliest date to get emails in unix timestamp format
    # @option opts [Integer] :end_date earliest date to get emails in unix timestamp format
    # @option opts [String] :replyto Reply-To Email Address
    # @option opts [String] :headerfrom Header From Email Address
    # @option opts [String] :delivered Limiting the emails to wether or not they were delivered.
    # @return [Array<(MailLog, Integer, Hash)>] MailLog data, response status code and response headers
    def view_mail_log_with_http_info(opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug 'Calling API: HistoryApi.view_mail_log ...'
      end
      if @api_client.config.client_side_validation && opts[:'delivered'] && !['0', '1'].include?(opts[:'delivered'])
        fail ArgumentError, 'invalid value for "delivered", must be one of 0, 1'
      end
      # resource path
      local_var_path = '/mail/log'

      # query parameters
      query_params = opts[:query_params] || {}
      query_params[:'id'] = opts[:'id'] if !opts[:'id'].nil?
      query_params[:'origin'] = opts[:'origin'] if !opts[:'origin'].nil?
      query_params[:'mx'] = opts[:'mx'] if !opts[:'mx'].nil?
      query_params[:'from'] = opts[:'from'] if !opts[:'from'].nil?
      query_params[:'to'] = opts[:'to'] if !opts[:'to'].nil?
      query_params[:'subject'] = opts[:'subject'] if !opts[:'subject'].nil?
      query_params[:'mailid'] = opts[:'mailid'] if !opts[:'mailid'].nil?
      query_params[:'skip'] = opts[:'skip'] if !opts[:'skip'].nil?
      query_params[:'limit'] = opts[:'limit'] if !opts[:'limit'].nil?
      query_params[:'startDate'] = opts[:'start_date'] if !opts[:'start_date'].nil?
      query_params[:'endDate'] = opts[:'end_date'] if !opts[:'end_date'].nil?
      query_params[:'replyto'] = opts[:'replyto'] if !opts[:'replyto'].nil?
      query_params[:'headerfrom'] = opts[:'headerfrom'] if !opts[:'headerfrom'].nil?
      query_params[:'delivered'] = opts[:'delivered'] if !opts[:'delivered'].nil?

      # header parameters
      header_params = opts[:header_params] || {}
      # HTTP header 'Accept' (if needed)
      header_params['Accept'] = @api_client.select_header_accept(['application/json'])

      # form parameters
      form_params = opts[:form_params] || {}

      # http body (model)
      post_body = opts[:body] 

      return_type = opts[:return_type] || 'MailLog' 

      auth_names = opts[:auth_names] || ['apiKeyAuth']
      data, status_code, headers = @api_client.call_api(:GET, local_var_path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => return_type)

      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: HistoryApi#view_mail_log\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
  end
end
