#ifndef email_addresses_types_TEST
#define email_addresses_types_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define email_addresses_types_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/email_addresses_types.h"
email_addresses_types_t* instantiate_email_addresses_types(int include_optional);



email_addresses_types_t* instantiate_email_addresses_types(int include_optional) {
  email_addresses_types_t* email_addresses_types = NULL;
  if (include_optional) {
    email_addresses_types = email_addresses_types_create(
    );
  } else {
    email_addresses_types = email_addresses_types_create(
    );
  }

  return email_addresses_types;
}


#ifdef email_addresses_types_MAIN

void test_email_addresses_types(int include_optional) {
    email_addresses_types_t* email_addresses_types_1 = instantiate_email_addresses_types(include_optional);

	cJSON* jsonemail_addresses_types_1 = email_addresses_types_convertToJSON(email_addresses_types_1);
	printf("email_addresses_types :\n%s\n", cJSON_Print(jsonemail_addresses_types_1));
	email_addresses_types_t* email_addresses_types_2 = email_addresses_types_parseFromJSON(jsonemail_addresses_types_1);
	cJSON* jsonemail_addresses_types_2 = email_addresses_types_convertToJSON(email_addresses_types_2);
	printf("repeating email_addresses_types:\n%s\n", cJSON_Print(jsonemail_addresses_types_2));
}

int main() {
  test_email_addresses_types(1);
  test_email_addresses_types(0);

  printf("Hello world \n");
  return 0;
}

#endif // email_addresses_types_MAIN
#endif // email_addresses_types_TEST
