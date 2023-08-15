#ifndef deny_rule_record_all_of_TEST
#define deny_rule_record_all_of_TEST

// the following is to include only the main from the first c file
#ifndef TEST_MAIN
#define TEST_MAIN
#define deny_rule_record_all_of_MAIN
#endif // TEST_MAIN

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include "../external/cJSON.h"

#include "../model/deny_rule_record_all_of.h"
deny_rule_record_all_of_t* instantiate_deny_rule_record_all_of(int include_optional);



deny_rule_record_all_of_t* instantiate_deny_rule_record_all_of(int include_optional) {
  deny_rule_record_all_of_t* deny_rule_record_all_of = NULL;
  if (include_optional) {
    deny_rule_record_all_of = deny_rule_record_all_of_create(
      41124,
      "2013-10-20T19:20:30+01:00"
    );
  } else {
    deny_rule_record_all_of = deny_rule_record_all_of_create(
      41124,
      "2013-10-20T19:20:30+01:00"
    );
  }

  return deny_rule_record_all_of;
}


#ifdef deny_rule_record_all_of_MAIN

void test_deny_rule_record_all_of(int include_optional) {
    deny_rule_record_all_of_t* deny_rule_record_all_of_1 = instantiate_deny_rule_record_all_of(include_optional);

	cJSON* jsondeny_rule_record_all_of_1 = deny_rule_record_all_of_convertToJSON(deny_rule_record_all_of_1);
	printf("deny_rule_record_all_of :\n%s\n", cJSON_Print(jsondeny_rule_record_all_of_1));
	deny_rule_record_all_of_t* deny_rule_record_all_of_2 = deny_rule_record_all_of_parseFromJSON(jsondeny_rule_record_all_of_1);
	cJSON* jsondeny_rule_record_all_of_2 = deny_rule_record_all_of_convertToJSON(deny_rule_record_all_of_2);
	printf("repeating deny_rule_record_all_of:\n%s\n", cJSON_Print(jsondeny_rule_record_all_of_2));
}

int main() {
  test_deny_rule_record_all_of(1);
  test_deny_rule_record_all_of(0);

  printf("Hello world \n");
  return 0;
}

#endif // deny_rule_record_all_of_MAIN
#endif // deny_rule_record_all_of_TEST
