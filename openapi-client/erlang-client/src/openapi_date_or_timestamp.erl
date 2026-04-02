-module(openapi_date_or_timestamp).

-export([encode/1]).

-export_type([openapi_date_or_timestamp/0]).

-type openapi_date_or_timestamp() ::
    #{ 
     }.

encode(#{ 
        }) ->
    #{ 
     }.
