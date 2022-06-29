-module(openapi_statem).

-behaviour(proper_statem).

-include("openapi.hrl").
-include_lib("proper/include/proper_common.hrl").
-include_lib("stdlib/include/assert.hrl").

-compile(export_all).
-compile(nowarn_export_all).

-include("openapi_statem.hrl").

%%==============================================================================
%% The statem's property
%%==============================================================================

prop_main() ->
  setup(),
  ?FORALL( Cmds
         , proper_statem:commands(?MODULE)
         , begin
             cleanup(),
             { History
             , State
             , Result
             } = proper_statem:run_commands(?MODULE, Cmds),
             ?WHENFAIL(
                io:format("History: ~p\nState: ~p\nResult: ~p\nCmds: ~p\n",
                          [ History
                          , State
                          , Result
                          , proper_statem:command_names(Cmds)
                          ]),
                proper:aggregate( proper_statem:command_names(Cmds)
                                , Result =:= ok
                                )
               )
           end
         ).

%%==============================================================================
%% Setup
%%==============================================================================

setup() -> ok.

%%==============================================================================
%% Cleanup
%%==============================================================================

cleanup() -> ok.

%%==============================================================================
%% Initial State
%%==============================================================================

initial_state() -> #{}.

%%==============================================================================
%% get_mail_orders
%%==============================================================================

get_mail_orders() ->
  openapi_api:get_mail_orders().

get_mail_orders_args(_S) ->
  [].

%%==============================================================================
%% ping_server
%%==============================================================================

ping_server() ->
  openapi_api:ping_server().

ping_server_args(_S) ->
  [].

%%==============================================================================
%% send_adv_mail
%%==============================================================================

send_adv_mail(OpenapiSendMailAdv) ->
  openapi_api:send_adv_mail(OpenapiSendMailAdv).

send_adv_mail_args(_S) ->
  [openapi_send_mail_adv:openapi_send_mail_adv()].

%%==============================================================================
%% send_mail
%%==============================================================================

send_mail(To, From, Subject, Body) ->
  openapi_api:send_mail(To, From, Subject, Body).

send_mail_args(_S) ->
  [binary(), binary(), binary(), binary()].

%%==============================================================================
%% view_mail_log
%%==============================================================================

view_mail_log() ->
  openapi_api:view_mail_log().

view_mail_log_args(_S) ->
  [].

