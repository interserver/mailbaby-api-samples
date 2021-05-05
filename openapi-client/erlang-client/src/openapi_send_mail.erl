-module(openapi_send_mail).

-export([encode/1]).

-export_type([openapi_send_mail/0]).

-type openapi_send_mail() ::
    #{ 'subject' := binary(),
       'body' := binary(),
       'from' := openapi_mail_contact:openapi_mail_contact(),
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
