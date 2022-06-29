
#include "MailLogEntry.h"

using namespace Tiny;

#include <string>
#include <list>
#include <unity.h>
#include "bourne/json.hpp"



void test_MailLogEntry__id_is_assigned_from_json()
{
    bourne::json input =
    {
        "_id", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getId());








}


void test_MailLogEntry_id_is_assigned_from_json()
{


    bourne::json input =
    {
        "id", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getId().c_str());






}


void test_MailLogEntry_from_is_assigned_from_json()
{


    bourne::json input =
    {
        "from", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getFrom().c_str());






}


void test_MailLogEntry_to_is_assigned_from_json()
{


    bourne::json input =
    {
        "to", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getTo().c_str());






}


void test_MailLogEntry_subject_is_assigned_from_json()
{


    bourne::json input =
    {
        "subject", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getSubject().c_str());






}


void test_MailLogEntry_messageId_is_assigned_from_json()
{


    bourne::json input =
    {
        "messageId", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getMessageId().c_str());






}


void test_MailLogEntry_created_is_assigned_from_json()
{


    bourne::json input =
    {
        "created", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getCreated().c_str());






}


void test_MailLogEntry_time_is_assigned_from_json()
{
    bourne::json input =
    {
        "time", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getTime());








}


void test_MailLogEntry_user_is_assigned_from_json()
{


    bourne::json input =
    {
        "user", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getUser().c_str());






}


void test_MailLogEntry_transtype_is_assigned_from_json()
{


    bourne::json input =
    {
        "transtype", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getTranstype().c_str());






}


void test_MailLogEntry_transhost_is_assigned_from_json()
{


    bourne::json input =
    {
        "transhost", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getTranshost().c_str());






}


void test_MailLogEntry_originhost_is_assigned_from_json()
{


    bourne::json input =
    {
        "originhost", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getOriginhost().c_str());






}


void test_MailLogEntry_origin_is_assigned_from_json()
{


    bourne::json input =
    {
        "origin", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getOrigin().c_str());






}


void test_MailLogEntry_interface_is_assigned_from_json()
{


    bourne::json input =
    {
        "interface", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getInterface().c_str());






}


void test_MailLogEntry_date_is_assigned_from_json()
{


    bourne::json input =
    {
        "date", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getDate().c_str());






}


void test_MailLogEntry_sendingZone_is_assigned_from_json()
{


    bourne::json input =
    {
        "sendingZone", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getSendingZone().c_str());






}


void test_MailLogEntry_bodySize_is_assigned_from_json()
{
    bourne::json input =
    {
        "bodySize", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getBodySize());








}


void test_MailLogEntry_sourceMd5_is_assigned_from_json()
{


    bourne::json input =
    {
        "sourceMd5", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getSourceMd5().c_str());






}


void test_MailLogEntry_seq_is_assigned_from_json()
{
    bourne::json input =
    {
        "seq", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getSeq());








}


void test_MailLogEntry_domain_is_assigned_from_json()
{


    bourne::json input =
    {
        "domain", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getDomain().c_str());






}


void test_MailLogEntry_recipient_is_assigned_from_json()
{


    bourne::json input =
    {
        "recipient", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getRecipient().c_str());






}


void test_MailLogEntry_locked_is_assigned_from_json()
{
    bourne::json input =
    {
        "locked", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getLocked());








}


void test_MailLogEntry_lockTime_is_assigned_from_json()
{
    bourne::json input =
    {
        "lockTime", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getLockTime());








}


void test_MailLogEntry_assigned_is_assigned_from_json()
{


    bourne::json input =
    {
        "assigned", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getAssigned().c_str());






}


void test_MailLogEntry_queued_is_assigned_from_json()
{


    bourne::json input =
    {
        "queued", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getQueued().c_str());






}


void test_MailLogEntry__lock_is_assigned_from_json()
{


    bourne::json input =
    {
        "_lock", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getLock().c_str());






}


void test_MailLogEntry_logger_is_assigned_from_json()
{


    bourne::json input =
    {
        "logger", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getLogger().c_str());






}


void test_MailLogEntry_mxPort_is_assigned_from_json()
{
    bourne::json input =
    {
        "mxPort", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getMxPort());








}


void test_MailLogEntry_connectionKey_is_assigned_from_json()
{


    bourne::json input =
    {
        "connectionKey", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getConnectionKey().c_str());






}


void test_MailLogEntry_mxHostname_is_assigned_from_json()
{


    bourne::json input =
    {
        "mxHostname", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getMxHostname().c_str());






}


