-module(openapi_mail_log_entry).

-include("openapi.hrl").

-export([openapi_mail_log_entry/0]).

-export([openapi_mail_log_entry/1]).

-export_type([openapi_mail_log_entry/0]).

-type openapi_mail_log_entry() ::
  [ {'_id', integer() }
  | {'id', binary() }
  | {'from', binary() }
  | {'to', binary() }
  | {'subject', binary() }
  | {'messageId', binary() }
  | {'created', binary() }
  | {'time', integer() }
  | {'user', binary() }
  | {'transtype', binary() }
  | {'transhost', binary() }
  | {'originhost', binary() }
  | {'origin', binary() }
  | {'interface', binary() }
  | {'date', binary() }
  | {'sendingZone', binary() }
  | {'bodySize', integer() }
  | {'sourceMd5', binary() }
  | {'seq', integer() }
  | {'domain', binary() }
  | {'recipient', binary() }
  | {'locked', integer() }
  | {'lockTime', integer() }
  | {'assigned', binary() }
  | {'queued', binary() }
  | {'_lock', binary() }
  | {'logger', binary() }
  | {'mxPort', integer() }
  | {'connectionKey', binary() }
  | {'mxHostname', binary() }
  | {'sentBodyHash', binary() }
  | {'sentBodySize', integer() }
  | {'md5Match', integer() }
  ].


openapi_mail_log_entry() ->
    openapi_mail_log_entry([]).

openapi_mail_log_entry(Fields) ->
  Default = [ {'_id', integer() }
            , {'id', binary() }
            , {'from', binary() }
            , {'to', binary() }
            , {'subject', binary() }
            , {'messageId', binary() }
            , {'created', binary() }
            , {'time', integer() }
            , {'user', binary() }
            , {'transtype', binary() }
            , {'transhost', binary() }
            , {'originhost', binary() }
            , {'origin', binary() }
            , {'interface', binary() }
            , {'date', binary() }
            , {'sendingZone', binary() }
            , {'bodySize', integer() }
            , {'sourceMd5', binary() }
            , {'seq', integer() }
            , {'domain', binary() }
            , {'recipient', binary() }
            , {'locked', integer() }
            , {'lockTime', integer() }
            , {'assigned', binary() }
            , {'queued', binary() }
            , {'_lock', binary() }
            , {'logger', binary() }
            , {'mxPort', integer() }
            , {'connectionKey', binary() }
            , {'mxHostname', binary() }
            , {'sentBodyHash', binary() }
            , {'sentBodySize', integer() }
            , {'md5Match', integer() }
            ],
  lists:ukeymerge(1, lists:sort(Fields), lists:sort(Default)).

