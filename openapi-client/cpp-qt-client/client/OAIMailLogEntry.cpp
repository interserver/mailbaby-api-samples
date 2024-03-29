/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

#include "OAIMailLogEntry.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAIMailLogEntry::OAIMailLogEntry(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAIMailLogEntry::OAIMailLogEntry() {
    this->initializeModel();
}

OAIMailLogEntry::~OAIMailLogEntry() {}

void OAIMailLogEntry::initializeModel() {

    m__id_isSet = false;
    m__id_isValid = false;

    m_id_isSet = false;
    m_id_isValid = false;

    m_from_isSet = false;
    m_from_isValid = false;

    m_to_isSet = false;
    m_to_isValid = false;

    m_subject_isSet = false;
    m_subject_isValid = false;

    m_created_isSet = false;
    m_created_isValid = false;

    m_time_isSet = false;
    m_time_isValid = false;

    m_user_isSet = false;
    m_user_isValid = false;

    m_transtype_isSet = false;
    m_transtype_isValid = false;

    m_origin_isSet = false;
    m_origin_isValid = false;

    m_interface_isSet = false;
    m_interface_isValid = false;

    m_sending_zone_isSet = false;
    m_sending_zone_isValid = false;

    m_body_size_isSet = false;
    m_body_size_isValid = false;

    m_seq_isSet = false;
    m_seq_isValid = false;

    m_recipient_isSet = false;
    m_recipient_isValid = false;

    m_domain_isSet = false;
    m_domain_isValid = false;

    m_locked_isSet = false;
    m_locked_isValid = false;

    m_lock_time_isSet = false;
    m_lock_time_isValid = false;

    m_assigned_isSet = false;
    m_assigned_isValid = false;

    m_queued_isSet = false;
    m_queued_isValid = false;

    m_mx_hostname_isSet = false;
    m_mx_hostname_isValid = false;

    m_response_isSet = false;
    m_response_isValid = false;

    m_message_id_isSet = false;
    m_message_id_isValid = false;
}

