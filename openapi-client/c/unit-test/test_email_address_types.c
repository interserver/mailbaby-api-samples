#ifndef email_address_types_TEST
#define email_address_types_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define email_address_types_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/email_address_types.h"
email_address_types_t* instantiate_email_address_types(int include_optional);



email_address_types_t* instantiate_email_address_types(int include_optional) {
  email_address_types_t* email_address_types = NULL;
  if (include_optional) {
    email_address_types = email_address_types_create(
      "user@domain.com",
      "John Smith"
    );
  } else {
    email_address_types = email_address_types_create(
      "user@domain.com",
      "John Smith"
    );
  }

  return email_address_types;
}


#ifdef email_address_types_MAIN

void test_email_address_types(int include_optional) {
    email_address_types_t* email_address_types_1 = instantiate_email_address_types(include_optional);

	cJSON* jsonemail_address_types_1 = email_address_types_convertToJSON(email_address_types_1);
	printf("email_address_types :\n%s\n", cJSON_Print(jsonemail_address_types_1));
	email_address_types_t* email_address_types_2 = email_address_types_parseFromJSON(jsonemail_address_types_1);
	cJSON* jsonemail_address_types_2 = email_address_types_convertToJSON(email_address_types_2);
	printf("repeating email_address_types:\n%s\n", cJSON_Print(jsonemail_address_types_2));
}

int main() {
  test_email_address_types(1);
  test_email_address_types(0);

  printf("Hello world \n");
  return 0;
}

#endif // email_address_types_MAIN
#endif // email_address_types_TEST
