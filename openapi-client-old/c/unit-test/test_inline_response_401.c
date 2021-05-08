#ifndef inline_response_401_TEST
#define inline_response_401_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define inline_response_401_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/inline_response_401.h"
inline_response_401_t* instantiate_inline_response_401(int include_optional);



inline_response_401_t* instantiate_inline_response_401(int include_optional) {
  inline_response_401_t* inline_response_401 = NULL;
  if (include_optional) {
    inline_response_401 = inline_response_401_create(
      "0",
      "0"
    );
  } else {
    inline_response_401 = inline_response_401_create(
      "0",
      "0"
    );
  }

  return inline_response_401;
}


#ifdef inline_response_401_MAIN

void test_inline_response_401(int include_optional) {
    inline_response_401_t* inline_response_401_1 = instantiate_inline_response_401(include_optional);

	cJSON* jsoninline_response_401_1 = inline_response_401_convertToJSON(inline_response_401_1);
	printf("inline_response_401 :\n%s\n", cJSON_Print(jsoninline_response_401_1));
	inline_response_401_t* inline_response_401_2 = inline_response_401_parseFromJSON(jsoninline_response_401_1);
	cJSON* jsoninline_response_401_2 = inline_response_401_convertToJSON(inline_response_401_2);
	printf("repeating inline_response_401:\n%s\n", cJSON_Print(jsoninline_response_401_2));
}

int main() {
  test_inline_response_401(1);
  test_inline_response_401(0);

  printf("Hello world \n");
  return 0;
}

#endif // inline_response_401_MAIN
#endif // inline_response_401_TEST
