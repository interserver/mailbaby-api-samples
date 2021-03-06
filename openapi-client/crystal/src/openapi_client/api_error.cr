# #MailBaby Email Delivery API
#
##**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
#
#The version of the OpenAPI document: 1.0.0
#Contact: support@interserver.net
#Generated by: https://openapi-generator.tech
#OpenAPI Generator version: 6.0.0-SNAPSHOT
#

module 
  class ApiError < Exception
    getter code : Int32?
    getter response_headers : Hash(String, Array(String) | String)?

    # Usage examples:
    #   ApiError.new
    #   ApiError.new(message: "message")
    #   ApiError.new(code: 500, response_headers: {}, message: "")
    #   ApiError.new(code: 404, message: "Not Found")
    def initialize(@code , @message, @response_headers)
    end

    def initialize(@code , @message)
    end

    # Override to_s to display a friendly error message
    def to_s
      msg = ""
      msg = msg + "\nHTTP status code: #{code}" if @code
      msg = msg + "\nResponse headers: #{response_headers}" if @response_headers
      if @message.nil? || @message.empty?
        msg = msg + "\nError message: the server returns an error but the HTTP response body is empty."
      else
        msg = msg + "\nResponse body: #{@message}"
      end

      msg
    end
  end
end
