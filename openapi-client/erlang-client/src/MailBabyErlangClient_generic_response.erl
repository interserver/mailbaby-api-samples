-module(MailBabyErlangClient_generic_response).

-export([encode/1]).

-export_type([MailBabyErlangClient_generic_response/0]).

-type MailBabyErlangClient_generic_response() ::
    #{ 'status' := binary(),
       'text' := binary()
     }.

encode(#{ 'status' := Status,
          'text' := Text
        }) ->
    #{ 'status' => Status,
       'text' => Text
     }.
