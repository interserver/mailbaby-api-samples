#ifndef send_mail_adv_attachments_inner_TEST
#define send_mail_adv_attachments_inner_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define send_mail_adv_attachments_inner_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/send_mail_adv_attachments_inner.h"
send_mail_adv_attachments_inner_t* instantiate_send_mail_adv_attachments_inner(int include_optional);



send_mail_adv_attachments_inner_t* instantiate_send_mail_adv_attachments_inner(int include_optional) {
  send_mail_adv_attachments_inner_t* send_mail_adv_attachments_inner = NULL;
  if (include_optional) {
    send_mail_adv_attachments_inner = send_mail_adv_attachments_inner_create(
      instantiate_binary_t("blah", 5),
      "company_logo.png"
    );
  } else {
    send_mail_adv_attachments_inner = send_mail_adv_attachments_inner_create(
      instantiate_binary_t("blah", 5),
      "company_logo.png"
    );
  }

  return send_mail_adv_attachments_inner;
}


#ifdef send_mail_adv_attachments_inner_MAIN

void test_send_mail_adv_attachments_inner(int include_optional) {
    send_mail_adv_attachments_inner_t* send_mail_adv_attachments_inner_1 = instantiate_send_mail_adv_attachments_inner(include_optional);

	cJSON* jsonsend_mail_adv_attachments_inner_1 = send_mail_adv_attachments_inner_convertToJSON(send_mail_adv_attachments_inner_1);
	printf("send_mail_adv_attachments_inner :\n%s\n", cJSON_Print(jsonsend_mail_adv_attachments_inner_1));
	send_mail_adv_attachments_inner_t* send_mail_adv_attachments_inner_2 = send_mail_adv_attachments_inner_parseFromJSON(jsonsend_mail_adv_attachments_inner_1);
	cJSON* jsonsend_mail_adv_attachments_inner_2 = send_mail_adv_attachments_inner_convertToJSON(send_mail_adv_attachments_inner_2);
	printf("repeating send_mail_adv_attachments_inner:\n%s\n", cJSON_Print(jsonsend_mail_adv_attachments_inner_2));
}

int main() {
  test_send_mail_adv_attachments_inner(1);
  test_send_mail_adv_attachments_inner(0);

  printf("Hello world \n");
  return 0;
}

#endif // send_mail_adv_attachments_inner_MAIN
#endif // send_mail_adv_attachments_inner_TEST
