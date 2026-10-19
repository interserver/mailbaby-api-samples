-module(openapi_deny_rule_new).

-export([encode/1]).

-export_type([openapi_deny_rule_new/0]).

-type openapi_deny_rule_new() ::
    #{ 'type' := binary(),
       'data' := binary(),
       'user' => binary()
     }.

encode(#{ 'type' := Type,
          'data' := Data,
          'user' := User
        }) ->
    #{ 'type' => Type,
       'data' => Data,
       'user' => User
     }.
