#ifndef mail_log_TEST
#define mail_log_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define mail_log_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/mail_log.h"
mail_log_t* instantiate_mail_log(int include_optional);



mail_log_t* instantiate_mail_log(int include_optional) {
  mail_log_t* mail_log = NULL;
  if (include_optional) {
    mail_log = mail_log_create(
      10234,
      0,
      100,
      list_createList()
    );
  } else {
    mail_log = mail_log_create(
      10234,
      0,
      100,
      list_createList()
    );
  }

  return mail_log;
}


#ifdef mail_log_MAIN

void test_mail_log(int include_optional) {
    mail_log_t* mail_log_1 = instantiate_mail_log(include_optional);

	cJSON* jsonmail_log_1 = mail_log_convertToJSON(mail_log_1);
	printf("mail_log :\n%s\n", cJSON_Print(jsonmail_log_1));
	mail_log_t* mail_log_2 = mail_log_parseFromJSON(jsonmail_log_1);
	cJSON* jsonmail_log_2 = mail_log_convertToJSON(mail_log_2);
	printf("repeating mail_log:\n%s\n", cJSON_Print(jsonmail_log_2));
}

int main() {
  test_mail_log(1);
  test_mail_log(0);

  printf("Hello world \n");
  return 0;
}

#endif // mail_log_MAIN
#endif // mail_log_TEST
