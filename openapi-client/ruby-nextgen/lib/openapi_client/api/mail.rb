# frozen_string_literal: true

module OpenapiClient
  module Api
    class Mail
      def initialize(connection)
        @connection = connection
      end

      def advsend(subject:, body:, from:, to:, replyto: nil, cc: nil, bcc: nil, attachments: nil, id: nil)
        raise ArgumentError, 'subject is required' if subject.nil?
        raise ArgumentError, 'body is required' if body.nil?
        raise ArgumentError, 'from is required' if from.nil?
        raise ArgumentError, 'to is required' if to.nil?

        @connection.call(
          :POST,
          '/mail/advsend',
          type: OpenapiClient::Models::GenericResponse,
          auth: ['apiKeyAuth'],
          form: { 'subject' => subject, 'body' => body, 'from' => from, 'to' => to, 'replyto' => replyto, 'cc' => cc, 'bcc' => bcc, 'attachments' => attachments, 'id' => id }
        )
      end

      def blocks
        @connection.call(
          :GET,
          '/mail/blocks',
          type: OpenapiClient::Models::MailBlocks,
          auth: ['apiKeyAuth']
        )
      end

      def blocks_delete(email_address_param:)
        raise ArgumentError, 'email_address_param is required' if email_address_param.nil?

        @connection.call(
          :POST,
          '/mail/blocks/delete',
          type: OpenapiClient::Models::GenericResponse,
          auth: ['apiKeyAuth'],
          body: email_address_param
        )
      end

      def get(id:)
        raise ArgumentError, 'id is required' if id.nil?

        @connection.call(
          :GET,
          '/mail/{id}'
            .gsub('{id}', ERB::Util.url_encode(id.to_s)),
          type: OpenapiClient::Models::MailOrderDetail,
          auth: ['apiKeyAuth']
        )
      end

      def list
        @connection.call(
          :GET,
          '/mail',
          type: [OpenapiClient::Models::MailOrder],
          auth: ['apiKeyAuth']
        )
      end

      def log(id: nil, origin: nil, mx: nil, from: nil, to: nil, subject: nil, mailid: nil, message_id: nil, replyto: nil, headerfrom: nil, delivered: nil, skip: nil, limit: nil, start_date: nil, end_date: nil, sort: nil, dir: nil, groupby: nil)
        @connection.call(
          :GET,
          '/mail/log',
          type: OpenapiClient::Models::MailLog,
          auth: ['apiKeyAuth'],
          query: { 'id' => id, 'origin' => origin, 'mx' => mx, 'from' => from, 'to' => to, 'subject' => subject, 'mailid' => mailid, 'messageId' => message_id, 'replyto' => replyto, 'headerfrom' => headerfrom, 'delivered' => delivered, 'skip' => skip, 'limit' => limit, 'startDate' => start_date, 'endDate' => end_date, 'sort' => sort, 'dir' => dir, 'groupby' => groupby }
        )
      end

      def rawsend(send_mail_raw:)
        raise ArgumentError, 'send_mail_raw is required' if send_mail_raw.nil?

        @connection.call(
          :POST,
          '/mail/rawsend',
          type: OpenapiClient::Models::GenericResponse,
          auth: ['apiKeyAuth'],
          body: send_mail_raw
        )
      end

      def send(to:, from:, subject:, body:, id: nil)
        raise ArgumentError, 'to is required' if to.nil?
        raise ArgumentError, 'from is required' if from.nil?
        raise ArgumentError, 'subject is required' if subject.nil?
        raise ArgumentError, 'body is required' if body.nil?

        @connection.call(
          :POST,
          '/mail/send',
          type: OpenapiClient::Models::GenericResponse,
          auth: ['apiKeyAuth'],
          form: { 'to' => to, 'from' => from, 'subject' => subject, 'body' => body, 'id' => id }
        )
      end

      def stats(time: nil)
        @connection.call(
          :GET,
          '/mail/stats',
          type: OpenapiClient::Models::MailStatsType,
          auth: ['apiKeyAuth'],
          query: { 'time' => time }
        )
      end
    end
  end
end
