-module(openapi_deny_rule_record).

-export([encode/1]).

-export_type([openapi_deny_rule_record/0]).

-type openapi_deny_rule_record() ::
    #{ 'user' => binary(),
       'type' := binary(),
       'data' := binary(),
       'id' := integer(),
       'created' := openapi_date_time:openapi_date_time()
     }.

encode(#{ 'user' := User,
          'type' := Type,
          'data' := Data,
          'id' := Id,
          'created' := Created
        }) ->
    #{ 'user' => User,
       'type' => Type,
       'data' => Data,
       'id' => Id,
       'created' => Created
     }.
