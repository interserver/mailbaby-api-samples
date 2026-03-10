-module(openapi_email_address_param).

-export([encode/1]).

-export_type([openapi_email_address_param/0]).

-type openapi_email_address_param() ::
    #{ 'email' := binary()
     }.

encode(#{ 'email' := Email
        }) ->
    #{ 'email' => Email
     }.
