-module(openapi_email_address_names).

-include("openapi.hrl").

-export([openapi_email_address_names/0]).

-export_type([openapi_email_address_names/0]).

-type openapi_email_address_names() ::
  list(openapi_email_address_name:openapi_email_address_name()).

openapi_email_address_names() ->
  list(openapi_email_address_name:openapi_email_address_name()).

