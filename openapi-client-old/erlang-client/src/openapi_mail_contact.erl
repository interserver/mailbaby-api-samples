-module(openapi_mail_contact).

-export([encode/1]).

-export_type([openapi_mail_contact/0]).

-type openapi_mail_contact() ::
    #{ 'email' := binary(),
       'name' => binary()
     }.

encode(#{ 'email' := Email,
          'name' := Name
        }) ->
    #{ 'email' => Email,
       'name' => Name
     }.
