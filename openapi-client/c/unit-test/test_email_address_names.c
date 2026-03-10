#ifndef email_address_names_TEST
#define email_address_names_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define email_address_names_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/email_address_names.h"
email_address_names_t* instantiate_email_address_names(int include_optional);



email_address_names_t* instantiate_email_address_names(int include_optional) {
  email_address_names_t* email_address_names = NULL;
  if (include_optional) {
    email_address_names = email_address_names_create(
    );
  } else {
    email_address_names = email_address_names_create(
    );
  }

  return email_address_names;
}


#ifdef email_address_names_MAIN

void test_email_address_names(int include_optional) {
    email_address_names_t* email_address_names_1 = instantiate_email_address_names(include_optional);

	cJSON* jsonemail_address_names_1 = email_address_names_convertToJSON(email_address_names_1);
	printf("email_address_names :\n%s\n", cJSON_Print(jsonemail_address_names_1));
	email_address_names_t* email_address_names_2 = email_address_names_parseFromJSON(jsonemail_address_names_1);
	cJSON* jsonemail_address_names_2 = email_address_names_convertToJSON(email_address_names_2);
	printf("repeating email_address_names:\n%s\n", cJSON_Print(jsonemail_address_names_2));
}

int main() {
  test_email_address_names(1);
  test_email_address_names(0);

  printf("Hello world \n");
  return 0;
}

#endif // email_address_names_MAIN
#endif // email_address_names_TEST
