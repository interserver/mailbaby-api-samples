
#include "RawMail.h"

using namespace Tiny;

#include <string>
#include <list>
#include <unity.h>
#include "bourne/json.hpp"



void test_RawMail_raw_email_is_assigned_from_json()
{


    bourne::json input =
    {
        "raw_email", "hello"
    };

    RawMail obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getRawEmail().c_str());






}



void test_RawMail_raw_email_is_converted_to_json()
{

    bourne::json input =
    {
        "raw_email", "hello"
    };

    RawMail obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["raw_email"] == output["raw_email"]);



}


