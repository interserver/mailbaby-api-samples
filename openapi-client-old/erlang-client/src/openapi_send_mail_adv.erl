-module(openapi_send_mail_adv).

-export([encode/1]).

-export_type([openapi_send_mail_adv/0]).

-type openapi_send_mail_adv() ::
    #{ 'subject' := binary(),
       'body' := binary(),
       'from' := list(),
       'to' := list(),
       'id' := integer(),
       'replyto' => list(),
       'cc' => list(),
       'bcc' => list(),
       'attachments' => list()
     }.

encode(#{ 'subject' := Subject,
          'body' := Body,
          'from' := From,
          'to' := To,
          'id' := Id,
          'replyto' := Replyto,
          'cc' := Cc,
          'bcc' := Bcc,
          'attachments' := Attachments
        }) ->
    #{ 'subject' => Subject,
       'body' => Body,
       'from' => From,
       'to' => To,
       'id' => Id,
       'replyto' => Replyto,
       'cc' => Cc,
       'bcc' => Bcc,
       'attachments' => Attachments
     }.