void OAIMailLogEntry::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAIMailLogEntry::fromJsonObject(QJsonObject json) {

    m__id_isValid = ::OpenAPI::fromJsonValue(m__id, json[QString("_id")]);
    m__id_isSet = !json[QString("_id")].isNull() && m__id_isValid;

    m_id_isValid = ::OpenAPI::fromJsonValue(m_id, json[QString("id")]);
    m_id_isSet = !json[QString("id")].isNull() && m_id_isValid;

    m_from_isValid = ::OpenAPI::fromJsonValue(m_from, json[QString("from")]);
    m_from_isSet = !json[QString("from")].isNull() && m_from_isValid;

    m_to_isValid = ::OpenAPI::fromJsonValue(m_to, json[QString("to")]);
    m_to_isSet = !json[QString("to")].isNull() && m_to_isValid;

    m_subject_isValid = ::OpenAPI::fromJsonValue(m_subject, json[QString("subject")]);
    m_subject_isSet = !json[QString("subject")].isNull() && m_subject_isValid;

    m_created_isValid = ::OpenAPI::fromJsonValue(m_created, json[QString("created")]);
    m_created_isSet = !json[QString("created")].isNull() && m_created_isValid;

    m_time_isValid = ::OpenAPI::fromJsonValue(m_time, json[QString("time")]);
    m_time_isSet = !json[QString("time")].isNull() && m_time_isValid;

    m_user_isValid = ::OpenAPI::fromJsonValue(m_user, json[QString("user")]);
    m_user_isSet = !json[QString("user")].isNull() && m_user_isValid;

    m_transtype_isValid = ::OpenAPI::fromJsonValue(m_transtype, json[QString("transtype")]);
    m_transtype_isSet = !json[QString("transtype")].isNull() && m_transtype_isValid;

    m_origin_isValid = ::OpenAPI::fromJsonValue(m_origin, json[QString("origin")]);
    m_origin_isSet = !json[QString("origin")].isNull() && m_origin_isValid;

    m_interface_isValid = ::OpenAPI::fromJsonValue(m_interface, json[QString("interface")]);
    m_interface_isSet = !json[QString("interface")].isNull() && m_interface_isValid;

    m_sending_zone_isValid = ::OpenAPI::fromJsonValue(m_sending_zone, json[QString("sendingZone")]);
    m_sending_zone_isSet = !json[QString("sendingZone")].isNull() && m_sending_zone_isValid;

    m_body_size_isValid = ::OpenAPI::fromJsonValue(m_body_size, json[QString("bodySize")]);
    m_body_size_isSet = !json[QString("bodySize")].isNull() && m_body_size_isValid;

    m_seq_isValid = ::OpenAPI::fromJsonValue(m_seq, json[QString("seq")]);
    m_seq_isSet = !json[QString("seq")].isNull() && m_seq_isValid;

    m_recipient_isValid = ::OpenAPI::fromJsonValue(m_recipient, json[QString("recipient")]);
    m_recipient_isSet = !json[QString("recipient")].isNull() && m_recipient_isValid;

    m_domain_isValid = ::OpenAPI::fromJsonValue(m_domain, json[QString("domain")]);
    m_domain_isSet = !json[QString("domain")].isNull() && m_domain_isValid;

    m_locked_isValid = ::OpenAPI::fromJsonValue(m_locked, json[QString("locked")]);
    m_locked_isSet = !json[QString("locked")].isNull() && m_locked_isValid;

    m_lock_time_isValid = ::OpenAPI::fromJsonValue(m_lock_time, json[QString("lockTime")]);
    m_lock_time_isSet = !json[QString("lockTime")].isNull() && m_lock_time_isValid;

    m_assigned_isValid = ::OpenAPI::fromJsonValue(m_assigned, json[QString("assigned")]);
    m_assigned_isSet = !json[QString("assigned")].isNull() && m_assigned_isValid;

    m_queued_isValid = ::OpenAPI::fromJsonValue(m_queued, json[QString("queued")]);
    m_queued_isSet = !json[QString("queued")].isNull() && m_queued_isValid;

    m_mx_hostname_isValid = ::OpenAPI::fromJsonValue(m_mx_hostname, json[QString("mxHostname")]);
    m_mx_hostname_isSet = !json[QString("mxHostname")].isNull() && m_mx_hostname_isValid;

    m_response_isValid = ::OpenAPI::fromJsonValue(m_response, json[QString("response")]);
    m_response_isSet = !json[QString("response")].isNull() && m_response_isValid;

    m_message_id_isValid = ::OpenAPI::fromJsonValue(m_message_id, json[QString("messageId")]);
    m_message_id_isSet = !json[QString("messageId")].isNull() && m_message_id_isValid;
}

