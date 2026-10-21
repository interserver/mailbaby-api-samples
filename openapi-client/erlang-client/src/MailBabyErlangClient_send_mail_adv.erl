-module(MailBabyErlangClient_send_mail_adv).

-export([encode/1]).

-export_type([MailBabyErlangClient_send_mail_adv/0]).

-type MailBabyErlangClient_send_mail_adv() ::
    #{ 'subject' := binary(),
       'body' := binary(),
       'from' := MailBabyErlangClient_email_address_types:MailBabyErlangClient_email_address_types(),
       'to' := MailBabyErlangClient_email_addresses_types:MailBabyErlangClient_email_addresses_types(),
       'replyto' => MailBabyErlangClient_email_addresses_types:MailBabyErlangClient_email_addresses_types(),
       'cc' => MailBabyErlangClient_email_addresses_types:MailBabyErlangClient_email_addresses_types(),
       'bcc' => MailBabyErlangClient_email_addresses_types:MailBabyErlangClient_email_addresses_types(),
       'attachments' => list(),
       'id' => integer()
     }.

encode(#{ 'subject' := Subject,
          'body' := Body,
          'from' := From,
          'to' := To,
          'replyto' := Replyto,
          'cc' := Cc,
          'bcc' := Bcc,
          'attachments' := Attachments,
          'id' := Id
        }) ->
    #{ 'subject' => Subject,
       'body' => Body,
       'from' => From,
       'to' => To,
       'replyto' => Replyto,
       'cc' => Cc,
       'bcc' => Bcc,
       'attachments' => Attachments,
       'id' => Id
     }.
