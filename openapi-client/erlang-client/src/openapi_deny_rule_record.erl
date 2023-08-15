-module(openapi_deny_rule_record).

-export([encode/1]).

-export_type([openapi_deny_rule_record/0]).

-type openapi_deny_rule_record() ::
    #{ 'id' := integer(),
       'created' := openapi_date_time:openapi_date_time(),
       'user' => binary(),
       'type' := binary(),
       'data' := binary()
     }.

encode(#{ 'id' := Id,
          'created' := Created,
          'user' := User,
          'type' := Type,
          'data' := Data
        }) ->
    #{ 'id' => Id,
       'created' => Created,
       'user' => User,
       'type' => Type,
       'data' => Data
     }.
