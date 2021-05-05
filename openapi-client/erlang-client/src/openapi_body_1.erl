-module(openapi_body_1).

-export([encode/1]).

-export_type([openapi_body_1/0]).

-type openapi_body_1() ::
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
