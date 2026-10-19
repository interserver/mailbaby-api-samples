# frozen_string_literal: true

module OpenapiClient
  class Client
    attr_reader :configuration, :connection

    def initialize(base_url: nil, **options, &block)
      @configuration = Configuration.new(base_url: base_url, **options, &block)
      @connection = Connection.new(@configuration)
    end

    def mail
      @mail ||= OpenapiClient::Api::Mail.new(@connection)
    end

    def ping
      @ping ||= OpenapiClient::Api::Ping.new(@connection)
    end
  end
end
