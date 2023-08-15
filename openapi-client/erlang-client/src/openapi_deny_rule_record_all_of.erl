-module(openapi_deny_rule_record_all_of).

-export([encode/1]).

-export_type([openapi_deny_rule_record_all_of/0]).

-type openapi_deny_rule_record_all_of() ::
    #{ 'id' := integer(),
       'created' := openapi_date_time:openapi_date_time()
     }.

encode(#{ 'id' := Id,
          'created' := Created
        }) ->
    #{ 'id' => Id,
       'created' => Created
     }.
