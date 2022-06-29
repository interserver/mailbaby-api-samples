#ifndef get_mail_orders_401_response_TEST
#define get_mail_orders_401_response_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define get_mail_orders_401_response_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/get_mail_orders_401_response.h"
get_mail_orders_401_response_t* instantiate_get_mail_orders_401_response(int include_optional);



get_mail_orders_401_response_t* instantiate_get_mail_orders_401_response(int include_optional) {
  get_mail_orders_401_response_t* get_mail_orders_401_response = NULL;
  if (include_optional) {
    get_mail_orders_401_response = get_mail_orders_401_response_create(
      "0",
      "0"
    );
  } else {
    get_mail_orders_401_response = get_mail_orders_401_response_create(
      "0",
      "0"
    );
  }

  return get_mail_orders_401_response;
}


#ifdef get_mail_orders_401_response_MAIN

void test_get_mail_orders_401_response(int include_optional) {
    get_mail_orders_401_response_t* get_mail_orders_401_response_1 = instantiate_get_mail_orders_401_response(include_optional);

	cJSON* jsonget_mail_orders_401_response_1 = get_mail_orders_401_response_convertToJSON(get_mail_orders_401_response_1);
	printf("get_mail_orders_401_response :\n%s\n", cJSON_Print(jsonget_mail_orders_401_response_1));
	get_mail_orders_401_response_t* get_mail_orders_401_response_2 = get_mail_orders_401_response_parseFromJSON(jsonget_mail_orders_401_response_1);
	cJSON* jsonget_mail_orders_401_response_2 = get_mail_orders_401_response_convertToJSON(get_mail_orders_401_response_2);
	printf("repeating get_mail_orders_401_response:\n%s\n", cJSON_Print(jsonget_mail_orders_401_response_2));
}

int main() {
  test_get_mail_orders_401_response(1);
  test_get_mail_orders_401_response(0);

  printf("Hello world \n");
  return 0;
}

#endif // get_mail_orders_401_response_MAIN
#endif // get_mail_orders_401_response_TEST
