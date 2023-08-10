#ifndef get_stats_200_response_inner_TEST
#define get_stats_200_response_inner_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define get_stats_200_response_inner_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/get_stats_200_response_inner.h"
get_stats_200_response_inner_t* instantiate_get_stats_200_response_inner(int include_optional);



get_stats_200_response_inner_t* instantiate_get_stats_200_response_inner(int include_optional) {
  get_stats_200_response_inner_t* get_stats_200_response_inner = NULL;
  if (include_optional) {
    get_stats_200_response_inner = get_stats_200_response_inner_create(
      1234,
      "active",
      "mb1234",
      "guest123",
      "main mail account"
    );
  } else {
    get_stats_200_response_inner = get_stats_200_response_inner_create(
      1234,
      "active",
      "mb1234",
      "guest123",
      "main mail account"
    );
  }

  return get_stats_200_response_inner;
}


#ifdef get_stats_200_response_inner_MAIN

void test_get_stats_200_response_inner(int include_optional) {
    get_stats_200_response_inner_t* get_stats_200_response_inner_1 = instantiate_get_stats_200_response_inner(include_optional);

	cJSON* jsonget_stats_200_response_inner_1 = get_stats_200_response_inner_convertToJSON(get_stats_200_response_inner_1);
	printf("get_stats_200_response_inner :\n%s\n", cJSON_Print(jsonget_stats_200_response_inner_1));
	get_stats_200_response_inner_t* get_stats_200_response_inner_2 = get_stats_200_response_inner_parseFromJSON(jsonget_stats_200_response_inner_1);
	cJSON* jsonget_stats_200_response_inner_2 = get_stats_200_response_inner_convertToJSON(get_stats_200_response_inner_2);
	printf("repeating get_stats_200_response_inner:\n%s\n", cJSON_Print(jsonget_stats_200_response_inner_2));
}

int main() {
  test_get_stats_200_response_inner(1);
  test_get_stats_200_response_inner(0);

  printf("Hello world \n");
  return 0;
}

#endif // get_stats_200_response_inner_MAIN
#endif // get_stats_200_response_inner_TEST
