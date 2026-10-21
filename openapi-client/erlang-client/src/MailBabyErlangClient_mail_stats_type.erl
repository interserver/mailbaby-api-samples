-module(MailBabyErlangClient_mail_stats_type).

-export([encode/1]).

-export_type([MailBabyErlangClient_mail_stats_type/0]).

-type MailBabyErlangClient_mail_stats_type() ::
    #{ 'time' => binary(),
       'usage' => integer(),
       'currency' => binary(),
       'cost' => float(),
       'received' => integer(),
       'sent' => integer(),
       'volume' => MailBabyErlangClient_mail_stats_volume:MailBabyErlangClient_mail_stats_volume()
     }.

encode(#{ 'time' := Time,
          'usage' := Usage,
          'currency' := Currency,
          'cost' := Cost,
          'received' := Received,
          'sent' := Sent,
          'volume' := Volume
        }) ->
    #{ 'time' => Time,
       'usage' => Usage,
       'currency' => Currency,
       'cost' => Cost,
       'received' => Received,
       'sent' => Sent,
       'volume' => Volume
     }.
