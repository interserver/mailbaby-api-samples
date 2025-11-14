#ifndef raw_mail_TEST
#define raw_mail_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define raw_mail_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/raw_mail.h"
raw_mail_t* instantiate_raw_mail(int include_optional);



raw_mail_t* instantiate_raw_mail(int include_optional) {
  raw_mail_t* raw_mail = NULL;
  if (include_optional) {
    raw_mail = raw_mail_create(
      "0"
    );
  } else {
    raw_mail = raw_mail_create(
      "0"
    );
  }

  return raw_mail;
}


#ifdef raw_mail_MAIN

void test_raw_mail(int include_optional) {
    raw_mail_t* raw_mail_1 = instantiate_raw_mail(include_optional);

	cJSON* jsonraw_mail_1 = raw_mail_convertToJSON(raw_mail_1);
	printf("raw_mail :\n%s\n", cJSON_Print(jsonraw_mail_1));
	raw_mail_t* raw_mail_2 = raw_mail_parseFromJSON(jsonraw_mail_1);
	cJSON* jsonraw_mail_2 = raw_mail_convertToJSON(raw_mail_2);
	printf("repeating raw_mail:\n%s\n", cJSON_Print(jsonraw_mail_2));
}

int main() {
  test_raw_mail(1);
  test_raw_mail(0);

  printf("Hello world \n");
  return 0;
}

#endif // raw_mail_MAIN
#endif // raw_mail_TEST
