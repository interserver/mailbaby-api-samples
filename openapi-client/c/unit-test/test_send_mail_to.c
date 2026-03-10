#ifndef send_mail_to_TEST
#define send_mail_to_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define send_mail_to_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/send_mail_to.h"
send_mail_to_t* instantiate_send_mail_to(int include_optional);



send_mail_to_t* instantiate_send_mail_to(int include_optional) {
  send_mail_to_t* send_mail_to = NULL;
  if (include_optional) {
    send_mail_to = send_mail_to_create(
    );
  } else {
    send_mail_to = send_mail_to_create(
    );
  }

  return send_mail_to;
}


#ifdef send_mail_to_MAIN

void test_send_mail_to(int include_optional) {
    send_mail_to_t* send_mail_to_1 = instantiate_send_mail_to(include_optional);

	cJSON* jsonsend_mail_to_1 = send_mail_to_convertToJSON(send_mail_to_1);
	printf("send_mail_to :\n%s\n", cJSON_Print(jsonsend_mail_to_1));
	send_mail_to_t* send_mail_to_2 = send_mail_to_parseFromJSON(jsonsend_mail_to_1);
	cJSON* jsonsend_mail_to_2 = send_mail_to_convertToJSON(send_mail_to_2);
	printf("repeating send_mail_to:\n%s\n", cJSON_Print(jsonsend_mail_to_2));
}

int main() {
  test_send_mail_to(1);
  test_send_mail_to(0);

  printf("Hello world \n");
  return 0;
}

#endif // send_mail_to_MAIN
#endif // send_mail_to_TEST
