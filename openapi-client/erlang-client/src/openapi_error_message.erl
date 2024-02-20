-module(openapi_error_message).

-export([encode/1]).

-export_type([openapi_error_message/0]).

-type openapi_error_message() ::
    #{ 'code' := integer(),
       'message' := binary()
     }.

encode(#{ 'code' := Code,
          'message' := Message
        }) ->
    #{ 'code' => Code,
       'message' => Message
     }.
