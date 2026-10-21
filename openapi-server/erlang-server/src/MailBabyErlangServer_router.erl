-module(MailBabyErlangServer_router).

-export([get_paths/1]).

-type method() :: binary().
-type operations() :: #{method() => MailBabyErlangServer_api:operation_id()}.
-type init_opts()  :: {operations(), module()}.

-export_type([init_opts/0]).

-spec get_paths(LogicHandler :: module()) -> cowboy_router:routes().
get_paths(LogicHandler) ->
    PreparedPaths = maps:fold(
                      fun(Path, #{operations := Operations, handler := Handler}, Acc) ->
                              [{Path, Handler, Operations} | Acc]
                      end, [], group_paths()
                     ),
    [{'_', [{P, H, {O, LogicHandler}} || {P, H, O} <- PreparedPaths]}].

group_paths() ->
    maps:fold(
      fun(OperationID, #{servers := Servers, base_path := BasePath, path := Path,
                         method := Method, handler := Handler}, Acc) ->
              FullPaths = build_full_paths(Servers, BasePath, Path),
              merge_paths(FullPaths, OperationID, Method, Handler, Acc)
      end, #{}, get_operations()).

build_full_paths([], BasePath, Path) ->
    [lists:append([BasePath, Path])];
build_full_paths(Servers, _BasePath, Path) ->
    [lists:append([Server, Path]) || Server <- Servers ].

merge_paths(FullPaths, OperationID, Method, Handler, Acc) ->
    lists:foldl(
      fun(Path, Acc0) ->
              case maps:find(Path, Acc0) of
                  {ok, PathInfo0 = #{operations := Operations0}} ->
                      Operations = Operations0#{Method => OperationID},
                      PathInfo = PathInfo0#{operations => Operations},
                      Acc0#{Path => PathInfo};
                  error ->
                      Operations = #{Method => OperationID},
                      PathInfo = #{handler => Handler, operations => Operations},
                      Acc0#{Path => PathInfo}
              end
      end, Acc, FullPaths).

get_operations() ->
    #{ 
       'addRule' => #{
            servers => [],
            base_path => "",
            path => "/mail/rules",
            method => <<"POST">>,
            handler => 'MailBabyErlangServer_blocking_handler'
        },
       'deleteRule' => #{
            servers => [],
            base_path => "",
            path => "/mail/rules/:ruleId",
            method => <<"DELETE">>,
            handler => 'MailBabyErlangServer_blocking_handler'
        },
       'delistBlock' => #{
            servers => [],
            base_path => "",
            path => "/mail/blocks/delete",
            method => <<"POST">>,
            handler => 'MailBabyErlangServer_blocking_handler'
        },
       'getMailBlocks' => #{
            servers => [],
            base_path => "",
            path => "/mail/blocks",
            method => <<"GET">>,
            handler => 'MailBabyErlangServer_blocking_handler'
        },
       'getRules' => #{
            servers => [],
            base_path => "",
            path => "/mail/rules",
            method => <<"GET">>,
            handler => 'MailBabyErlangServer_blocking_handler'
        },
       'getStats' => #{
            servers => [],
            base_path => "",
            path => "/mail/stats",
            method => <<"GET">>,
            handler => 'MailBabyErlangServer_history_handler'
        },
       'viewMailLog' => #{
            servers => [],
            base_path => "",
            path => "/mail/log",
            method => <<"GET">>,
            handler => 'MailBabyErlangServer_history_handler'
        },
       'rawMail' => #{
            servers => [],
            base_path => "",
            path => "/mail/rawsend",
            method => <<"POST">>,
            handler => 'MailBabyErlangServer_sending_handler'
        },
       'sendAdvMail' => #{
            servers => [],
            base_path => "",
            path => "/mail/advsend",
            method => <<"POST">>,
            handler => 'MailBabyErlangServer_sending_handler'
        },
       'sendMail' => #{
            servers => [],
            base_path => "",
            path => "/mail/send",
            method => <<"POST">>,
            handler => 'MailBabyErlangServer_sending_handler'
        },
       'getMailOrderById' => #{
            servers => [],
            base_path => "",
            path => "/mail/:id",
            method => <<"GET">>,
            handler => 'MailBabyErlangServer_services_handler'
        },
       'getMailOrders' => #{
            servers => [],
            base_path => "",
            path => "/mail",
            method => <<"GET">>,
            handler => 'MailBabyErlangServer_services_handler'
        },
       'pingServer' => #{
            servers => [],
            base_path => "",
            path => "/ping",
            method => <<"GET">>,
            handler => 'MailBabyErlangServer_status_handler'
        }
    }.
