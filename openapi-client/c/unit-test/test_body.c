#ifndef body_TEST
#define body_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define body_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/body.h"
body_t* instantiate_body(int include_optional);



body_t* instantiate_body(int include_optional) {
  body_t* body = NULL;
  if (include_optional) {
    body = body_create(
      "johndoe@company.com",
      "johndoe@company.com",
      "Your Package has been Delivered!",
      "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
"
    );
  } else {
    body = body_create(
      "johndoe@company.com",
      "johndoe@company.com",
      "Your Package has been Delivered!",
      "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
"
    );
  }

  return body;
}


#ifdef body_MAIN

void test_body(int include_optional) {
    body_t* body_1 = instantiate_body(include_optional);

	cJSON* jsonbody_1 = body_convertToJSON(body_1);
	printf("body :\n%s\n", cJSON_Print(jsonbody_1));
	body_t* body_2 = body_parseFromJSON(jsonbody_1);
	cJSON* jsonbody_2 = body_convertToJSON(body_2);
	printf("repeating body:\n%s\n", cJSON_Print(jsonbody_2));
}

int main() {
  test_body(1);
  test_body(0);

  printf("Hello world \n");
  return 0;
}

#endif // body_MAIN
#endif // body_TEST
