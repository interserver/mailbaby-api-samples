
#include "GetStats_200_response_inner.h"

using namespace Tiny;

#include <string>
#include <list>
#include <unity.h>
#include "bourne/json.hpp"



void test_GetStats_200_response_inner_id_is_assigned_from_json()
{
    bourne::json input =
    {
        "id", 1
    };

    GetStats_200_response_inner obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getId());








}


void test_GetStats_200_response_inner_status_is_assigned_from_json()
{


    bourne::json input =
    {
        "status", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getStatus().c_str());






}


void test_GetStats_200_response_inner_username_is_assigned_from_json()
{


    bourne::json input =
    {
        "username", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getUsername().c_str());






}


void test_GetStats_200_response_inner_password_is_assigned_from_json()
{


    bourne::json input =
    {
        "password", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getPassword().c_str());






}


void test_GetStats_200_response_inner_comment_is_assigned_from_json()
{


    bourne::json input =
    {
        "comment", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getComment().c_str());






}



void test_GetStats_200_response_inner_id_is_converted_to_json()
{
    bourne::json input =
    {
        "id", 1
    };

    GetStats_200_response_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["id"] == output["id"]);




}


void test_GetStats_200_response_inner_status_is_converted_to_json()
{

    bourne::json input =
    {
        "status", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["status"] == output["status"]);



}


void test_GetStats_200_response_inner_username_is_converted_to_json()
{

    bourne::json input =
    {
        "username", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["username"] == output["username"]);



}


void test_GetStats_200_response_inner_password_is_converted_to_json()
{

    bourne::json input =
    {
        "password", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["password"] == output["password"]);



}


void test_GetStats_200_response_inner_comment_is_converted_to_json()
{

    bourne::json input =
    {
        "comment", "hello"
    };

    GetStats_200_response_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["comment"] == output["comment"]);



}


