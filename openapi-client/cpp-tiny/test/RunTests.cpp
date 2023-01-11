
#include "GenericResponseTest.cpp"

#include "GetMailOrders_200_response_innerTest.cpp"

#include "GetMailOrders_401_responseTest.cpp"

#include "MailLogTest.cpp"

#include "MailLogEntryTest.cpp"

#include "SendMailTest.cpp"

#include "SendMailAdvTest.cpp"

#include "SendMailAdv_attachments_innerTest.cpp"

#include "SendMailAdv_bcc_innerTest.cpp"

#include "SendMailAdv_cc_innerTest.cpp"

#include "SendMailAdv_fromTest.cpp"

#include "SendMailAdv_replyto_innerTest.cpp"

#include "SendMailAdv_to_innerTest.cpp"



void setUp(){}

void tearDown(){}

void runTests(){
    
    
    RUN_TEST(test_GenericResponse_status_is_assigned_from_json);
    
    
    RUN_TEST(test_GenericResponse_text_is_assigned_from_json);
    
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_id_is_assigned_from_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_status_is_assigned_from_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_username_is_assigned_from_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_password_is_assigned_from_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_comment_is_assigned_from_json);
    
    
    
    RUN_TEST(test_GetMailOrders_401_response_code_is_assigned_from_json);
    
    
    RUN_TEST(test_GetMailOrders_401_response_message_is_assigned_from_json);
    
    
    
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
    
    
    
    RUN_TEST(test_SendMail_to_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMail_from_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMail_subject_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMail_body_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_subject_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_body_is_assigned_from_json);
    
    
    
    
    
    
    
    
    RUN_TEST(test_SendMailAdv_id_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_attachments_inner_data_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_attachments_inner_filename_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_bcc_inner_email_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_bcc_inner_name_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_cc_inner_email_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_cc_inner_name_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_from_email_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_from_name_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_replyto_inner_email_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_replyto_inner_name_is_assigned_from_json);
    
    
    
    RUN_TEST(test_SendMailAdv_to_inner_email_is_assigned_from_json);
    
    
    RUN_TEST(test_SendMailAdv_to_inner_name_is_assigned_from_json);
    
    

    
    
    RUN_TEST(test_GenericResponse_status_is_converted_to_json);
    
    
    RUN_TEST(test_GenericResponse_text_is_converted_to_json);
    
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_id_is_converted_to_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_status_is_converted_to_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_username_is_converted_to_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_password_is_converted_to_json);
    
    
    RUN_TEST(test_GetMailOrders_200_response_inner_comment_is_converted_to_json);
    
    
    
    RUN_TEST(test_GetMailOrders_401_response_code_is_converted_to_json);
    
    
    RUN_TEST(test_GetMailOrders_401_response_message_is_converted_to_json);
    
    
    
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
    
    
    
    RUN_TEST(test_SendMail_to_is_converted_to_json);
    
    
    RUN_TEST(test_SendMail_from_is_converted_to_json);
    
    
    RUN_TEST(test_SendMail_subject_is_converted_to_json);
    
    
    RUN_TEST(test_SendMail_body_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_subject_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_body_is_converted_to_json);
    
    
    
    
    
    
    
    
    RUN_TEST(test_SendMailAdv_id_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_attachments_inner_data_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_attachments_inner_filename_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_bcc_inner_email_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_bcc_inner_name_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_cc_inner_email_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_cc_inner_name_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_from_email_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_from_name_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_replyto_inner_email_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_replyto_inner_name_is_converted_to_json);
    
    
    
    RUN_TEST(test_SendMailAdv_to_inner_email_is_converted_to_json);
    
    
    RUN_TEST(test_SendMailAdv_to_inner_name_is_converted_to_json);
    
    


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
