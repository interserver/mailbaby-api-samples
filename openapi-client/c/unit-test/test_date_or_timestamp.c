#ifndef date_or_timestamp_TEST
#define date_or_timestamp_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define date_or_timestamp_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/date_or_timestamp.h"
date_or_timestamp_t* instantiate_date_or_timestamp(int include_optional);



date_or_timestamp_t* instantiate_date_or_timestamp(int include_optional) {
  date_or_timestamp_t* date_or_timestamp = NULL;
  if (include_optional) {
    date_or_timestamp = date_or_timestamp_create(
    );
  } else {
    date_or_timestamp = date_or_timestamp_create(
    );
  }

  return date_or_timestamp;
}


#ifdef date_or_timestamp_MAIN

void test_date_or_timestamp(int include_optional) {
    date_or_timestamp_t* date_or_timestamp_1 = instantiate_date_or_timestamp(include_optional);

	cJSON* jsondate_or_timestamp_1 = date_or_timestamp_convertToJSON(date_or_timestamp_1);
	printf("date_or_timestamp :\n%s\n", cJSON_Print(jsondate_or_timestamp_1));
	date_or_timestamp_t* date_or_timestamp_2 = date_or_timestamp_parseFromJSON(jsondate_or_timestamp_1);
	cJSON* jsondate_or_timestamp_2 = date_or_timestamp_convertToJSON(date_or_timestamp_2);
	printf("repeating date_or_timestamp:\n%s\n", cJSON_Print(jsondate_or_timestamp_2));
}

int main() {
  test_date_or_timestamp(1);
  test_date_or_timestamp(0);

  printf("Hello world \n");
  return 0;
}

#endif // date_or_timestamp_MAIN
#endif // date_or_timestamp_TEST
