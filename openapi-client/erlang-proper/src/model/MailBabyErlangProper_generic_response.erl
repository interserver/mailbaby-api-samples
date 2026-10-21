-module(MailBabyErlangProper_generic_response).

-include("MailBabyErlangProper.hrl").

-export([MailBabyErlangProper_generic_response/0]).

-export([MailBabyErlangProper_generic_response/1]).

-export_type([MailBabyErlangProper_generic_response/0]).

-type MailBabyErlangProper_generic_response() ::
  [ {'status', binary() }
  | {'text', binary() }
  ].


MailBabyErlangProper_generic_response() ->
    MailBabyErlangProper_generic_response([]).

MailBabyErlangProper_generic_response(Fields) ->
  Default = [ {'status', binary() }
            , {'text', binary() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

