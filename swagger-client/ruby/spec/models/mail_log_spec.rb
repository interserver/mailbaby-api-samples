=begin
#Mail Baby API

#This is an API defintion for accesssing the Mail.Baby mail service.

OpenAPI spec version: 1.0.0
Contact: detain@interserver.net
Generated by: https://github.com/swagger-api/swagger-codegen.git
Swagger Codegen version: 3.0.25
=end

require 'spec_helper'
require 'json'
require 'date'

# Unit tests for SwaggerClient::MailLog
# Automatically generated by swagger-codegen (github.com/swagger-api/swagger-codegen)
# Please update as you see appropriate
describe 'MailLog' do
  before do
    # run before each test
    @instance = SwaggerClient::MailLog.new
  end

  after do
    # run after each test
  end

  describe 'test an instance of MailLog' do
    it 'should create an instance of MailLog' do
      expect(@instance).to be_instance_of(SwaggerClient::MailLog)
    end
  end
  describe 'test attribute "id"' do
    it 'should work' do
      # assertion here. ref: https://www.relishapp.com/rspec/rspec-expectations/docs/built-in-matchers
    end
  end

end