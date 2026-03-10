#ifndef send_mail_raw_TEST
#define send_mail_raw_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define send_mail_raw_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/send_mail_raw.h"
send_mail_raw_t* instantiate_send_mail_raw(int include_optional);



send_mail_raw_t* instantiate_send_mail_raw(int include_optional) {
  send_mail_raw_t* send_mail_raw = NULL;
  if (include_optional) {
    send_mail_raw = send_mail_raw_create(
      "0",
      56
    );
  } else {
    send_mail_raw = send_mail_raw_create(
      "0",
      56
    );
  }

  return send_mail_raw;
}


#ifdef send_mail_raw_MAIN

void test_send_mail_raw(int include_optional) {
    send_mail_raw_t* send_mail_raw_1 = instantiate_send_mail_raw(include_optional);

	cJSON* jsonsend_mail_raw_1 = send_mail_raw_convertToJSON(send_mail_raw_1);
	printf("send_mail_raw :\n%s\n", cJSON_Print(jsonsend_mail_raw_1));
	send_mail_raw_t* send_mail_raw_2 = send_mail_raw_parseFromJSON(jsonsend_mail_raw_1);
	cJSON* jsonsend_mail_raw_2 = send_mail_raw_convertToJSON(send_mail_raw_2);
	printf("repeating send_mail_raw:\n%s\n", cJSON_Print(jsonsend_mail_raw_2));
}

int main() {
  test_send_mail_raw(1);
  test_send_mail_raw(0);

  printf("Hello world \n");
  return 0;
}

#endif // send_mail_raw_MAIN
#endif // send_mail_raw_TEST