QString OAIMailLogEntry::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAIMailLogEntry::asJsonObject() const {
    QJsonObject obj;
    if (m__id_isSet) {
        obj.insert(QString("_id"), ::OpenAPI::toJsonValue(m__id));
    }
    if (m_id_isSet) {
        obj.insert(QString("id"), ::OpenAPI::toJsonValue(m_id));
    }
    if (m_from_isSet) {
        obj.insert(QString("from"), ::OpenAPI::toJsonValue(m_from));
    }
    if (m_to_isSet) {
        obj.insert(QString("to"), ::OpenAPI::toJsonValue(m_to));
    }
    if (m_subject_isSet) {
        obj.insert(QString("subject"), ::OpenAPI::toJsonValue(m_subject));
    }
    if (m_created_isSet) {
        obj.insert(QString("created"), ::OpenAPI::toJsonValue(m_created));
    }
    if (m_time_isSet) {
        obj.insert(QString("time"), ::OpenAPI::toJsonValue(m_time));
    }
    if (m_user_isSet) {
        obj.insert(QString("user"), ::OpenAPI::toJsonValue(m_user));
    }
    if (m_transtype_isSet) {
        obj.insert(QString("transtype"), ::OpenAPI::toJsonValue(m_transtype));
    }
    if (m_origin_isSet) {
        obj.insert(QString("origin"), ::OpenAPI::toJsonValue(m_origin));
    }
    if (m_interface_isSet) {
        obj.insert(QString("interface"), ::OpenAPI::toJsonValue(m_interface));
    }
    if (m_sending_zone_isSet) {
        obj.insert(QString("sendingZone"), ::OpenAPI::toJsonValue(m_sending_zone));
    }
    if (m_body_size_isSet) {
        obj.insert(QString("bodySize"), ::OpenAPI::toJsonValue(m_body_size));
    }
    if (m_seq_isSet) {
        obj.insert(QString("seq"), ::OpenAPI::toJsonValue(m_seq));
    }
    if (m_recipient_isSet) {
        obj.insert(QString("recipient"), ::OpenAPI::toJsonValue(m_recipient));
    }
    if (m_domain_isSet) {
        obj.insert(QString("domain"), ::OpenAPI::toJsonValue(m_domain));
    }
    if (m_locked_isSet) {
        obj.insert(QString("locked"), ::OpenAPI::toJsonValue(m_locked));
    }
    if (m_lock_time_isSet) {
        obj.insert(QString("lockTime"), ::OpenAPI::toJsonValue(m_lock_time));
    }
    if (m_assigned_isSet) {
        obj.insert(QString("assigned"), ::OpenAPI::toJsonValue(m_assigned));
    }
    if (m_queued_isSet) {
        obj.insert(QString("queued"), ::OpenAPI::toJsonValue(m_queued));
    }
    if (m_mx_hostname_isSet) {
        obj.insert(QString("mxHostname"), ::OpenAPI::toJsonValue(m_mx_hostname));
    }
    if (m_response_isSet) {
        obj.insert(QString("response"), ::OpenAPI::toJsonValue(m_response));
    }
    if (m_message_id_isSet) {
        obj.insert(QString("messageId"), ::OpenAPI::toJsonValue(m_message_id));
    }
    return obj;
}

qint32 OAIMailLogEntry::getId() const {
    return m__id;
}
void OAIMailLogEntry::setId(const qint32 &_id) {
    m__id = _id;
    m__id_isSet = true;
}

bool OAIMailLogEntry::is__id_Set() const{
    return m__id_isSet;
}

bool OAIMailLogEntry::is__id_Valid() const{
    return m__id_isValid;
}

QString OAIMailLogEntry::getId() const {
    return m_id;
}
void OAIMailLogEntry::setId(const QString &id) {
    m_id = id;
    m_id_isSet = true;
}

bool OAIMailLogEntry::is_id_Set() const{
    return m_id_isSet;
}

bool OAIMailLogEntry::is_id_Valid() const{
    return m_id_isValid;
}

QString OAIMailLogEntry::getFrom() const {
    return m_from;
}
void OAIMailLogEntry::setFrom(const QString &from) {
    m_from = from;
    m_from_isSet = true;
}

bool OAIMailLogEntry::is_from_Set() const{
    return m_from_isSet;
}

bool OAIMailLogEntry::is_from_Valid() const{
    return m_from_isValid;
}

QString OAIMailLogEntry::getTo() const {
    return m_to;
}
void OAIMailLogEntry::setTo(const QString &to) {
    m_to = to;
    m_to_isSet = true;
}

bool OAIMailLogEntry::is_to_Set() const{
    return m_to_isSet;
}

bool OAIMailLogEntry::is_to_Valid() const{
    return m_to_isValid;
}

QString OAIMailLogEntry::getSubject() const {
    return m_subject;
}
void OAIMailLogEntry::setSubject(const QString &subject) {
    m_subject = subject;
    m_subject_isSet = true;
}

bool OAIMailLogEntry::is_subject_Set() const{
    return m_subject_isSet;
}

bool OAIMailLogEntry::is_subject_Valid() const{
    return m_subject_isValid;
}

QString OAIMailLogEntry::getCreated() const {
    return m_created;
}
void OAIMailLogEntry::setCreated(const QString &created) {
    m_created = created;
    m_created_isSet = true;
}

bool OAIMailLogEntry::is_created_Set() const{
    return m_created_isSet;
}

bool OAIMailLogEntry::is_created_Valid() const{
    return m_created_isValid;
}

