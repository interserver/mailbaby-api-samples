#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "mail_log_entry.h"



mail_log_entry_t *mail_log_entry_create(
    int _id,
    char *id,
    char *from,
    char *to,
    char *subject,
    char *message_id,
    char *created,
    int time,
    char *user,
    char *transtype,
    char *transhost,
    char *originhost,
    char *origin,
    char *interface,
    char *date,
    char *sending_zone,
    int body_size,
    char *source_md5,
    int seq,
    char *domain,
    char *recipient,
    int locked,
    int lock_time,
    char *assigned,
    char *queued,
    char *_lock,
    char *logger,
    int mx_port,
    char *connection_key,
    char *mx_hostname,
    char *sent_body_hash,
    int sent_body_size,
    int md5_match
    ) {
    mail_log_entry_t *mail_log_entry_local_var = malloc(sizeof(mail_log_entry_t));
    if (!mail_log_entry_local_var) {
        return NULL;
    }
    mail_log_entry_local_var->_id = _id;
    mail_log_entry_local_var->id = id;
    mail_log_entry_local_var->from = from;
    mail_log_entry_local_var->to = to;
    mail_log_entry_local_var->subject = subject;
    mail_log_entry_local_var->message_id = message_id;
    mail_log_entry_local_var->created = created;
    mail_log_entry_local_var->time = time;
    mail_log_entry_local_var->user = user;
    mail_log_entry_local_var->transtype = transtype;
    mail_log_entry_local_var->transhost = transhost;
    mail_log_entry_local_var->originhost = originhost;
    mail_log_entry_local_var->origin = origin;
    mail_log_entry_local_var->interface = interface;
    mail_log_entry_local_var->date = date;
    mail_log_entry_local_var->sending_zone = sending_zone;
    mail_log_entry_local_var->body_size = body_size;
    mail_log_entry_local_var->source_md5 = source_md5;
    mail_log_entry_local_var->seq = seq;
    mail_log_entry_local_var->domain = domain;
    mail_log_entry_local_var->recipient = recipient;
    mail_log_entry_local_var->locked = locked;
    mail_log_entry_local_var->lock_time = lock_time;
    mail_log_entry_local_var->assigned = assigned;
    mail_log_entry_local_var->queued = queued;
    mail_log_entry_local_var->_lock = _lock;
    mail_log_entry_local_var->logger = logger;
    mail_log_entry_local_var->mx_port = mx_port;
    mail_log_entry_local_var->connection_key = connection_key;
    mail_log_entry_local_var->mx_hostname = mx_hostname;
    mail_log_entry_local_var->sent_body_hash = sent_body_hash;
    mail_log_entry_local_var->sent_body_size = sent_body_size;
    mail_log_entry_local_var->md5_match = md5_match;

    return mail_log_entry_local_var;
}


void mail_log_entry_free(mail_log_entry_t *mail_log_entry) {
    if(NULL == mail_log_entry){
        return ;
    }
    listEntry_t *listEntry;
    if (mail_log_entry->id) {
        free(mail_log_entry->id);
        mail_log_entry->id = NULL;
    }
    if (mail_log_entry->from) {
        free(mail_log_entry->from);
        mail_log_entry->from = NULL;
    }
    if (mail_log_entry->to) {
        free(mail_log_entry->to);
        mail_log_entry->to = NULL;
    }
    if (mail_log_entry->subject) {
        free(mail_log_entry->subject);
        mail_log_entry->subject = NULL;
    }
    if (mail_log_entry->message_id) {
        free(mail_log_entry->message_id);
        mail_log_entry->message_id = NULL;
    }
    if (mail_log_entry->created) {
        free(mail_log_entry->created);
        mail_log_entry->created = NULL;
    }
    if (mail_log_entry->user) {
        free(mail_log_entry->user);
        mail_log_entry->user = NULL;
    }
    if (mail_log_entry->transtype) {
        free(mail_log_entry->transtype);
        mail_log_entry->transtype = NULL;
    }
    if (mail_log_entry->transhost) {
        free(mail_log_entry->transhost);
        mail_log_entry->transhost = NULL;
    }
    if (mail_log_entry->originhost) {
        free(mail_log_entry->originhost);
        mail_log_entry->originhost = NULL;
    }
    if (mail_log_entry->origin) {
        free(mail_log_entry->origin);
        mail_log_entry->origin = NULL;
    }
    if (mail_log_entry->interface) {
        free(mail_log_entry->interface);
        mail_log_entry->interface = NULL;
    }
    if (mail_log_entry->date) {
        free(mail_log_entry->date);
        mail_log_entry->date = NULL;
    }
    if (mail_log_entry->sending_zone) {
        free(mail_log_entry->sending_zone);
        mail_log_entry->sending_zone = NULL;
    }
    if (mail_log_entry->source_md5) {
        free(mail_log_entry->source_md5);
        mail_log_entry->source_md5 = NULL;
    }
    if (mail_log_entry->domain) {
        free(mail_log_entry->domain);
        mail_log_entry->domain = NULL;
    }
    if (mail_log_entry->recipient) {
        free(mail_log_entry->recipient);
        mail_log_entry->recipient = NULL;
    }
    if (mail_log_entry->assigned) {
        free(mail_log_entry->assigned);
        mail_log_entry->assigned = NULL;
    }
    if (mail_log_entry->queued) {
        free(mail_log_entry->queued);
        mail_log_entry->queued = NULL;
    }
    if (mail_log_entry->_lock) {
        free(mail_log_entry->_lock);
        mail_log_entry->_lock = NULL;
    }
    if (mail_log_entry->logger) {
        free(mail_log_entry->logger);
        mail_log_entry->logger = NULL;
    }
    if (mail_log_entry->connection_key) {
        free(mail_log_entry->connection_key);
        mail_log_entry->connection_key = NULL;
    }
    if (mail_log_entry->mx_hostname) {
        free(mail_log_entry->mx_hostname);
        mail_log_entry->mx_hostname = NULL;
    }
    if (mail_log_entry->sent_body_hash) {
        free(mail_log_entry->sent_body_hash);
        mail_log_entry->sent_body_hash = NULL;
    }
    free(mail_log_entry);
}

