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

#include "OAIMailBlocks.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAIMailBlocks::OAIMailBlocks(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAIMailBlocks::OAIMailBlocks() {
    this->initializeModel();
}

OAIMailBlocks::~OAIMailBlocks() {}

void OAIMailBlocks::initializeModel() {

    m_local_isSet = false;
    m_local_isValid = false;

    m_mbtrap_isSet = false;
    m_mbtrap_isValid = false;

    m_subject_isSet = false;
    m_subject_isValid = false;
}

void OAIMailBlocks::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAIMailBlocks::fromJsonObject(QJsonObject json) {

    m_local_isValid = ::OpenAPI::fromJsonValue(m_local, json[QString("local")]);
    m_local_isSet = !json[QString("local")].isNull() && m_local_isValid;

    m_mbtrap_isValid = ::OpenAPI::fromJsonValue(m_mbtrap, json[QString("mbtrap")]);
    m_mbtrap_isSet = !json[QString("mbtrap")].isNull() && m_mbtrap_isValid;

    m_subject_isValid = ::OpenAPI::fromJsonValue(m_subject, json[QString("subject")]);
    m_subject_isSet = !json[QString("subject")].isNull() && m_subject_isValid;
}

QString OAIMailBlocks::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAIMailBlocks::asJsonObject() const {
    QJsonObject obj;
    if (m_local.size() > 0) {
        obj.insert(QString("local"), ::OpenAPI::toJsonValue(m_local));
    }
    if (m_mbtrap.size() > 0) {
        obj.insert(QString("mbtrap"), ::OpenAPI::toJsonValue(m_mbtrap));
    }
    if (m_subject.size() > 0) {
        obj.insert(QString("subject"), ::OpenAPI::toJsonValue(m_subject));
    }
    return obj;
}

QList<OAIMailBlockClickHouse> OAIMailBlocks::getLocal() const {
    return m_local;
}
void OAIMailBlocks::setLocal(const QList<OAIMailBlockClickHouse> &local) {
    m_local = local;
    m_local_isSet = true;
}

bool OAIMailBlocks::is_local_Set() const{
    return m_local_isSet;
}

bool OAIMailBlocks::is_local_Valid() const{
    return m_local_isValid;
}

QList<OAIMailBlockClickHouse> OAIMailBlocks::getMbtrap() const {
    return m_mbtrap;
}
void OAIMailBlocks::setMbtrap(const QList<OAIMailBlockClickHouse> &mbtrap) {
    m_mbtrap = mbtrap;
    m_mbtrap_isSet = true;
}

bool OAIMailBlocks::is_mbtrap_Set() const{
    return m_mbtrap_isSet;
}

bool OAIMailBlocks::is_mbtrap_Valid() const{
    return m_mbtrap_isValid;
}

QList<OAIMailBlockRspamd> OAIMailBlocks::getSubject() const {
    return m_subject;
}
void OAIMailBlocks::setSubject(const QList<OAIMailBlockRspamd> &subject) {
    m_subject = subject;
    m_subject_isSet = true;
}

bool OAIMailBlocks::is_subject_Set() const{
    return m_subject_isSet;
}

bool OAIMailBlocks::is_subject_Valid() const{
    return m_subject_isValid;
}

bool OAIMailBlocks::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m_local.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_mbtrap.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_subject.size() > 0) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAIMailBlocks::isValid() const {
    // only required properties are required for the object to be considered valid
    return m_local_isValid && m_mbtrap_isValid && m_subject_isValid && true;
}

} // namespace OpenAPI