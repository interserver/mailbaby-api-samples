-module(openapi_inline_response_401).

-export([encode/1]).

-export_type([openapi_inline_response_401/0]).

-type openapi_inline_response_401() ::
    #{ 'code' := binary(),
       'message' := binary()
     }.

encode(#{ 'code' := Code,
          'message' := Message
        }) ->
    #{ 'code' => Code,
       'message' => Message
     }.
