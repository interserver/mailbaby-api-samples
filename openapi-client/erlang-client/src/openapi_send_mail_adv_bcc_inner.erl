-module(openapi_send_mail_adv_bcc_inner).

-export([encode/1]).

-export_type([openapi_send_mail_adv_bcc_inner/0]).

-type openapi_send_mail_adv_bcc_inner() ::
    #{ 'email' := binary(),
       'name' => binary()
     }.

encode(#{ 'email' := Email,
          'name' := Name
        }) ->
    #{ 'email' => Email,
       'name' => Name
     }.
