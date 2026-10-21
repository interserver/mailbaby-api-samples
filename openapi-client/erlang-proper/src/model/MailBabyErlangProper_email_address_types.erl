-module(MailBabyErlangProper_email_address_types).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_email_address_types/0]).

-export([MailBabyErlangProper_email_address_types/1]).

-export_type([MailBabyErlangProper_email_address_types/0]).

-type MailBabyErlangProper_email_address_types() ::
  [ {'email', binary() }
  | {'name', binary() }
  ].


MailBabyErlangProper_email_address_types() ->
    MailBabyErlangProper_email_address_types([]).

MailBabyErlangProper_email_address_types(Fields) ->
  Default = [ {'email', binary() }
            , {'name', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

