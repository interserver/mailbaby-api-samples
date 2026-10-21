-module(MailBabyErlangProper_date_or_timestamp).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_date_or_timestamp/0]).

-export([MailBabyErlangProper_date_or_timestamp/1]).

-export_type([MailBabyErlangProper_date_or_timestamp/0]).

-type MailBabyErlangProper_date_or_timestamp() ::
  [ 
  ].


MailBabyErlangProper_date_or_timestamp() ->
    MailBabyErlangProper_date_or_timestamp([]).

MailBabyErlangProper_date_or_timestamp(Fields) ->
  Default = [ 
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

