-module(openapi_body).

-export([encode/1]).

-export_type([openapi_body/0]).

-type openapi_body() ::
    #{ 'to' => binary(),
       'from' => binary(),
       'subject' => binary(),
       'body' => binary()
     }.

encode(#{ 'to' := To,
          'from' := From,
          'subject' := Subject,
          'body' := Body
        }) ->
    #{ 'to' => To,
       'from' => From,
       'subject' => Subject,
       'body' => Body
     }.
