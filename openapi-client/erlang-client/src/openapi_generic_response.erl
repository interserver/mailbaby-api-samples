-module(openapi_generic_response).

-export([encode/1]).

-export_type([openapi_generic_response/0]).

-type openapi_generic_response() ::
    #{ 'status' => binary(),
       'status_text' => binary()
     }.

encode(#{ 'status' := Status,
          'status_text' := StatusText
        }) ->
    #{ 'status' => Status,
       'status_text' => StatusText
     }.
