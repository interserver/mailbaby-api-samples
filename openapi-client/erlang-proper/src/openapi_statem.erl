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
%% get_mail_by_id
%%==============================================================================

get_mail_by_id(Id) ->
  openapi_api:get_mail_by_id(Id).

get_mail_by_id_args(_S) ->
  [integer()].

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
%% place_mail_order
%%==============================================================================

place_mail_order() ->
  openapi_api:place_mail_order().

place_mail_order_args(_S) ->
  [].

%%==============================================================================
%% send_mail_by_id
%%==============================================================================

send_mail_by_id(Id) ->
  openapi_api:send_mail_by_id(Id).

send_mail_by_id_args(_S) ->
  [integer()].

%%==============================================================================
%% validate_mail_order
%%==============================================================================

validate_mail_order() ->
  openapi_api:validate_mail_order().

validate_mail_order_args(_S) ->
  [].

%%==============================================================================
%% view_mail_log_by_id
%%==============================================================================

view_mail_log_by_id(Id) ->
  openapi_api:view_mail_log_by_id(Id).

view_mail_log_by_id_args(_S) ->
  [integer()].
