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

#include "OAIMailLog.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAIMailLog::OAIMailLog(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAIMailLog::OAIMailLog() {
    this->initializeModel();
}

OAIMailLog::~OAIMailLog() {}

void OAIMailLog::initializeModel() {

    m_total_isSet = false;
    m_total_isValid = false;

    m_skip_isSet = false;
    m_skip_isValid = false;

    m_limit_isSet = false;
    m_limit_isValid = false;

    m_emails_isSet = false;
    m_emails_isValid = false;
}

void OAIMailLog::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAIMailLog::fromJsonObject(QJsonObject json) {

    m_total_isValid = ::OpenAPI::fromJsonValue(m_total, json[QString("total")]);
    m_total_isSet = !json[QString("total")].isNull() && m_total_isValid;

    m_skip_isValid = ::OpenAPI::fromJsonValue(m_skip, json[QString("skip")]);
    m_skip_isSet = !json[QString("skip")].isNull() && m_skip_isValid;

    m_limit_isValid = ::OpenAPI::fromJsonValue(m_limit, json[QString("limit")]);
    m_limit_isSet = !json[QString("limit")].isNull() && m_limit_isValid;

    m_emails_isValid = ::OpenAPI::fromJsonValue(m_emails, json[QString("emails")]);
    m_emails_isSet = !json[QString("emails")].isNull() && m_emails_isValid;
}

QString OAIMailLog::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAIMailLog::asJsonObject() const {
    QJsonObject obj;
    if (m_total_isSet) {
        obj.insert(QString("total"), ::OpenAPI::toJsonValue(m_total));
    }
    if (m_skip_isSet) {
        obj.insert(QString("skip"), ::OpenAPI::toJsonValue(m_skip));
    }
    if (m_limit_isSet) {
        obj.insert(QString("limit"), ::OpenAPI::toJsonValue(m_limit));
    }
    if (m_emails.size() > 0) {
        obj.insert(QString("emails"), ::OpenAPI::toJsonValue(m_emails));
    }
    return obj;
}

qint32 OAIMailLog::getTotal() const {
    return m_total;
}
void OAIMailLog::setTotal(const qint32 &total) {
    m_total = total;
    m_total_isSet = true;
}

bool OAIMailLog::is_total_Set() const{
    return m_total_isSet;
}

bool OAIMailLog::is_total_Valid() const{
    return m_total_isValid;
}

qint32 OAIMailLog::getSkip() const {
    return m_skip;
}
void OAIMailLog::setSkip(const qint32 &skip) {
    m_skip = skip;
    m_skip_isSet = true;
}

bool OAIMailLog::is_skip_Set() const{
    return m_skip_isSet;
}

bool OAIMailLog::is_skip_Valid() const{
    return m_skip_isValid;
}

qint32 OAIMailLog::getLimit() const {
    return m_limit;
}
void OAIMailLog::setLimit(const qint32 &limit) {
    m_limit = limit;
    m_limit_isSet = true;
}

bool OAIMailLog::is_limit_Set() const{
    return m_limit_isSet;
}

bool OAIMailLog::is_limit_Valid() const{
    return m_limit_isValid;
}

QList<OAIMailLogEntry> OAIMailLog::getEmails() const {
    return m_emails;
}
void OAIMailLog::setEmails(const QList<OAIMailLogEntry> &emails) {
    m_emails = emails;
    m_emails_isSet = true;
}

bool OAIMailLog::is_emails_Set() const{
    return m_emails_isSet;
}

bool OAIMailLog::is_emails_Valid() const{
    return m_emails_isValid;
}

bool OAIMailLog::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m_total_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_skip_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_limit_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_emails.size() > 0) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAIMailLog::isValid() const {
    // only required properties are required for the object to be considered valid
    return m_total_isValid && m_skip_isValid && m_limit_isValid && m_emails_isValid && true;
}

} // namespace OpenAPI