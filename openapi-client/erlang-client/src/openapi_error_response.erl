-module(openapi_error_response).

-export([encode/1]).

-export_type([openapi_error_response/0]).

-type openapi_error_response() ::
    #{ 'code' := binary(),
       'message' := binary()
     }.

encode(#{ 'code' := Code,
          'message' := Message
        }) ->
    #{ 'code' => Code,
       'message' => Message
     }.
