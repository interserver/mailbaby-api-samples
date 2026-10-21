-module(MailBabyErlangProper_email_address_param).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_email_address_param/0]).

-export([MailBabyErlangProper_email_address_param/1]).

-export_type([MailBabyErlangProper_email_address_param/0]).

-type MailBabyErlangProper_email_address_param() ::
  [ {'email', binary() }
  ].


MailBabyErlangProper_email_address_param() ->
    MailBabyErlangProper_email_address_param([]).

MailBabyErlangProper_email_address_param(Fields) ->
  Default = [ {'email', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

