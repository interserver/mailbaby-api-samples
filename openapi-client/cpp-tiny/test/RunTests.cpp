
#include "DenyRuleNewTest.cpp"

#include "DenyRuleRecordTest.cpp"

#include "EmailAddressNameTest.cpp"

#include "EmailAddressTypesTest.cpp"

#include "EmailAddressesTypesTest.cpp"

#include "ErrorMessageTest.cpp"

#include "GenericResponseTest.cpp"

#include "GetStats_200_response_innerTest.cpp"

#include "MailAttachmentTest.cpp"

#include "MailBlockClickHouseTest.cpp"

#include "MailBlockRspamdTest.cpp"

#include "MailBlocksTest.cpp"

#include "MailLogTest.cpp"

#include "MailLogEntryTest.cpp"

#include "MailOrderTest.cpp"

#include "SendMailTest.cpp"

#include "SendMailAdvTest.cpp"



void setUp(){}

void tearDown(){}

void runTests(){
    
    
    RUN_TEST(test_DenyRuleNew_type_is_assigned_from_json);
    
    
    RUN_TEST(test_DenyRuleNew_data_is_assigned_from_json);
    
    
    RUN_TEST(test_DenyRuleNew_user_is_assigned_from_json);
    
    
    
    RUN_TEST(test_DenyRuleRecord_type_is_assigned_from_json);
    
    
    RUN_TEST(test_DenyRuleRecord_data_is_assigned_from_json);
    
    
    RUN_TEST(test_DenyRuleRecord_id_is_assigned_from_json);
    
    
    RUN_TEST(test_DenyRuleRecord_created_is_assigned_from_json);
    
    
    RUN_TEST(test_DenyRuleRecord_user_is_assigned_from_json);
    
    
    
    RUN_TEST(test_EmailAddressName_email_is_assigned_from_json);
    
    
    RUN_TEST(test_EmailAddressName_name_is_assigned_from_json);
    
    
    
    RUN_TEST(test_EmailAddressTypes_email_is_assigned_from_json);
    
    
    RUN_TEST(test_EmailAddressTypes_name_is_assigned_from_json);
    
    
    
    
    RUN_TEST(test_ErrorMessage_code_is_assigned_from_json);
    
    
    RUN_TEST(test_ErrorMessage_message_is_assigned_from_json);
    
    
    
    RUN_TEST(test_GenericResponse_status_is_assigned_from_json);
    
    
    RUN_TEST(test_GenericResponse_text_is_assigned_from_json);
    
    
    
    RUN_TEST(test_GetStats_200_response_inner_id_is_assigned_from_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_status_is_assigned_from_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_username_is_assigned_from_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_password_is_assigned_from_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_comment_is_assigned_from_json);
    
    
    
    RUN_TEST(test_MailAttachment_filename_is_assigned_from_json);
    
    
    RUN_TEST(test_MailAttachment_data_is_assigned_from_json);
    
    
    
    
    RUN_TEST(test_MailBlockClickHouse_from_is_assigned_from_json);
    
    
    RUN_TEST(test_MailBlockClickHouse_messageId_is_assigned_from_json);
    
    
    RUN_TEST(test_MailBlockClickHouse_subject_is_assigned_from_json);
    
    
    RUN_TEST(test_MailBlockClickHouse_to_is_assigned_from_json);
    
    
    
    RUN_TEST(test_MailBlockRspamd_from_is_assigned_from_json);
    
    
    RUN_TEST(test_MailBlockRspamd_subject_is_assigned_from_json);
    
    
    
    
    
    
    
    RUN_TEST(test_MailLog_total_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLog_skip_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLog_limit_is_assigned_from_json);
    
    
    
    
    RUN_TEST(test_MailLogEntry__id_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_id_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_from_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_to_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_subject_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_created_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_time_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_user_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_transtype_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_origin_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_interface_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_sendingZone_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_bodySize_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_seq_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_recipient_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_domain_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_locked_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_lockTime_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_assigned_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_queued_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_mxHostname_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_response_is_assigned_from_json);
    
    
    RUN_TEST(test_MailLogEntry_messageId_is_assigned_from_json);
    
    
    
    RUN_TEST(test_MailOrder_id_is_assigned_from_json);
    
    
    RUN_TEST(test_MailOrder_status_is_assigned_from_json);
    
    
    RUN_TEST(test_MailOrder_username_is_assigned_from_json);
    
    
    RUN_TEST(test_MailOrder_comment_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMail_to_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMail_from_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMail_subject_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMail_body_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_subject_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_body_is_assigned_from_json);
    
    
    
    
    
    
    
    
    RUN_TEST(test_SendMailAdv_id_is_assigned_from_json);
    
    

    
    
    RUN_TEST(test_DenyRuleNew_type_is_converted_to_json);
    
    
    RUN_TEST(test_DenyRuleNew_data_is_converted_to_json);
    
    
    RUN_TEST(test_DenyRuleNew_user_is_converted_to_json);
    
    
    
    RUN_TEST(test_DenyRuleRecord_type_is_converted_to_json);
    
    
    RUN_TEST(test_DenyRuleRecord_data_is_converted_to_json);
    
    
    RUN_TEST(test_DenyRuleRecord_id_is_converted_to_json);
    
    
    RUN_TEST(test_DenyRuleRecord_created_is_converted_to_json);
    
    
    RUN_TEST(test_DenyRuleRecord_user_is_converted_to_json);
    
    
    
    RUN_TEST(test_EmailAddressName_email_is_converted_to_json);
    
    
    RUN_TEST(test_EmailAddressName_name_is_converted_to_json);
    
    
    
    RUN_TEST(test_EmailAddressTypes_email_is_converted_to_json);
    
    
    RUN_TEST(test_EmailAddressTypes_name_is_converted_to_json);
    
    
    
    
    RUN_TEST(test_ErrorMessage_code_is_converted_to_json);
    
    
    RUN_TEST(test_ErrorMessage_message_is_converted_to_json);
    
    
    
    RUN_TEST(test_GenericResponse_status_is_converted_to_json);
    
    
    RUN_TEST(test_GenericResponse_text_is_converted_to_json);
    
    
    
    RUN_TEST(test_GetStats_200_response_inner_id_is_converted_to_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_status_is_converted_to_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_username_is_converted_to_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_password_is_converted_to_json);
    
    
    RUN_TEST(test_GetStats_200_response_inner_comment_is_converted_to_json);
    
    
    
    RUN_TEST(test_MailAttachment_filename_is_converted_to_json);
    
    
    RUN_TEST(test_MailAttachment_data_is_converted_to_json);
    
    
    
    
    RUN_TEST(test_MailBlockClickHouse_from_is_converted_to_json);
    
    
    RUN_TEST(test_MailBlockClickHouse_messageId_is_converted_to_json);
    
    
    RUN_TEST(test_MailBlockClickHouse_subject_is_converted_to_json);
    
    
    RUN_TEST(test_MailBlockClickHouse_to_is_converted_to_json);
    
    
    
    RUN_TEST(test_MailBlockRspamd_from_is_converted_to_json);
    
    
    RUN_TEST(test_MailBlockRspamd_subject_is_converted_to_json);
    
    
    
    
    
    
    
    RUN_TEST(test_MailLog_total_is_converted_to_json);
    
    
    RUN_TEST(test_MailLog_skip_is_converted_to_json);
    
    
    RUN_TEST(test_MailLog_limit_is_converted_to_json);
    
    
    
    
    RUN_TEST(test_MailLogEntry__id_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_id_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_from_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_to_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_subject_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_created_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_time_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_user_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_transtype_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_origin_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_interface_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_sendingZone_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_bodySize_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_seq_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_recipient_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_domain_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_locked_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_lockTime_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_assigned_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_queued_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_mxHostname_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_response_is_converted_to_json);
    
    
    RUN_TEST(test_MailLogEntry_messageId_is_converted_to_json);
    
    
    
    RUN_TEST(test_MailOrder_id_is_converted_to_json);
    
    
    RUN_TEST(test_MailOrder_status_is_converted_to_json);
    
    
    RUN_TEST(test_MailOrder_username_is_converted_to_json);
    
    
    RUN_TEST(test_MailOrder_comment_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMail_to_is_converted_to_json);
    
    
    RUN_TEST(test_SendMail_from_is_converted_to_json);
    
    
    RUN_TEST(test_SendMail_subject_is_converted_to_json);
    
    
    RUN_TEST(test_SendMail_body_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_subject_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_body_is_converted_to_json);
    
    
    
    
    
    
    
    
    RUN_TEST(test_SendMailAdv_id_is_converted_to_json);
    
    


}

int main(void) {
    UNITY_BEGIN();
    runTests();
    return UNITY_END();
}

void setup() {
    UNITY_BEGIN();
    runTests();
    UNITY_END();
}

void loop() {

}
