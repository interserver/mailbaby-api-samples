
#include "SendMailAdv_bcc_inner.h"

using namespace Tiny;

#include <string>
#include <list>
#include <unity.h>
#include "bourne/json.hpp"



void test_SendMailAdv_bcc_inner_email_is_assigned_from_json()
{


    bourne::json input =
    {
        "email", "hello"
    };

    SendMailAdv_bcc_inner obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getEmail().c_str());






}


void test_SendMailAdv_bcc_inner_name_is_assigned_from_json()
{


    bourne::json input =
    {
        "name", "hello"
    };

    SendMailAdv_bcc_inner obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getName().c_str());






}



void test_SendMailAdv_bcc_inner_email_is_converted_to_json()
{

    bourne::json input =
    {
        "email", "hello"
    };

    SendMailAdv_bcc_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["email"] == output["email"]);



}


void test_SendMailAdv_bcc_inner_name_is_converted_to_json()
{

    bourne::json input =
    {
        "name", "hello"
    };

    SendMailAdv_bcc_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["name"] == output["name"]);



}