cJSON *mail_log_entry_convertToJSON(mail_log_entry_t *mail_log_entry) {
    cJSON *item = cJSON_CreateObject();

    // mail_log_entry->_id
    if (!mail_log_entry->_id) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "_id", mail_log_entry->_id) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->id
    if (!mail_log_entry->id) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "id", mail_log_entry->id) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->from
    if (!mail_log_entry->from) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "from", mail_log_entry->from) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->to
    if (!mail_log_entry->to) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "to", mail_log_entry->to) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->subject
    if (!mail_log_entry->subject) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "subject", mail_log_entry->subject) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->message_id
    if (!mail_log_entry->message_id) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "messageId", mail_log_entry->message_id) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->created
    if (!mail_log_entry->created) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "created", mail_log_entry->created) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->time
    if (!mail_log_entry->time) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "time", mail_log_entry->time) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->user
    if (!mail_log_entry->user) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "user", mail_log_entry->user) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->transtype
    if (!mail_log_entry->transtype) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "transtype", mail_log_entry->transtype) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->transhost
    if (!mail_log_entry->transhost) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "transhost", mail_log_entry->transhost) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->originhost
    if (!mail_log_entry->originhost) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "originhost", mail_log_entry->originhost) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->origin
    if (!mail_log_entry->origin) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "origin", mail_log_entry->origin) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->interface
    if (!mail_log_entry->interface) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "interface", mail_log_entry->interface) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->date
    if (!mail_log_entry->date) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "date", mail_log_entry->date) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->sending_zone
    if (!mail_log_entry->sending_zone) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "sendingZone", mail_log_entry->sending_zone) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->body_size
    if (!mail_log_entry->body_size) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "bodySize", mail_log_entry->body_size) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->source_md5
    if (!mail_log_entry->source_md5) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "sourceMd5", mail_log_entry->source_md5) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->seq
    if (!mail_log_entry->seq) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "seq", mail_log_entry->seq) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->domain
    if (!mail_log_entry->domain) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "domain", mail_log_entry->domain) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->recipient
    if (!mail_log_entry->recipient) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "recipient", mail_log_entry->recipient) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->locked
    if (!mail_log_entry->locked) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "locked", mail_log_entry->locked) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->lock_time
    if (!mail_log_entry->lock_time) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "lockTime", mail_log_entry->lock_time) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->assigned
    if (!mail_log_entry->assigned) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "assigned", mail_log_entry->assigned) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->queued
    if (!mail_log_entry->queued) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "queued", mail_log_entry->queued) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->_lock
    if (!mail_log_entry->_lock) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "_lock", mail_log_entry->_lock) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->logger
    if (!mail_log_entry->logger) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "logger", mail_log_entry->logger) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->mx_port
    if (!mail_log_entry->mx_port) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "mxPort", mail_log_entry->mx_port) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->connection_key
    if (!mail_log_entry->connection_key) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "connectionKey", mail_log_entry->connection_key) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->mx_hostname
    if (!mail_log_entry->mx_hostname) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "mxHostname", mail_log_entry->mx_hostname) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->sent_body_hash
    if (!mail_log_entry->sent_body_hash) {
        goto fail;
    }
    if(cJSON_AddStringToObject(item, "sentBodyHash", mail_log_entry->sent_body_hash) == NULL) {
    goto fail; //String
    }


    // mail_log_entry->sent_body_size
    if (!mail_log_entry->sent_body_size) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "sentBodySize", mail_log_entry->sent_body_size) == NULL) {
    goto fail; //Numeric
    }


    // mail_log_entry->md5_match
    if (!mail_log_entry->md5_match) {
        goto fail;
    }
    if(cJSON_AddNumberToObject(item, "md5Match", mail_log_entry->md5_match) == NULL) {
    goto fail; //Numeric
    }

    return item;