qint32 OAIMailLogEntry::getTime() const {
    return m_time;
}
void OAIMailLogEntry::setTime(const qint32 &time) {
    m_time = time;
    m_time_isSet = true;
}

bool OAIMailLogEntry::is_time_Set() const{
    return m_time_isSet;
}

bool OAIMailLogEntry::is_time_Valid() const{
    return m_time_isValid;
}

QString OAIMailLogEntry::getUser() const {
    return m_user;
}
void OAIMailLogEntry::setUser(const QString &user) {
    m_user = user;
    m_user_isSet = true;
}

bool OAIMailLogEntry::is_user_Set() const{
    return m_user_isSet;
}

bool OAIMailLogEntry::is_user_Valid() const{
    return m_user_isValid;
}

QString OAIMailLogEntry::getTranstype() const {
    return m_transtype;
}
void OAIMailLogEntry::setTranstype(const QString &transtype) {
    m_transtype = transtype;
    m_transtype_isSet = true;
}

bool OAIMailLogEntry::is_transtype_Set() const{
    return m_transtype_isSet;
}

bool OAIMailLogEntry::is_transtype_Valid() const{
    return m_transtype_isValid;
}

QString OAIMailLogEntry::getOrigin() const {
    return m_origin;
}
void OAIMailLogEntry::setOrigin(const QString &origin) {
    m_origin = origin;
    m_origin_isSet = true;
}

bool OAIMailLogEntry::is_origin_Set() const{
    return m_origin_isSet;
}

bool OAIMailLogEntry::is_origin_Valid() const{
    return m_origin_isValid;
}

QString OAIMailLogEntry::getInterface() const {
    return m_interface;
}
void OAIMailLogEntry::setInterface(const QString &interface) {
    m_interface = interface;
    m_interface_isSet = true;
}

bool OAIMailLogEntry::is_interface_Set() const{
    return m_interface_isSet;
}

bool OAIMailLogEntry::is_interface_Valid() const{
    return m_interface_isValid;
}

QString OAIMailLogEntry::getSendingZone() const {
    return m_sending_zone;
}
void OAIMailLogEntry::setSendingZone(const QString &sending_zone) {
    m_sending_zone = sending_zone;
    m_sending_zone_isSet = true;
}

bool OAIMailLogEntry::is_sending_zone_Set() const{
    return m_sending_zone_isSet;
}

bool OAIMailLogEntry::is_sending_zone_Valid() const{
    return m_sending_zone_isValid;
}

qint32 OAIMailLogEntry::getBodySize() const {
    return m_body_size;
}
void OAIMailLogEntry::setBodySize(const qint32 &body_size) {
    m_body_size = body_size;
    m_body_size_isSet = true;
}

bool OAIMailLogEntry::is_body_size_Set() const{
    return m_body_size_isSet;
}

bool OAIMailLogEntry::is_body_size_Valid() const{
    return m_body_size_isValid;
}

qint32 OAIMailLogEntry::getSeq() const {
    return m_seq;
}
void OAIMailLogEntry::setSeq(const qint32 &seq) {
    m_seq = seq;
    m_seq_isSet = true;
}

bool OAIMailLogEntry::is_seq_Set() const{
    return m_seq_isSet;
}

bool OAIMailLogEntry::is_seq_Valid() const{
    return m_seq_isValid;
}

QString OAIMailLogEntry::getRecipient() const {
    return m_recipient;
}
void OAIMailLogEntry::setRecipient(const QString &recipient) {
    m_recipient = recipient;
    m_recipient_isSet = true;
}

bool OAIMailLogEntry::is_recipient_Set() const{
    return m_recipient_isSet;
}

bool OAIMailLogEntry::is_recipient_Valid() const{
    return m_recipient_isValid;
}

QString OAIMailLogEntry::getDomain() const {
    return m_domain;
}
void OAIMailLogEntry::setDomain(const QString &domain) {
    m_domain = domain;
    m_domain_isSet = true;
}

bool OAIMailLogEntry::is_domain_Set() const{
    return m_domain_isSet;
}

