-module(MailBabyErlangServer_api).
-moduledoc """
This module offers an API for JSON schema validation, using `jesse` under the hood.

If validation is desired, a jesse state can be loaded using `prepare_validator/1`,
and request and response can be validated using `populate_request/3`
and `validate_response/4` respectively.

For example, the user-defined `Module:accept_callback/4` can be implemented as follows:
```
-spec accept_callback(
        Class :: openapi_api:class(),
        OperationID :: openapi_api:operation_id(),
        Req :: cowboy_req:req(),
        Context :: openapi_logic_handler:context()) ->
    {openapi_logic_handler:accept_callback_return(),
     cowboy_req:req(),
     openapi_logic_handler:context()}.
accept_callback(Class, OperationID, Req0, Context0) ->
    ValidatorState = openapi_api:prepare_validator(),
    case openapi_api:populate_request(OperationID, Req0, ValidatorState) of
        {ok, Model, Req1} ->
            Context1 = maps:merge(Context0, Model),
            case do_accept_callback(Class, OperationID, Req1, Context1) of
                {false, Req2, Context2} ->
                    {false, Req2, Context2};
                {{true, Code, Body}, Req2, Context2} ->
                    case validate_response(OperationID, Code, Body, ValidatorState) of
                        ok ->
                            process_response({ok, Code, Body}, Req2, Context2);
                        {error, Reason} ->
                            process_response({error, Reason}, Req2, Context2)
                    end
            end;
        {error, Reason, Req1} ->
            process_response({error, Reason}, Req1, Context0)
    end.
```
""".

-export([prepare_validator/0, prepare_validator/1, prepare_validator/2]).
-export([populate_request/3, validate_response/4]).

-ignore_xref([populate_request/3, validate_response/4]).
-ignore_xref([prepare_validator/0, prepare_validator/1, prepare_validator/2]).

-type class() ::
    'blocking'
    | 'history'
    | 'sending'
    | 'services'
    | 'status'.


-type operation_id() ::
    'addRule' | %% Create a deny rule to block a sender, domain, destination, or prefix
    'deleteRule' | %% Delete a deny rule by its numeric ruleId
    'delistBlock' | %% Delist an email address from the spam-filter block lists
    'getMailBlocks' | %% List addresses currently flagged by spam-filter block lists
    'getRules' | %% List custom deny rules (sender / domain / destination / prefix)
    'getStats' | %% Account usage, cost, and volume statistics for a time window
    'viewMailLog' | %% Query the mail delivery log (filterable, paginated)
    'rawMail' | %% Send a pre-built RFC 822 message verbatim (preserves DKIM)
    'sendAdvMail' | %% Send email with multiple recipients, CC/BCC, attachments, named contacts
    'sendMail' | %% Send a simple email (single recipient, plain or HTML)
    'getMailOrderById' | %% Get one mail order&#39;s full detail including SMTP password
    'getMailOrders' | %% List your provisioned mail orders (sending accounts)
    'pingServer' | %% Health check — verify the API is reachable
    {error, unknown_operation}.

-type request_param() :: atom().

-export_type([class/0, operation_id/0]).

-dialyzer({nowarn_function, [validate_response_body/4]}).

-type rule() ::
    {type, binary} |
    {type, byte} |
    {type, integer} |
    {type, float} |
    {type, boolean} |
    {type, date} |
    {type, datetime} |
    {enum, [atom()]} |
    {max, Max :: number()} |
    {exclusive_max, Max :: number()} |
    {min, Min :: number()} |
    {exclusive_min, Min :: number()} |
    {max_length, MaxLength :: integer()} |
    {min_length, MaxLength :: integer()} |
    {pattern, Pattern :: string()} |
    {schema, object | list, binary()} |
    schema |
    required |
    not_required.

-doc #{equiv => prepare_validator/2}.
-spec prepare_validator() -> jesse_state:state().
prepare_validator() ->
    prepare_validator(<<"http://json-schema.org/draft-06/schema#">>).

-doc #{equiv => prepare_validator/2}.
-spec prepare_validator(binary()) -> jesse_state:state().
prepare_validator(SchemaVer) ->
    prepare_validator(get_openapi_path(), SchemaVer).

