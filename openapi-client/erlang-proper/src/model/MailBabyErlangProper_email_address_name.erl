-module(MailBabyErlangProper_email_address_name).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_email_address_name/0]).

-export([MailBabyErlangProper_email_address_name/1]).

-export_type([MailBabyErlangProper_email_address_name/0]).

-type MailBabyErlangProper_email_address_name() ::
  [ {'email', binary() }
  | {'name', binary() }
  ].


MailBabyErlangProper_email_address_name() ->
    MailBabyErlangProper_email_address_name([]).

MailBabyErlangProper_email_address_name(Fields) ->
  Default = [ {'email', binary() }
            , {'name', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

