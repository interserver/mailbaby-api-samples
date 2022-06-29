
#include "SendMailAdv_attachments_inner.h"

using namespace Tiny;

#include <string>
#include <list>
#include <unity.h>
#include "bourne/json.hpp"



void test_SendMailAdv_attachments_inner_data_is_assigned_from_json()
{








}


void test_SendMailAdv_attachments_inner_filename_is_assigned_from_json()
{


    bourne::json input =
    {
        "filename", "hello"
    };

    SendMailAdv_attachments_inner obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getFilename().c_str());






}



void test_SendMailAdv_attachments_inner_data_is_converted_to_json()
{




}


void test_SendMailAdv_attachments_inner_filename_is_converted_to_json()
{

    bourne::json input =
    {
        "filename", "hello"
    };

    SendMailAdv_attachments_inner obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["filename"] == output["filename"]);



}