fail:
    if (item) {
        cJSON_Delete(item);
    }
    return NULL;
}

mail_log_entry_t *mail_log_entry_parseFromJSON(cJSON *mail_log_entryJSON){

    mail_log_entry_t *mail_log_entry_local_var = NULL;

    // mail_log_entry->_id
    cJSON *_id = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "_id");
    if (!_id) {
        goto end;
    }

    
    if(!cJSON_IsNumber(_id))
    {
    goto end; //Numeric
    }

    // mail_log_entry->id
    cJSON *id = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "id");
    if (!id) {
        goto end;
    }

    
    if(!cJSON_IsString(id))
    {
    goto end; //String
    }

    // mail_log_entry->from
    cJSON *from = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "from");
    if (!from) {
        goto end;
    }

    
    if(!cJSON_IsString(from))
    {
    goto end; //String
    }

    // mail_log_entry->to
    cJSON *to = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "to");
    if (!to) {
        goto end;
    }

    
    if(!cJSON_IsString(to))
    {
    goto end; //String
    }

    // mail_log_entry->subject
    cJSON *subject = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "subject");
    if (!subject) {
        goto end;
    }

    
    if(!cJSON_IsString(subject))
    {
    goto end; //String
    }

    // mail_log_entry->message_id
    cJSON *message_id = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "messageId");
    if (!message_id) {
        goto end;
    }

    
    if(!cJSON_IsString(message_id))
    {
    goto end; //String
    }

    // mail_log_entry->created
    cJSON *created = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "created");
    if (!created) {
        goto end;
    }

    
    if(!cJSON_IsString(created))
    {
    goto end; //String
    }

    // mail_log_entry->time
    cJSON *time = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "time");
    if (!time) {
        goto end;
    }

    
    if(!cJSON_IsNumber(time))
    {
    goto end; //Numeric
    }

    // mail_log_entry->user
    cJSON *user = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "user");
    if (!user) {
        goto end;
    }

    
    if(!cJSON_IsString(user))
    {
    goto end; //String
    }

    // mail_log_entry->transtype
    cJSON *transtype = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "transtype");
    if (!transtype) {
        goto end;
    }

    
    if(!cJSON_IsString(transtype))
    {
    goto end; //String
    }

    // mail_log_entry->transhost
    cJSON *transhost = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "transhost");
    if (!transhost) {
        goto end;
    }

    
    if(!cJSON_IsString(transhost))
    {
    goto end; //String
    }

    // mail_log_entry->originhost
    cJSON *originhost = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "originhost");
    if (!originhost) {
        goto end;
    }

    
    if(!cJSON_IsString(originhost))
    {
    goto end; //String
    }

    // mail_log_entry->origin
    cJSON *origin = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "origin");
    if (!origin) {
        goto end;
    }

    
    if(!cJSON_IsString(origin))
    {
    goto end; //String
    }

    // mail_log_entry->interface
    cJSON *interface = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "interface");
    if (!interface) {
        goto end;
    }

    
    if(!cJSON_IsString(interface))
    {
    goto end; //String
    }

    // mail_log_entry->date
    cJSON *date = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "date");
    if (!date) {
        goto end;
    }

    
    if(!cJSON_IsString(date))
    {
    goto end; //String
    }

    // mail_log_entry->sending_zone
    cJSON *sending_zone = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "sendingZone");
    if (!sending_zone) {
        goto end;
    }

    
    if(!cJSON_IsString(sending_zone))
    {
    goto end; //String
    }

    // mail_log_entry->body_size
    cJSON *body_size = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "bodySize");
    if (!body_size) {
        goto end;
    }

    
    if(!cJSON_IsNumber(body_size))
    {
    goto end; //Numeric
    }

    // mail_log_entry->source_md5
    cJSON *source_md5 = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "sourceMd5");
    if (!source_md5) {
        goto end;
    }

    
    if(!cJSON_IsString(source_md5))
    {
    goto end; //String
    }

    // mail_log_entry->seq
    cJSON *seq = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "seq");
    if (!seq) {
        goto end;
    }

    
    if(!cJSON_IsNumber(seq))
    {
    goto end; //Numeric
    }

    // mail_log_entry->domain
    cJSON *domain = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "domain");
    if (!domain) {
        goto end;
    }

    
    if(!cJSON_IsString(domain))
    {
    goto end; //String
    }

    // mail_log_entry->recipient
    cJSON *recipient = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "recipient");
    if (!recipient) {
        goto end;
    }

    
    if(!cJSON_IsString(recipient))
    {
    goto end; //String
    }

    // mail_log_entry->locked
    cJSON *locked = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "locked");
    if (!locked) {
        goto end;
    }

    
    if(!cJSON_IsNumber(locked))
    {
    goto end; //Numeric
    }

    // mail_log_entry->lock_time
    cJSON *lock_time = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "lockTime");
    if (!lock_time) {
        goto end;
    }

    
    if(!cJSON_IsNumber(lock_time))
    {
    goto end; //Numeric
    }

    // mail_log_entry->assigned
    cJSON *assigned = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "assigned");
    if (!assigned) {
        goto end;
    }

    
    if(!cJSON_IsString(assigned))
    {
    goto end; //String
    }

    // mail_log_entry->queued
    cJSON *queued = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "queued");
    if (!queued) {
        goto end;
    }

    
    if(!cJSON_IsString(queued))
    {
    goto end; //String
    }

    // mail_log_entry->_lock
    cJSON *_lock = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "_lock");
    if (!_lock) {
        goto end;
    }

    
    if(!cJSON_IsString(_lock))
    {
    goto end; //String
    }

    // mail_log_entry->logger
    cJSON *logger = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "logger");
    if (!logger) {
        goto end;
    }

    
    if(!cJSON_IsString(logger))
    {
    goto end; //String
    }

    // mail_log_entry->mx_port
    cJSON *mx_port = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "mxPort");
    if (!mx_port) {
        goto end;
    }

    
    if(!cJSON_IsNumber(mx_port))
    {
    goto end; //Numeric
    }

    // mail_log_entry->connection_key
    cJSON *connection_key = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "connectionKey");
    if (!connection_key) {
        goto end;
    }

    
    if(!cJSON_IsString(connection_key))
    {
    goto end; //String
    }

    // mail_log_entry->mx_hostname
    cJSON *mx_hostname = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "mxHostname");
    if (!mx_hostname) {
        goto end;
    }

    
    if(!cJSON_IsString(mx_hostname))
    {
    goto end; //String
    }

    // mail_log_entry->sent_body_hash
    cJSON *sent_body_hash = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "sentBodyHash");
    if (!sent_body_hash) {
        goto end;
    }

    
    if(!cJSON_IsString(sent_body_hash))
    {
    goto end; //String
    }

    // mail_log_entry->sent_body_size
    cJSON *sent_body_size = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "sentBodySize");
    if (!sent_body_size) {
        goto end;
    }

    
    if(!cJSON_IsNumber(sent_body_size))
    {
    goto end; //Numeric
    }

    // mail_log_entry->md5_match
    cJSON *md5_match = cJSON_GetObjectItemCaseSensitive(mail_log_entryJSON, "md5Match");
    if (!md5_match) {
        goto end;
    }

    
    if(!cJSON_IsNumber(md5_match))
    {
    goto end; //Numeric
    }


    mail_log_entry_local_var = mail_log_entry_create (
        _id->valuedouble,
        strdup(id->valuestring),
        strdup(from->valuestring),
        strdup(to->valuestring),
        strdup(subject->valuestring),
        strdup(message_id->valuestring),
        strdup(created->valuestring),
        time->valuedouble,
        strdup(user->valuestring),
        strdup(transtype->valuestring),
        strdup(transhost->valuestring),
        strdup(originhost->valuestring),
        strdup(origin->valuestring),
        strdup(interface->valuestring),
        strdup(date->valuestring),
        strdup(sending_zone->valuestring),
        body_size->valuedouble,
        strdup(source_md5->valuestring),
        seq->valuedouble,
        strdup(domain->valuestring),
        strdup(recipient->valuestring),
        locked->valuedouble,
        lock_time->valuedouble,
        strdup(assigned->valuestring),
        strdup(queued->valuestring),
        strdup(_lock->valuestring),
        strdup(logger->valuestring),
        mx_port->valuedouble,
        strdup(connection_key->valuestring),
        strdup(mx_hostname->valuestring),
        strdup(sent_body_hash->valuestring),
        sent_body_size->valuedouble,
        md5_match->valuedouble
        );

    return mail_log_entry_local_var;
end:
    return NULL;

}
