-module(openapi_raw_mail).

-export([encode/1]).

-export_type([openapi_raw_mail/0]).

-type openapi_raw_mail() ::
    #{ 'raw_email' := binary()
     }.

encode(#{ 'raw_email' := RawEmail
        }) ->
    #{ 'raw_email' => RawEmail
     }.
