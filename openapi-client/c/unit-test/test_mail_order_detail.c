#ifndef mail_order_detail_TEST
#define mail_order_detail_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define mail_order_detail_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/mail_order_detail.h"
mail_order_detail_t* instantiate_mail_order_detail(int include_optional);



mail_order_detail_t* instantiate_mail_order_detail(int include_optional) {
  mail_order_detail_t* mail_order_detail = NULL;
  if (include_optional) {
    mail_order_detail = mail_order_detail_create(
      21472,
      "active",
      "mb21472",
      "s3cr3tpassword",
      "0"
    );
  } else {
    mail_order_detail = mail_order_detail_create(
      21472,
      "active",
      "mb21472",
      "s3cr3tpassword",
      "0"
    );
  }

  return mail_order_detail;
}


#ifdef mail_order_detail_MAIN

void test_mail_order_detail(int include_optional) {
    mail_order_detail_t* mail_order_detail_1 = instantiate_mail_order_detail(include_optional);

	cJSON* jsonmail_order_detail_1 = mail_order_detail_convertToJSON(mail_order_detail_1);
	printf("mail_order_detail :\n%s\n", cJSON_Print(jsonmail_order_detail_1));
	mail_order_detail_t* mail_order_detail_2 = mail_order_detail_parseFromJSON(jsonmail_order_detail_1);
	cJSON* jsonmail_order_detail_2 = mail_order_detail_convertToJSON(mail_order_detail_2);
	printf("repeating mail_order_detail:\n%s\n", cJSON_Print(jsonmail_order_detail_2));
}

int main() {
  test_mail_order_detail(1);
  test_mail_order_detail(0);

  printf("Hello world \n");
  return 0;
}

#endif // mail_order_detail_MAIN
#endif // mail_order_detail_TEST
