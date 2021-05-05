#ifndef send_mail_TEST
#define send_mail_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define send_mail_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/send_mail.h"
send_mail_t* instantiate_send_mail(int include_optional);

#include "test_mail_contact.c"


send_mail_t* instantiate_send_mail(int include_optional) {
  send_mail_t* send_mail = NULL;
  if (include_optional) {
    send_mail = send_mail_create(
      "Your Package has been Delivered!",
      "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
",
       // false, not to have infinite recursion
      instantiate_mail_contact(0),
      list_create(),
      5000,
      list_create(),
      list_create(),
      list_create(),
      list_create()
    );
  } else {
    send_mail = send_mail_create(
      "Your Package has been Delivered!",
      "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
",
      NULL,
      list_create(),
      5000,
      list_create(),
      list_create(),
      list_create(),
      list_create()
    );
  }

  return send_mail;
}


#ifdef send_mail_MAIN

void test_send_mail(int include_optional) {
    send_mail_t* send_mail_1 = instantiate_send_mail(include_optional);

	cJSON* jsonsend_mail_1 = send_mail_convertToJSON(send_mail_1);
	printf("send_mail :\n%s\n", cJSON_Print(jsonsend_mail_1));
	send_mail_t* send_mail_2 = send_mail_parseFromJSON(jsonsend_mail_1);
	cJSON* jsonsend_mail_2 = send_mail_convertToJSON(send_mail_2);
	printf("repeating send_mail:\n%s\n", cJSON_Print(jsonsend_mail_2));
}

int main() {
  test_send_mail(1);
  test_send_mail(0);

  printf("Hello world \n");
  return 0;
}

#endif // send_mail_MAIN
#endif // send_mail_TEST
