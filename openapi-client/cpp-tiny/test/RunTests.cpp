
#include "DenyRuleNewTest.cpp"

#include "DenyRuleRecordTest.cpp"

#include "EmailAddressNameTest.cpp"

#include "EmailAddressTypesTest.cpp"

#include "EmailAddressesTypesTest.cpp"

#include "ErrorMessageTest.cpp"

#include "GenericResponseTest.cpp"

#include "MailAttachmentTest.cpp"

#include "MailBlockClickHouseTest.cpp"

#include "MailBlockRspamdTest.cpp"

#include "MailBlocksTest.cpp"

#include "MailLogTest.cpp"

#include "MailLogEntryTest.cpp"

#include "MailOrderTest.cpp"

#include "MailStatsTypeTest.cpp"

#include "MailStatsType_volumeTest.cpp"

#include "MailStatsType_volume_fromTest.cpp"

#include "MailStatsType_volume_ipTest.cpp"

#include "MailStatsType_volume_toTest.cpp"

#include "RawMailTest.cpp"

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
    
    
    
    RUN_TEST(test_MailStatsType_time_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_usage_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_currency_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_currencySymbol_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_cost_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_received_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_sent_is_assigned_from_json);
    
    
    
    
    
    
    
    
    RUN_TEST(test_MailStatsType_volume_from_billingsomedomaincom_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_volume_from_salessomedomaincom_is_assigned_from_json);
    
    
    
    RUN_TEST(test_MailStatsType_volume_ip_1111_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_volume_ip_2222_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_volume_ip_3333_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_volume_ip_4444_is_assigned_from_json);
    
    
    
    RUN_TEST(test_MailStatsType_volume_to_clientdomaincom_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_volume_to_usersitenet_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_volume_to_salescompanycom_is_assigned_from_json);
    
    
    RUN_TEST(test_MailStatsType_volume_to_clientanothersitecom_is_assigned_from_json);
    
    
    
    RUN_TEST(test_RawMail_raw_email_is_assigned_from_json);
    
    
    
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
    
    
    
    RUN_TEST(test_MailStatsType_time_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_usage_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_currency_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_currencySymbol_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_cost_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_received_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_sent_is_converted_to_json);
    
    
    
    
    
    
    
    
    RUN_TEST(test_MailStatsType_volume_from_billingsomedomaincom_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_volume_from_salessomedomaincom_is_converted_to_json);
    
    
    
    RUN_TEST(test_MailStatsType_volume_ip_1111_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_volume_ip_2222_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_volume_ip_3333_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_volume_ip_4444_is_converted_to_json);
    
    
    
    RUN_TEST(test_MailStatsType_volume_to_clientdomaincom_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_volume_to_usersitenet_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_volume_to_salescompanycom_is_converted_to_json);
    
    
    RUN_TEST(test_MailStatsType_volume_to_clientanothersitecom_is_converted_to_json);
    
    
    
    RUN_TEST(test_RawMail_raw_email_is_converted_to_json);
    
    
    
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
