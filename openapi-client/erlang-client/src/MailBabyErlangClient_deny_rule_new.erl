-module(MailBabyErlangClient_deny_rule_new).

-export([encode/1]).

-export_type([MailBabyErlangClient_deny_rule_new/0]).

-type MailBabyErlangClient_deny_rule_new() ::
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