-doc """
Loads the JSON schema and the desired validation draft into a `t:jesse_state:state/0`.
""".
-spec prepare_validator(file:name_all(), binary()) -> jesse_state:state().
prepare_validator(OpenApiPath, SchemaVer) ->
    {ok, FileContents} = file:read_file(OpenApiPath),
    R = json:decode(FileContents),
    jesse_state:new(R, [{default_schema_ver, SchemaVer}]).

-doc """
Automatically loads the entire body from the cowboy req
and validates the JSON body against the schema.
""".
-spec populate_request(
        OperationID :: operation_id(),
        Req :: cowboy_req:req(),
        ValidatorState :: jesse_state:state()) ->
    {ok, Model :: #{}, Req :: cowboy_req:req()} |
    {error, Reason :: any(), Req :: cowboy_req:req()}.
populate_request(OperationID, Req, ValidatorState) ->
    Params = request_params(OperationID),
    populate_request_params(OperationID, Params, Req, ValidatorState, #{}).

-doc """
Validates that the provided `Code` and `Body` comply with the `ValidatorState` schema
for the `OperationID` operation.
""".
-spec validate_response(
        OperationID :: operation_id(),
        Code :: 200..599,
        Body :: jesse:json_term(),
        ValidatorState :: jesse_state:state()) ->
    ok | {ok, term()} | [ok | {ok, term()}] | no_return().
validate_response('addRule', 200, Body, ValidatorState) ->
    validate_response_body('GenericResponse', 'GenericResponse', Body, ValidatorState);
validate_response('addRule', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('addRule', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('addRule', 404, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('deleteRule', 200, Body, ValidatorState) ->
    validate_response_body('GenericResponse', 'GenericResponse', Body, ValidatorState);
validate_response('deleteRule', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('deleteRule', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('deleteRule', 404, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('delistBlock', 200, Body, ValidatorState) ->
    validate_response_body('GenericResponse', 'GenericResponse', Body, ValidatorState);
validate_response('delistBlock', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('delistBlock', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('delistBlock', 404, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('getMailBlocks', 200, Body, ValidatorState) ->
    validate_response_body('MailBlocks', 'MailBlocks', Body, ValidatorState);
validate_response('getMailBlocks', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('getRules', 200, Body, ValidatorState) ->
    validate_response_body('list', 'DenyRuleRecord', Body, ValidatorState);
validate_response('getRules', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('getStats', 200, Body, ValidatorState) ->
    validate_response_body('MailStatsType', 'MailStatsType', Body, ValidatorState);
validate_response('getStats', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('viewMailLog', 200, Body, ValidatorState) ->
    validate_response_body('MailLog', 'MailLog', Body, ValidatorState);
validate_response('viewMailLog', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('viewMailLog', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('rawMail', 200, Body, ValidatorState) ->
    validate_response_body('GenericResponse', 'GenericResponse', Body, ValidatorState);
validate_response('rawMail', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('rawMail', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('rawMail', 404, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('sendAdvMail', 200, Body, ValidatorState) ->
    validate_response_body('GenericResponse', 'GenericResponse', Body, ValidatorState);
validate_response('sendAdvMail', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('sendAdvMail', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('sendAdvMail', 404, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('sendMail', 200, Body, ValidatorState) ->
    validate_response_body('GenericResponse', 'GenericResponse', Body, ValidatorState);
validate_response('sendMail', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('sendMail', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('sendMail', 404, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('getMailOrderById', 200, Body, ValidatorState) ->
    validate_response_body('MailOrderDetail', 'MailOrderDetail', Body, ValidatorState);
validate_response('getMailOrderById', 400, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('getMailOrderById', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('getMailOrderById', 404, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('getMailOrders', 200, Body, ValidatorState) ->
    validate_response_body('list', 'MailOrder', Body, ValidatorState);
validate_response('getMailOrders', 401, Body, ValidatorState) ->
    validate_response_body('ErrorMessage', 'ErrorMessage', Body, ValidatorState);
validate_response('pingServer', 200, Body, ValidatorState) ->
    validate_response_body('binary', 'string', Body, ValidatorState);
validate_response('pingServer', 0, Body, ValidatorState) ->
    validate_response_body('', '', Body, ValidatorState);
validate_response(_OperationID, _Code, _Body, _ValidatorState) ->
    ok.

%%%
-spec request_params(OperationID :: operation_id()) -> [Param :: request_param()].
request_params('addRule') ->
    [
        'type',
        'data',
        'user'
    ];
request_params('deleteRule') ->
    [
        'ruleId'
    ];
request_params('delistBlock') ->
    [
        'EmailAddressParam'
    ];
request_params('getMailBlocks') ->
    [
    ];
request_params('getRules') ->
    [
    ];
request_params('getStats') ->
    [
        'time'
    ];
request_params('viewMailLog') ->
    [
        'id',
        'origin',
        'mx',
        'from',
        'to',
        'subject',
        'mailid',
        'messageId',
        'replyto',
        'headerfrom',
        'delivered',
        'skip',
        'limit',
        'startDate',
        'endDate',
        'sort',
        'dir',
        'groupby'
    ];
request_params('rawMail') ->
    [
        'SendMailRaw'
    ];
request_params('sendAdvMail') ->
    [
        'subject',
        'body',
        'from',
        'to',
        'replyto',
        'cc',
        'bcc',
        'attachments',
        'id'
    ];
request_params('sendMail') ->
    [
        'to',
        'from',
        'subject',
        'body',
        'id'
    ];
request_params('getMailOrderById') ->
    [
        'id'
    ];
request_params('getMailOrders') ->
    [
    ];
request_params('pingServer') ->
    [
    ];
request_params(_) ->
    error(unknown_operation).

-spec request_param_info(OperationID :: operation_id(), Name :: request_param()) ->
    #{source => qs_val | binding | header | body, rules => [rule()]}.
request_param_info('addRule', 'type') ->
    #{
        source => body,
        rules => [
            {type, binary},
            {enum, ['domain', 'email', 'startswith', 'destination'] },
            required
        ]
    };
request_param_info('addRule', 'data') ->
    #{
        source => body,
        rules => [
            {type, binary},
            required
        ]
    };
request_param_info('addRule', 'user') ->
    #{
        source => body,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('deleteRule', 'ruleId') ->
    #{
        source => binding,
        rules => [
            {type, integer},
            required
        ]
    };
request_param_info('delistBlock', 'EmailAddressParam') ->
    #{
        source => body,
        rules => [
            {schema, object, <<"#/components/schemas/EmailAddressParam">>},
            required
        ]
    };
request_param_info('getStats', 'time') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            {enum, ['all', 'billing', 'month', '7d', '24h', 'day', '1h'] },
            not_required
        ]
    };
request_param_info('viewMailLog', 'id') ->
    #{
        source => qs_val,
        rules => [
            {type, integer},
            not_required
        ]
    };
request_param_info('viewMailLog', 'origin') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'mx') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'from') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'to') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'subject') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'mailid') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            {max_length, 19},
            {min_length, 18},
            not_required
        ]
    };
request_param_info('viewMailLog', 'messageId') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'replyto') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'headerfrom') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'delivered') ->
    #{
        source => qs_val,
        rules => [
            {type, integer},
            {enum, ['0', '1'] },
            not_required
        ]
    };
request_param_info('viewMailLog', 'skip') ->
    #{
        source => qs_val,
        rules => [
            {type, integer},
            {min, 0},
            not_required
        ]
    };
request_param_info('viewMailLog', 'limit') ->
    #{
        source => qs_val,
        rules => [
            {type, integer},
            {max, 10000},
            {min, 1},
            not_required
        ]
    };
request_param_info('viewMailLog', 'startDate') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'endDate') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            not_required
        ]
    };
request_param_info('viewMailLog', 'sort') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            {enum, ['time'] },
            not_required
        ]
    };
request_param_info('viewMailLog', 'dir') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            {enum, ['asc', 'desc'] },
            not_required
        ]
    };
request_param_info('viewMailLog', 'groupby') ->
    #{
        source => qs_val,
        rules => [
            {type, binary},
            {enum, ['message', 'recipient'] },
            not_required
        ]
    };
