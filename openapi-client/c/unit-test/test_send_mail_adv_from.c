#ifndef send_mail_adv_from_TEST
#define send_mail_adv_from_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define send_mail_adv_from_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/send_mail_adv_from.h"
send_mail_adv_from_t* instantiate_send_mail_adv_from(int include_optional);



send_mail_adv_from_t* instantiate_send_mail_adv_from(int include_optional) {
  send_mail_adv_from_t* send_mail_adv_from = NULL;
  if (include_optional) {
    send_mail_adv_from = send_mail_adv_from_create(
      "business@company.com",
      "The Man"
    );
  } else {
    send_mail_adv_from = send_mail_adv_from_create(
      "business@company.com",
      "The Man"
    );
  }

  return send_mail_adv_from;
}


#ifdef send_mail_adv_from_MAIN

void test_send_mail_adv_from(int include_optional) {
    send_mail_adv_from_t* send_mail_adv_from_1 = instantiate_send_mail_adv_from(include_optional);

	cJSON* jsonsend_mail_adv_from_1 = send_mail_adv_from_convertToJSON(send_mail_adv_from_1);
	printf("send_mail_adv_from :\n%s\n", cJSON_Print(jsonsend_mail_adv_from_1));
	send_mail_adv_from_t* send_mail_adv_from_2 = send_mail_adv_from_parseFromJSON(jsonsend_mail_adv_from_1);
	cJSON* jsonsend_mail_adv_from_2 = send_mail_adv_from_convertToJSON(send_mail_adv_from_2);
	printf("repeating send_mail_adv_from:\n%s\n", cJSON_Print(jsonsend_mail_adv_from_2));
}

int main() {
  test_send_mail_adv_from(1);
  test_send_mail_adv_from(0);

  printf("Hello world \n");
  return 0;
}

#endif // send_mail_adv_from_MAIN
#endif // send_mail_adv_from_TEST
