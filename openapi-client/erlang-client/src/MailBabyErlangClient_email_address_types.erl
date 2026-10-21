-module(MailBabyErlangClient_email_address_types).

-export([encode/1]).

-export_type([MailBabyErlangClient_email_address_types/0]).

-type MailBabyErlangClient_email_address_types() ::
    #{ 'email' := binary(),
       'name' => binary()
     }.

encode(#{ 'email' := Email,
          'name' := Name
        }) ->
    #{ 'email' => Email,
       'name' => Name
     }.