request_param_info('rawMail', 'SendMailRaw') ->
    #{
        source => body,
        rules => [
            {schema, object, <<"#/components/schemas/SendMailRaw">>},
            required
        ]
    };
request_param_info('sendAdvMail', 'subject') ->
    #{
        source => body,
        rules => [
            {type, binary},
            required
        ]
    };
request_param_info('sendAdvMail', 'body') ->
    #{
        source => body,
        rules => [
            {type, binary},
            required
        ]
    };
request_param_info('sendAdvMail', 'from') ->
    #{
        source => body,
        rules => [
            required
        ]
    };
request_param_info('sendAdvMail', 'to') ->
    #{
        source => body,
        rules => [
            required
        ]
    };
request_param_info('sendAdvMail', 'replyto') ->
    #{
        source => body,
        rules => [
            not_required
        ]
    };
request_param_info('sendAdvMail', 'cc') ->
    #{
        source => body,
        rules => [
            not_required
        ]
    };
request_param_info('sendAdvMail', 'bcc') ->
    #{
        source => body,
        rules => [
            not_required
        ]
    };
request_param_info('sendAdvMail', 'attachments') ->
    #{
        source => body,
        rules => [
            not_required
        ]
    };
request_param_info('sendAdvMail', 'id') ->
    #{
        source => body,
        rules => [
            {type, integer},
            not_required
        ]
    };
