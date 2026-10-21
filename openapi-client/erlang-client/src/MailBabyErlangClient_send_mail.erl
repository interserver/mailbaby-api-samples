-module(MailBabyErlangClient_send_mail).

-export([encode/1]).

-export_type([MailBabyErlangClient_send_mail/0]).

-type MailBabyErlangClient_send_mail() ::
    #{ 'to' := MailBabyErlangClient_send_mail_to:MailBabyErlangClient_send_mail_to(),
       'from' := binary(),
       'subject' := binary(),
       'body' := binary(),
       'id' => integer()
     }.

encode(#{ 'to' := To,
          'from' := From,
          'subject' := Subject,
          'body' := Body,
          'id' := Id
        }) ->
    #{ 'to' => To,
       'from' => From,
       'subject' => Subject,
       'body' => Body,
       'id' => Id
     }.
