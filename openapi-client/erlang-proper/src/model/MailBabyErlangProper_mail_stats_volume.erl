-module(MailBabyErlangProper_mail_stats_volume).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_mail_stats_volume/0]).

-export([MailBabyErlangProper_mail_stats_volume/1]).

-export_type([MailBabyErlangProper_mail_stats_volume/0]).

-type MailBabyErlangProper_mail_stats_volume() ::
  [ {'to', map() }
  | {'from', map() }
  | {'ip', map() }
  ].


MailBabyErlangProper_mail_stats_volume() ->
    MailBabyErlangProper_mail_stats_volume([]).

MailBabyErlangProper_mail_stats_volume(Fields) ->
  Default = [ {'to', map() }
            , {'from', map() }
            , {'ip', map() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