request_param_info('sendMail', 'to') ->
    #{
        source => body,
        rules => [
            required
        ]
    };
request_param_info('sendMail', 'from') ->
    #{
        source => body,
        rules => [
            {type, binary},
            required
        ]
    };
request_param_info('sendMail', 'subject') ->
    #{
        source => body,
        rules => [
            {type, binary},
            required
        ]
    };
request_param_info('sendMail', 'body') ->
    #{
        source => body,
        rules => [
            {type, binary},
            required
        ]
    };
request_param_info('sendMail', 'id') ->
    #{
        source => body,
        rules => [
            {type, integer},
            not_required
        ]
    };
request_param_info('getMailOrderById', 'id') ->
    #{
        source => binding,
        rules => [
            {type, integer},
            required
        ]
    };
request_param_info(OperationID, Name) ->
    error({unknown_param, OperationID, Name}).

-spec populate_request_params(
        operation_id(), [request_param()], cowboy_req:req(), jesse_state:state(), map()) ->
    {ok, map(), cowboy_req:req()} | {error, _, cowboy_req:req()}.
populate_request_params(_, [], Req, _, Model) ->
    {ok, Model, Req};
populate_request_params(OperationID, [ReqParamName | T], Req0, ValidatorState, Model0) ->
    case populate_request_param(OperationID, ReqParamName, Req0, ValidatorState) of
        {ok, V, Req} ->
            Model = Model0#{ReqParamName => V},
            populate_request_params(OperationID, T, Req, ValidatorState, Model);
        Error ->
            Error
    end.

-spec populate_request_param(
        operation_id(), request_param(), cowboy_req:req(), jesse_state:state()) ->
    {ok, term(), cowboy_req:req()} | {error, term(), cowboy_req:req()}.
populate_request_param(OperationID, ReqParamName, Req0, ValidatorState) ->
    #{rules := Rules, source := Source} = request_param_info(OperationID, ReqParamName),
    case get_value(Source, ReqParamName, Req0) of
        {error, Reason, Req} ->
            {error, Reason, Req};
        {Value, Req} ->
            case prepare_param(Rules, ReqParamName, Value, ValidatorState) of
                {ok, Result} -> {ok, Result, Req};
                {error, Reason} ->
                    {error, Reason, Req}
            end
    end.

validate_response_body(list, ReturnBaseType, Body, ValidatorState) ->
    [
        validate(schema, Item, ReturnBaseType, ValidatorState)
    || Item <- Body];

validate_response_body(_, ReturnBaseType, Body, ValidatorState) ->
    validate(schema, Body, ReturnBaseType, ValidatorState).

-spec validate(rule(), term(), request_param(), jesse_state:state()) ->
    ok | {ok, term()}.
validate(required, undefined, ReqParamName, _) ->
    validation_error(required, ReqParamName, undefined);
validate(required, _Value, _, _) ->
    ok;
validate(not_required, _Value, _, _) ->
    ok;
validate(_, undefined, _, _) ->
    ok;
validate({type, boolean}, Value, _, _) when is_boolean(Value) ->
    ok;
validate({type, integer}, Value, _, _) when is_integer(Value) ->
    ok;
validate({type, float}, Value, _, _) when is_float(Value) ->
    ok;
validate({type, binary}, Value, _, _) when is_binary(Value) ->
    ok;
