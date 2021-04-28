-module(openapi_mail_log).

-export([encode/1]).

-export_type([openapi_mail_log/0]).

-type openapi_mail_log() ::
    #{ 'id' => integer()
     }.

encode(#{ 'id' := Id
        }) ->
    #{ 'id' => Id
     }.
