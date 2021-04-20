-module(openapi_send_mail).

-export([encode/1]).

-export_type([openapi_send_mail/0]).

-type openapi_send_mail() ::
    #{ 'id' := integer(),
       'from' := openapi_mail_contact:openapi_mail_contact(),
       'to' := list(),
       'subject' := binary(),
       'body' := binary(),
       'replyto' => list(),
       'cc' => list(),
       'bcc' => list(),
       'attachments' => list()
     }.

encode(#{ 'id' := Id,
          'from' := From,
          'to' := To,
          'subject' := Subject,
          'body' := Body,
          'replyto' := Replyto,
          'cc' := Cc,
          'bcc' := Bcc,
          'attachments' := Attachments
        }) ->
    #{ 'id' => Id,
       'from' => From,
       'to' => To,
       'subject' => Subject,
       'body' => Body,
       'replyto' => Replyto,
       'cc' => Cc,
       'bcc' => Bcc,
       'attachments' => Attachments
     }.