validate({max, Max}, Value, _, _) when Value =< Max ->
    ok;
validate({min, Min}, Value, _, _) when Min =< Value ->
    ok;
validate({exclusive_max, Max}, Value, _, _) when Value < Max ->
    ok;
validate({exclusive_min, Min}, Value, _, _) when Min < Value ->
    ok;
validate({max_length, MaxLength}, Value, _, _) when is_binary(Value), byte_size(Value) =< MaxLength ->
    ok;
validate({min_length, MinLength}, Value, _, _) when is_binary(Value), MinLength =< byte_size(Value) ->
    ok;
validate(Rule = {type, byte}, Value, ReqParamName, _) when is_binary(Value) ->
    try base64:decode(Value) of
        Decoded -> {ok, Decoded}
    catch error:_Error -> validation_error(Rule, ReqParamName, Value)
    end;
validate(Rule = {type, boolean}, Value, ReqParamName, _) when is_binary(Value) ->
    case to_binary(string:lowercase(Value)) of
        <<"true">> -> {ok, true};
        <<"false">> -> {ok, false};
        _ -> validation_error(Rule, ReqParamName, Value)
    end;
validate(Rule = {type, integer}, Value, ReqParamName, _) when is_binary(Value) ->
    try
        {ok, binary_to_integer(Value)}
    catch
        error:badarg ->
            validation_error(Rule, ReqParamName, Value)
    end;
validate(Rule = {type, float}, Value, ReqParamName, _) when is_binary(Value) ->
    try
        {ok, binary_to_float(Value)}
    catch
        error:badarg ->
            validation_error(Rule, ReqParamName, Value)
    end;
validate(Rule = {type, date}, Value, ReqParamName, _) ->
    case is_binary(Value) of
        true -> ok;
        false -> validation_error(Rule, ReqParamName, Value)
    end;
validate(Rule = {type, datetime}, Value, ReqParamName, _) ->
    try calendar:rfc3339_to_system_time(binary_to_list(Value)) of
        _ -> ok
    catch error:_Error -> validation_error(Rule, ReqParamName, Value)
    end;
validate(Rule = {enum, Values}, Value, ReqParamName, _) ->
    try
        FormattedValue = erlang:binary_to_existing_atom(Value, utf8),
        case lists:member(FormattedValue, Values) of
            true -> {ok, FormattedValue};
            false -> validation_error(Rule, ReqParamName, Value)
        end
    catch
        error:badarg ->
            validation_error(Rule, ReqParamName, Value)
    end;
validate(Rule = {pattern, Pattern}, Value, ReqParamName, _) ->
    {ok, MP} = re:compile(Pattern),
    case re:run(Value, MP) of
        {match, _} -> ok;
        _ -> validation_error(Rule, ReqParamName, Value)
    end;
validate(schema, Value, ReqParamName, ValidatorState) ->
    Definition = iolist_to_binary(["#/components/schemas/", atom_to_binary(ReqParamName, utf8)]),
    validate({schema, object, Definition}, Value, ReqParamName, ValidatorState);
validate({schema, list, Definition}, Value, ReqParamName, ValidatorState) ->
    lists:foreach(
      fun(Item) ->
              validate({schema, object, Definition}, Item, ReqParamName, ValidatorState)
      end, Value);
validate(Rule = {schema, object, Definition}, Value, ReqParamName, ValidatorState) ->
    try
        _ = validate_with_schema(Value, Definition, ValidatorState),
        ok
    catch
        throw:[{schema_invalid, _, Error} | _] ->
            Info = #{
                type => schema_invalid,
                error => Error
            },
            validation_error(Rule, ReqParamName, Value, Info);
        throw:[{data_invalid, Schema, Error, _, Path} | _] ->
            Info = #{
                type => data_invalid,
                error => Error,
                schema => Schema,
                path => Path
            },
            validation_error(Rule, ReqParamName, Value, Info)
    end;
validate(Rule, Value, ReqParamName, _) ->
    validation_error(Rule, ReqParamName, Value).

