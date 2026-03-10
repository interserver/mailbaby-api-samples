-module(openapi_mail_stats_type_volume).

-export([encode/1]).

-export_type([openapi_mail_stats_type_volume/0]).

-type openapi_mail_stats_type_volume() ::
    #{ 'to' => maps:map(),
       'from' => maps:map(),
       'ip' => maps:map()
     }.

encode(#{ 'to' := To,
          'from' := From,
          'ip' := Ip
        }) ->
    #{ 'to' => To,
       'from' => From,
       'ip' => Ip
     }.
