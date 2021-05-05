#ifndef body_1_TEST
#define body_1_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define body_1_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/body_1.h"
body_1_t* instantiate_body_1(int include_optional);



body_1_t* instantiate_body_1(int include_optional) {
  body_1_t* body_1 = NULL;
  if (include_optional) {
    body_1 = body_1_create(
      "johndoe@company.com",
      "johndoe@company.com",
      "Your Package has been Delivered!",
      "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
"
    );
  } else {
    body_1 = body_1_create(
      "johndoe@company.com",
      "johndoe@company.com",
      "Your Package has been Delivered!",
      "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
"
    );
  }

  return body_1;
}


#ifdef body_1_MAIN

void test_body_1(int include_optional) {
    body_1_t* body_1_1 = instantiate_body_1(include_optional);

	cJSON* jsonbody_1_1 = body_1_convertToJSON(body_1_1);
	printf("body_1 :\n%s\n", cJSON_Print(jsonbody_1_1));
	body_1_t* body_1_2 = body_1_parseFromJSON(jsonbody_1_1);
	cJSON* jsonbody_1_2 = body_1_convertToJSON(body_1_2);
	printf("repeating body_1:\n%s\n", cJSON_Print(jsonbody_1_2));
}

int main() {
  test_body_1(1);
  test_body_1(0);

  printf("Hello world \n");
  return 0;
}

#endif // body_1_MAIN
#endif // body_1_TEST
