-module(openapi_send_mail_raw).

-export([encode/1]).

-export_type([openapi_send_mail_raw/0]).

-type openapi_send_mail_raw() ::
    #{ 'raw_email' := binary(),
       'id' => integer()
     }.

encode(#{ 'raw_email' := RawEmail,
          'id' := Id
        }) ->
    #{ 'raw_email' => RawEmail,
       'id' => Id
     }.
