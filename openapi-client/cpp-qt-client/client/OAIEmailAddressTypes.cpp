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

#include "OAIEmailAddressTypes.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAIEmailAddressTypes::OAIEmailAddressTypes(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAIEmailAddressTypes::OAIEmailAddressTypes() {
    this->initializeModel();
}

OAIEmailAddressTypes::~OAIEmailAddressTypes() {}

void OAIEmailAddressTypes::initializeModel() {

    m_email_isSet = false;
    m_email_isValid = false;

    m_name_isSet = false;
    m_name_isValid = false;
}

void OAIEmailAddressTypes::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAIEmailAddressTypes::fromJsonObject(QJsonObject json) {

    m_email_isValid = ::OpenAPI::fromJsonValue(m_email, json[QString("email")]);
    m_email_isSet = !json[QString("email")].isNull() && m_email_isValid;

    m_name_isValid = ::OpenAPI::fromJsonValue(m_name, json[QString("name")]);
    m_name_isSet = !json[QString("name")].isNull() && m_name_isValid;
}

QString OAIEmailAddressTypes::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAIEmailAddressTypes::asJsonObject() const {
    QJsonObject obj;
    if (m_email_isSet) {
        obj.insert(QString("email"), ::OpenAPI::toJsonValue(m_email));
    }
    if (m_name_isSet) {
        obj.insert(QString("name"), ::OpenAPI::toJsonValue(m_name));
    }
    return obj;
}

QString OAIEmailAddressTypes::getEmail() const {
    return m_email;
}
void OAIEmailAddressTypes::setEmail(const QString &email) {
    m_email = email;
    m_email_isSet = true;
}

bool OAIEmailAddressTypes::is_email_Set() const{
    return m_email_isSet;
}

bool OAIEmailAddressTypes::is_email_Valid() const{
    return m_email_isValid;
}

QString OAIEmailAddressTypes::getName() const {
    return m_name;
}
void OAIEmailAddressTypes::setName(const QString &name) {
    m_name = name;
    m_name_isSet = true;
}

bool OAIEmailAddressTypes::is_name_Set() const{
    return m_name_isSet;
}

bool OAIEmailAddressTypes::is_name_Valid() const{
    return m_name_isValid;
}

bool OAIEmailAddressTypes::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m_email_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_name_isSet) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAIEmailAddressTypes::isValid() const {
    // only required properties are required for the object to be considered valid
    return m_email_isValid && true;
}

} // namespace OpenAPI