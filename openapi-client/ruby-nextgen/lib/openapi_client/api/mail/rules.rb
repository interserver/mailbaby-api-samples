# frozen_string_literal: true

module OpenapiClient
  module Api
    class Mail::Rules
      def initialize(connection)
        @connection = connection
      end

      def create(type:, data:, user: nil)
        raise ArgumentError, 'type is required' if type.nil?
        raise ArgumentError, 'data is required' if data.nil?

        @connection.call(
          :POST,
          '/mail/rules',
          type: OpenapiClient::Models::GenericResponse,
          auth: ['apiKeyAuth'],
          form: { 'user' => user, 'type' => type, 'data' => data }
        )
      end

      def delete(rule_id:)
        raise ArgumentError, 'rule_id is required' if rule_id.nil?

        @connection.call(
          :DELETE,
          '/mail/rules/{ruleId}'
            .gsub('{ruleId}', ERB::Util.url_encode(rule_id.to_s)),
          type: OpenapiClient::Models::GenericResponse,
          auth: ['apiKeyAuth']
        )
      end

      def list
        @connection.call(
          :GET,
          '/mail/rules',
          type: [OpenapiClient::Models::DenyRuleRecord],
          auth: ['apiKeyAuth']
        )
      end
    end
  end
end
