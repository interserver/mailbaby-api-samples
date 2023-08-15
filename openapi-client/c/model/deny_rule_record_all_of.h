/*
 * deny_rule_record_all_of.h
 *
 * 
 */

#ifndef _deny_rule_record_all_of_H_
#define _deny_rule_record_all_of_H_

#include <string.h>
#include "../external/cJSON.h"
#include "../include/list.h"
#include "../include/keyValuePair.h"
#include "../include/binary.h"

typedef struct deny_rule_record_all_of_t deny_rule_record_all_of_t;




typedef struct deny_rule_record_all_of_t {
    int id; //numeric
    char *created; //date time

} deny_rule_record_all_of_t;

deny_rule_record_all_of_t *deny_rule_record_all_of_create(
    int id,
    char *created
);

void deny_rule_record_all_of_free(deny_rule_record_all_of_t *deny_rule_record_all_of);

deny_rule_record_all_of_t *deny_rule_record_all_of_parseFromJSON(cJSON *deny_rule_record_all_ofJSON);

cJSON *deny_rule_record_all_of_convertToJSON(deny_rule_record_all_of_t *deny_rule_record_all_of);

#endif /* _deny_rule_record_all_of_H_ */

