
#include "GetMailOrders_401_response.h"

using namespace Tiny;

#include <string>
#include <list>
#include <unity.h>
#include "bourne/json.hpp"



void test_GetMailOrders_401_response_code_is_assigned_from_json()
{


    bourne::json input =
    {
        "code", "hello"
    };

    GetMailOrders_401_response obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getCode().c_str());






}


void test_GetMailOrders_401_response_message_is_assigned_from_json()
{


    bourne::json input =
    {
        "message", "hello"
    };

    GetMailOrders_401_response obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getMessage().c_str());






}



void test_GetMailOrders_401_response_code_is_converted_to_json()
{

    bourne::json input =
    {
        "code", "hello"
    };

    GetMailOrders_401_response obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["code"] == output["code"]);



}


void test_GetMailOrders_401_response_message_is_converted_to_json()
{

    bourne::json input =
    {
        "message", "hello"
    };

    GetMailOrders_401_response obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["message"] == output["message"]);



}


