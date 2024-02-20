#ifndef error_message_TEST
#define error_message_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define error_message_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/error_message.h"
error_message_t* instantiate_error_message(int include_optional);



error_message_t* instantiate_error_message(int include_optional) {
  error_message_t* error_message = NULL;
  if (include_optional) {
    error_message = error_message_create(
      400,
      "There was an error."
    );
  } else {
    error_message = error_message_create(
      400,
      "There was an error."
    );
  }

  return error_message;
}


#ifdef error_message_MAIN

void test_error_message(int include_optional) {
    error_message_t* error_message_1 = instantiate_error_message(include_optional);

	cJSON* jsonerror_message_1 = error_message_convertToJSON(error_message_1);
	printf("error_message :\n%s\n", cJSON_Print(jsonerror_message_1));
	error_message_t* error_message_2 = error_message_parseFromJSON(jsonerror_message_1);
	cJSON* jsonerror_message_2 = error_message_convertToJSON(error_message_2);
	printf("repeating error_message:\n%s\n", cJSON_Print(jsonerror_message_2));
}

int main() {
  test_error_message(1);
  test_error_message(0);

  printf("Hello world \n");
  return 0;
}

#endif // error_message_MAIN
#endif // error_message_TEST
