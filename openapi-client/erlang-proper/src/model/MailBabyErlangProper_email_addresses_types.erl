-module(MailBabyErlangProper_email_addresses_types).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_email_addresses_types/0]).

-export([MailBabyErlangProper_email_addresses_types/1]).

-export_type([MailBabyErlangProper_email_addresses_types/0]).

-type MailBabyErlangProper_email_addresses_types() ::
  [ 
  ].


MailBabyErlangProper_email_addresses_types() ->
    MailBabyErlangProper_email_addresses_types([]).

MailBabyErlangProper_email_addresses_types(Fields) ->
  Default = [ 
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

