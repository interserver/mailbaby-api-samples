#ifndef mail_contact_TEST
#define mail_contact_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define mail_contact_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/mail_contact.h"
mail_contact_t* instantiate_mail_contact(int include_optional);



mail_contact_t* instantiate_mail_contact(int include_optional) {
  mail_contact_t* mail_contact = NULL;
  if (include_optional) {
    mail_contact = mail_contact_create(
      "johndoe@company.com",
      "John Doe"
    );
  } else {
    mail_contact = mail_contact_create(
      "johndoe@company.com",
      "John Doe"
    );
  }

  return mail_contact;
}


#ifdef mail_contact_MAIN

void test_mail_contact(int include_optional) {
    mail_contact_t* mail_contact_1 = instantiate_mail_contact(include_optional);

	cJSON* jsonmail_contact_1 = mail_contact_convertToJSON(mail_contact_1);
	printf("mail_contact :\n%s\n", cJSON_Print(jsonmail_contact_1));
	mail_contact_t* mail_contact_2 = mail_contact_parseFromJSON(jsonmail_contact_1);
	cJSON* jsonmail_contact_2 = mail_contact_convertToJSON(mail_contact_2);
	printf("repeating mail_contact:\n%s\n", cJSON_Print(jsonmail_contact_2));
}

int main() {
  test_mail_contact(1);
  test_mail_contact(0);

  printf("Hello world \n");
  return 0;
}

#endif // mail_contact_MAIN
#endif // mail_contact_TEST
