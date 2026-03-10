-module(openapi_send_mail).

-export([encode/1]).

-export_type([openapi_send_mail/0]).

-type openapi_send_mail() ::
    #{ 'to' := openapi_send_mail_to:openapi_send_mail_to(),
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
