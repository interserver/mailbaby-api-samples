-module(MailBabyErlangClient_deny_rule_record).

-export([encode/1]).

-export_type([MailBabyErlangClient_deny_rule_record/0]).

-type MailBabyErlangClient_deny_rule_record() ::
    #{ 'type' := binary(),
       'data' := binary(),
       'id' := binary(),
       'created' := MailBabyErlangClient_date_time:MailBabyErlangClient_date_time(),
       'user' => binary()
     }.

encode(#{ 'type' := Type,
          'data' := Data,
          'id' := Id,
          'created' := Created,
          'user' := User
        }) ->
    #{ 'type' => Type,
       'data' => Data,
       'id' => Id,
       'created' => Created,
       'user' => User
     }.
