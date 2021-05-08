-module(openapi_send_mail_adv_from).

-export([encode/1]).

-export_type([openapi_send_mail_adv_from/0]).

-type openapi_send_mail_adv_from() ::
    #{ 'email' := binary(),
       'name' => binary()
     }.

encode(#{ 'email' := Email,
          'name' := Name
        }) ->
    #{ 'email' => Email,
       'name' => Name
     }.
