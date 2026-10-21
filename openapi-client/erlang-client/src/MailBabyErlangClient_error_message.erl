-module(MailBabyErlangClient_error_message).

-export([encode/1]).

-export_type([MailBabyErlangClient_error_message/0]).

-type MailBabyErlangClient_error_message() ::
    #{ 'code' := integer(),
       'message' := binary()
     }.

encode(#{ 'code' := Code,
          'message' := Message
        }) ->
    #{ 'code' => Code,
       'message' => Message
     }.
