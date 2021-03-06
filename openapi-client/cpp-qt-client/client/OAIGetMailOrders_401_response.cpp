/**
 * MailBaby Email Delivery API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

#include "OAIGetMailOrders_401_response.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAIGetMailOrders_401_response::OAIGetMailOrders_401_response(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAIGetMailOrders_401_response::OAIGetMailOrders_401_response() {
    this->initializeModel();
}

OAIGetMailOrders_401_response::~OAIGetMailOrders_401_response() {}

void OAIGetMailOrders_401_response::initializeModel() {

    m_code_isSet = false;
    m_code_isValid = false;

    m_message_isSet = false;
    m_message_isValid = false;
}

void OAIGetMailOrders_401_response::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAIGetMailOrders_401_response::fromJsonObject(QJsonObject json) {

    m_code_isValid = ::OpenAPI::fromJsonValue(code, json[QString("code")]);
    m_code_isSet = !json[QString("code")].isNull() && m_code_isValid;

    m_message_isValid = ::OpenAPI::fromJsonValue(message, json[QString("message")]);
    m_message_isSet = !json[QString("message")].isNull() && m_message_isValid;
}

QString OAIGetMailOrders_401_response::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAIGetMailOrders_401_response::asJsonObject() const {
    QJsonObject obj;
    if (m_code_isSet) {
        obj.insert(QString("code"), ::OpenAPI::toJsonValue(code));
    }
    if (m_message_isSet) {
        obj.insert(QString("message"), ::OpenAPI::toJsonValue(message));
    }
    return obj;
}

QString OAIGetMailOrders_401_response::getCode() const {
    return code;
}
void OAIGetMailOrders_401_response::setCode(const QString &code) {
    this->code = code;
    this->m_code_isSet = true;
}

bool OAIGetMailOrders_401_response::is_code_Set() const{
    return m_code_isSet;
}

bool OAIGetMailOrders_401_response::is_code_Valid() const{
    return m_code_isValid;
}

QString OAIGetMailOrders_401_response::getMessage() const {
    return message;
}
void OAIGetMailOrders_401_response::setMessage(const QString &message) {
    this->message = message;
    this->m_message_isSet = true;
}

bool OAIGetMailOrders_401_response::is_message_Set() const{
    return m_message_isSet;
}

bool OAIGetMailOrders_401_response::is_message_Valid() const{
    return m_message_isValid;
}

bool OAIGetMailOrders_401_response::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m_code_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_message_isSet) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAIGetMailOrders_401_response::isValid() const {
    // only required properties are required for the object to be considered valid
    return m_code_isValid && m_message_isValid && true;
}

} // namespace OpenAPI
