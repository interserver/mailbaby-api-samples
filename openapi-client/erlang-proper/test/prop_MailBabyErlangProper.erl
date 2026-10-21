-module(prop_MailBabyErlangProper).

-export([prop_test/0]).

prop_test() ->
  {ok, _} = application:ensure_all_started(MailBabyErlangProper),
  MailBabyErlangProper_statem:prop_main().
