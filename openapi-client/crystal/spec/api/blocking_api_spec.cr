# #MailBaby Email Delivery and Management Service API
#
##**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
#
#The version of the OpenAPI document: 1.1.0
#Contact: support@interserver.net
#Generated by: https://openapi-generator.tech
#OpenAPI Generator version: 7.0.0-SNAPSHOT
#

require "../spec_helper"
require "json"
require "time"

# Unit tests for OpenAPIClient::BlockingApi
# Automatically generated by openapi-generator (https://openapi-generator.tech)
# Please update as you see appropriate
describe "BlockingApi" do
  describe "test an instance of BlockingApi" do
    it "should create an instance of BlockingApi" do
      api_instance = OpenAPIClient::BlockingApi.new
      # TODO expect(api_instance).to be_instance_of(OpenAPIClient::BlockingApi)
    end
  end

  # unit tests for add_rule
  # Creates a new email deny rule.
  # Adds a new email deny rule into the system to block new emails that match the given criteria
  # @param _type The type of deny rule.
  # @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
  # @param [Hash] opts the optional parameters
  # @option opts [String] :user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
  # @return [GenericResponse]
  describe "add_rule test" do
    it "should work" do
      # assertion here. ref: https://crystal-lang.org/reference/guides/testing.html
    end
  end

  # unit tests for delete_rule
  # Removes an deny mail rule.
  # Removes one of the configured deny mail rules from the system.
  # @param rule_id The ID of the Rules entry.
  # @param [Hash] opts the optional parameters
  # @return [GenericResponse]
  describe "delete_rule test" do
    it "should work" do
      # assertion here. ref: https://crystal-lang.org/reference/guides/testing.html
    end
  end

  # unit tests for delist_block
  # Removes an email address from the blocked list
  # Removes an email address from the various block lists. 
  # @param email_address 
  # @param [Hash] opts the optional parameters
  # @return [GenericResponse]
  describe "delist_block test" do
    it "should work" do
      # assertion here. ref: https://crystal-lang.org/reference/guides/testing.html
    end
  end

  # unit tests for get_mail_blocks
  # displays a list of blocked email addresses
  # @param [Hash] opts the optional parameters
  # @return [MailBlocks]
  describe "get_mail_blocks test" do
    it "should work" do
      # assertion here. ref: https://crystal-lang.org/reference/guides/testing.html
    end
  end

  # unit tests for get_rules
  # Displays a listing of deny email rules.
  # Returns a listing of all the deny block rules you have configured.
  # @param [Hash] opts the optional parameters
  # @return [Array(DenyRuleRecord)]
  describe "get_rules test" do
    it "should work" do
      # assertion here. ref: https://crystal-lang.org/reference/guides/testing.html
    end
  end

end