-spec validation_error(rule(), request_param(), term()) -> no_return().
validation_error(ViolatedRule, Name, Value) ->
    validation_error(ViolatedRule, Name, Value, #{}).

-spec validation_error(rule(), request_param(), term(), Info :: #{_ := _}) -> no_return().
validation_error(ViolatedRule, Name, Value, Info) ->
    throw({wrong_param, Name, Value, ViolatedRule, Info}).

-spec get_value(body | qs_val | header | binding, request_param(), cowboy_req:req()) ->
    {any(), cowboy_req:req()} |
    {error, any(), cowboy_req:req()}.
get_value(body, _Name, Req0) ->
    {ok, Body, Req} = read_entire_body(Req0),
    case prepare_body(Body) of
        {error, Reason} ->
            {error, Reason, Req};
        Value ->
            {Value, Req}
    end;
get_value(qs_val, Name, Req) ->
    QS = cowboy_req:parse_qs(Req),
    Value = get_opt(to_qs(Name), QS),
    {Value, Req};
get_value(header, Name, Req) ->
    Headers = cowboy_req:headers(Req),
    Value = maps:get(to_header(Name), Headers, undefined),
    {Value, Req};
get_value(binding, Name, Req) ->
    Value = cowboy_req:binding(Name, Req),
    {Value, Req}.

-spec read_entire_body(cowboy_req:req()) -> {ok, binary(), cowboy_req:req()}.
read_entire_body(Req) ->
    read_entire_body(Req, []).

-spec read_entire_body(cowboy_req:req(), iodata()) -> {ok, binary(), cowboy_req:req()}.
read_entire_body(Request, Acc) -> % {
    case cowboy_req:read_body(Request) of
        {ok, Data, NewRequest} ->
            {ok, iolist_to_binary(lists:reverse([Data | Acc])), NewRequest};
        {more, Data, NewRequest} ->
            read_entire_body(NewRequest, [Data | Acc])
    end.

prepare_body(<<>>) ->
    <<>>;
prepare_body(Body) ->
    try
        json:decode(Body)
    catch
        error:Error ->
            {error, {invalid_json, Body, Error}}
    end.

validate_with_schema(Body, Definition, ValidatorState) ->
    jesse_schema_validator:validate_with_state(
        [{<<"$ref">>, Definition}],
        Body,
        ValidatorState
    ).

-spec prepare_param([rule()], request_param(), term(), jesse_state:state()) ->
    {ok, term()} | {error, Reason :: any()}.
prepare_param(Rules, ReqParamName, Value, ValidatorState) ->
    Fun = fun(Rule, Acc) ->
        case validate(Rule, Acc, ReqParamName, ValidatorState) of
            ok -> Acc;
            {ok, Prepared} -> Prepared
        end
    end,
    try
        Result = lists:foldl(Fun, Value, Rules),
        {ok, Result}
    catch
        throw:Reason ->
            {error, Reason}
    end.

-spec to_binary(iodata()) -> binary().
to_binary(V) when is_binary(V)  -> V;
to_binary(V) when is_list(V)    -> iolist_to_binary(V).

-spec to_header(request_param()) -> binary().
to_header(Name) ->
    to_binary(string:lowercase(atom_to_binary(Name, utf8))).

-spec to_qs(request_param()) -> binary().
to_qs(Name) ->
    atom_to_binary(Name, utf8).

-spec get_opt(any(), []) -> any().
get_opt(Key, Opts) ->
    get_opt(Key, Opts, undefined).

-spec get_opt(any(), [], any()) -> any().
get_opt(Key, Opts, Default) ->
    case lists:keyfind(Key, 1, Opts) of
        {_, Value} -> Value;
        false -> Default
    end.

get_openapi_path() ->
    {ok, AppName} = application:get_application(?MODULE),
    filename:join(priv_dir(AppName), "openapi.json").

-include_lib("kernel/include/file.hrl").

-spec priv_dir(Application :: atom()) -> file:name_all().
priv_dir(AppName) ->
    case code:priv_dir(AppName) of
        Value when is_list(Value) ->
            Value ++ "/";
        _Error ->
            select_priv_dir([filename:join(["apps", atom_to_list(AppName), "priv"]), "priv"])
     end.

select_priv_dir(Paths) ->
    case lists:dropwhile(fun test_priv_dir/1, Paths) of
        [Path | _] -> Path;
        _          -> exit(no_priv_dir)
    end.

test_priv_dir(Path) ->
    case file:read_file_info(Path) of
        {ok, #file_info{type = directory}} ->
            false;
        _ ->
            true
    end.