bool OAIMailLogEntry::is_domain_Valid() const{
    return m_domain_isValid;
}

qint32 OAIMailLogEntry::getLocked() const {
    return m_locked;
}
void OAIMailLogEntry::setLocked(const qint32 &locked) {
    m_locked = locked;
    m_locked_isSet = true;
}

bool OAIMailLogEntry::is_locked_Set() const{
    return m_locked_isSet;
}

bool OAIMailLogEntry::is_locked_Valid() const{
    return m_locked_isValid;
}

QString OAIMailLogEntry::getLockTime() const {
    return m_lock_time;
}
void OAIMailLogEntry::setLockTime(const QString &lock_time) {
    m_lock_time = lock_time;
    m_lock_time_isSet = true;
}

bool OAIMailLogEntry::is_lock_time_Set() const{
    return m_lock_time_isSet;
}

bool OAIMailLogEntry::is_lock_time_Valid() const{
    return m_lock_time_isValid;
}

QString OAIMailLogEntry::getAssigned() const {
    return m_assigned;
}
void OAIMailLogEntry::setAssigned(const QString &assigned) {
    m_assigned = assigned;
    m_assigned_isSet = true;
}

bool OAIMailLogEntry::is_assigned_Set() const{
    return m_assigned_isSet;
}

bool OAIMailLogEntry::is_assigned_Valid() const{
    return m_assigned_isValid;
}

QString OAIMailLogEntry::getQueued() const {
    return m_queued;
}
void OAIMailLogEntry::setQueued(const QString &queued) {
    m_queued = queued;
    m_queued_isSet = true;
}

bool OAIMailLogEntry::is_queued_Set() const{
    return m_queued_isSet;
}

bool OAIMailLogEntry::is_queued_Valid() const{
    return m_queued_isValid;
}

QString OAIMailLogEntry::getMxHostname() const {
    return m_mx_hostname;
}
void OAIMailLogEntry::setMxHostname(const QString &mx_hostname) {
    m_mx_hostname = mx_hostname;
    m_mx_hostname_isSet = true;
}

bool OAIMailLogEntry::is_mx_hostname_Set() const{
    return m_mx_hostname_isSet;
}

bool OAIMailLogEntry::is_mx_hostname_Valid() const{
    return m_mx_hostname_isValid;
}

QString OAIMailLogEntry::getResponse() const {
    return m_response;
}
void OAIMailLogEntry::setResponse(const QString &response) {
    m_response = response;
    m_response_isSet = true;
}

bool OAIMailLogEntry::is_response_Set() const{
    return m_response_isSet;
}

bool OAIMailLogEntry::is_response_Valid() const{
    return m_response_isValid;
}

QString OAIMailLogEntry::getMessageId() const {
    return m_message_id;
}
void OAIMailLogEntry::setMessageId(const QString &message_id) {
    m_message_id = message_id;
    m_message_id_isSet = true;
}

bool OAIMailLogEntry::is_message_id_Set() const{
    return m_message_id_isSet;
}

bool OAIMailLogEntry::is_message_id_Valid() const{
    return m_message_id_isValid;
}

bool OAIMailLogEntry::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m__id_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_id_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_from_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_to_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_subject_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_created_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_time_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_user_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_transtype_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_origin_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_interface_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_sending_zone_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_body_size_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_seq_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_recipient_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_domain_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_locked_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_lock_time_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_assigned_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_queued_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_mx_hostname_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_response_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_message_id_isSet) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAIMailLogEntry::isValid() const {
    // only required properties are required for the object to be considered valid
    return m__id_isValid && m_id_isValid && m_from_isValid && m_to_isValid && m_subject_isValid && m_created_isValid && m_time_isValid && m_user_isValid && m_transtype_isValid && m_origin_isValid && m_interface_isValid && m_sending_zone_isValid && m_body_size_isValid && m_seq_isValid && m_recipient_isValid && m_domain_isValid && m_locked_isValid && m_lock_time_isValid && m_assigned_isValid && m_queued_isValid && m_mx_hostname_isValid && m_response_isValid && true;
}

} // namespace OpenAPI