void test_MailLogEntry_sentBodyHash_is_assigned_from_json()
{


    bourne::json input =
    {
        "sentBodyHash", "hello"
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_STRING("hello", obj.getSentBodyHash().c_str());






}


void test_MailLogEntry_sentBodySize_is_assigned_from_json()
{
    bourne::json input =
    {
        "sentBodySize", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getSentBodySize());








}


void test_MailLogEntry_md5Match_is_assigned_from_json()
{
    bourne::json input =
    {
        "md5Match", 1
    };

    MailLogEntry obj(input.dump());

    TEST_ASSERT_EQUAL_INT(1, obj.getMd5Match());








}



void test_MailLogEntry__id_is_converted_to_json()
{
    bourne::json input =
    {
        "_id", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["_id"] == output["_id"]);




}


void test_MailLogEntry_id_is_converted_to_json()
{

    bourne::json input =
    {
        "id", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["id"] == output["id"]);



}


void test_MailLogEntry_from_is_converted_to_json()
{

    bourne::json input =
    {
        "from", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["from"] == output["from"]);



}


void test_MailLogEntry_to_is_converted_to_json()
{

    bourne::json input =
    {
        "to", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["to"] == output["to"]);



}


void test_MailLogEntry_subject_is_converted_to_json()
{

    bourne::json input =
    {
        "subject", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["subject"] == output["subject"]);



}


void test_MailLogEntry_messageId_is_converted_to_json()
{

    bourne::json input =
    {
        "messageId", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["messageId"] == output["messageId"]);



}


void test_MailLogEntry_created_is_converted_to_json()
{

    bourne::json input =
    {
        "created", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["created"] == output["created"]);



}


void test_MailLogEntry_time_is_converted_to_json()
{
    bourne::json input =
    {
        "time", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["time"] == output["time"]);




}


void test_MailLogEntry_user_is_converted_to_json()
{

    bourne::json input =
    {
        "user", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["user"] == output["user"]);



}


void test_MailLogEntry_transtype_is_converted_to_json()
{

    bourne::json input =
    {
        "transtype", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["transtype"] == output["transtype"]);



}


void test_MailLogEntry_transhost_is_converted_to_json()
{

    bourne::json input =
    {
        "transhost", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["transhost"] == output["transhost"]);



}


void test_MailLogEntry_originhost_is_converted_to_json()
{

    bourne::json input =
    {
        "originhost", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["originhost"] == output["originhost"]);



}


void test_MailLogEntry_origin_is_converted_to_json()
{

    bourne::json input =
    {
        "origin", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["origin"] == output["origin"]);



}


void test_MailLogEntry_interface_is_converted_to_json()
{

    bourne::json input =
    {
        "interface", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["interface"] == output["interface"]);



}


void test_MailLogEntry_date_is_converted_to_json()
{

    bourne::json input =
    {
        "date", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["date"] == output["date"]);



}


void test_MailLogEntry_sendingZone_is_converted_to_json()
{

    bourne::json input =
    {
        "sendingZone", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["sendingZone"] == output["sendingZone"]);



}


void test_MailLogEntry_bodySize_is_converted_to_json()
{
    bourne::json input =
    {
        "bodySize", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["bodySize"] == output["bodySize"]);




}


void test_MailLogEntry_sourceMd5_is_converted_to_json()
{

    bourne::json input =
    {
        "sourceMd5", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["sourceMd5"] == output["sourceMd5"]);



}


void test_MailLogEntry_seq_is_converted_to_json()
{
    bourne::json input =
    {
        "seq", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["seq"] == output["seq"]);




}


void test_MailLogEntry_domain_is_converted_to_json()
{

    bourne::json input =
    {
        "domain", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["domain"] == output["domain"]);



}


void test_MailLogEntry_recipient_is_converted_to_json()
{

    bourne::json input =
    {
        "recipient", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["recipient"] == output["recipient"]);



}


void test_MailLogEntry_locked_is_converted_to_json()
{
    bourne::json input =
    {
        "locked", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["locked"] == output["locked"]);




}


void test_MailLogEntry_lockTime_is_converted_to_json()
{
    bourne::json input =
    {
        "lockTime", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["lockTime"] == output["lockTime"]);




}


void test_MailLogEntry_assigned_is_converted_to_json()
{

    bourne::json input =
    {
        "assigned", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["assigned"] == output["assigned"]);



}


void test_MailLogEntry_queued_is_converted_to_json()
{

    bourne::json input =
    {
        "queued", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["queued"] == output["queued"]);



}


void test_MailLogEntry__lock_is_converted_to_json()
{

    bourne::json input =
    {
        "_lock", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["_lock"] == output["_lock"]);



}


void test_MailLogEntry_logger_is_converted_to_json()
{

    bourne::json input =
    {
        "logger", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["logger"] == output["logger"]);



}


void test_MailLogEntry_mxPort_is_converted_to_json()
{
    bourne::json input =
    {
        "mxPort", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["mxPort"] == output["mxPort"]);




}


void test_MailLogEntry_connectionKey_is_converted_to_json()
{

    bourne::json input =
    {
        "connectionKey", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["connectionKey"] == output["connectionKey"]);



}


void test_MailLogEntry_mxHostname_is_converted_to_json()
{

    bourne::json input =
    {
        "mxHostname", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["mxHostname"] == output["mxHostname"]);



}


void test_MailLogEntry_sentBodyHash_is_converted_to_json()
{

    bourne::json input =
    {
        "sentBodyHash", "hello"
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["sentBodyHash"] == output["sentBodyHash"]);



}


void test_MailLogEntry_sentBodySize_is_converted_to_json()
{
    bourne::json input =
    {
        "sentBodySize", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["sentBodySize"] == output["sentBodySize"]);




}


void test_MailLogEntry_md5Match_is_converted_to_json()
{
    bourne::json input =
    {
        "md5Match", 1
    };

    MailLogEntry obj(input.dump());

    bourne::json output = bourne::json::object();

    output = obj.toJson();

    TEST_ASSERT(input["md5Match"] == output["md5Match"]);




}


