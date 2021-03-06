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

#include "OAIGetMailOrders_200_response_inner.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAIGetMailOrders_200_response_inner::OAIGetMailOrders_200_response_inner(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAIGetMailOrders_200_response_inner::OAIGetMailOrders_200_response_inner() {
    this->initializeModel();
}

OAIGetMailOrders_200_response_inner::~OAIGetMailOrders_200_response_inner() {}

void OAIGetMailOrders_200_response_inner::initializeModel() {

    m_id_isSet = false;
    m_id_isValid = false;

    m_status_isSet = false;
    m_status_isValid = false;

    m_username_isSet = false;
    m_username_isValid = false;

    m_password_isSet = false;
    m_password_isValid = false;

    m_comment_isSet = false;
    m_comment_isValid = false;
}

void OAIGetMailOrders_200_response_inner::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAIGetMailOrders_200_response_inner::fromJsonObject(QJsonObject json) {

    m_id_isValid = ::OpenAPI::fromJsonValue(id, json[QString("id")]);
    m_id_isSet = !json[QString("id")].isNull() && m_id_isValid;

    m_status_isValid = ::OpenAPI::fromJsonValue(status, json[QString("status")]);
    m_status_isSet = !json[QString("status")].isNull() && m_status_isValid;

    m_username_isValid = ::OpenAPI::fromJsonValue(username, json[QString("username")]);
    m_username_isSet = !json[QString("username")].isNull() && m_username_isValid;

    m_password_isValid = ::OpenAPI::fromJsonValue(password, json[QString("password")]);
    m_password_isSet = !json[QString("password")].isNull() && m_password_isValid;

    m_comment_isValid = ::OpenAPI::fromJsonValue(comment, json[QString("comment")]);
    m_comment_isSet = !json[QString("comment")].isNull() && m_comment_isValid;
}

QString OAIGetMailOrders_200_response_inner::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAIGetMailOrders_200_response_inner::asJsonObject() const {
    QJsonObject obj;
    if (m_id_isSet) {
        obj.insert(QString("id"), ::OpenAPI::toJsonValue(id));
    }
    if (m_status_isSet) {
        obj.insert(QString("status"), ::OpenAPI::toJsonValue(status));
    }
    if (m_username_isSet) {
        obj.insert(QString("username"), ::OpenAPI::toJsonValue(username));
    }
    if (m_password_isSet) {
        obj.insert(QString("password"), ::OpenAPI::toJsonValue(password));
    }
    if (m_comment_isSet) {
        obj.insert(QString("comment"), ::OpenAPI::toJsonValue(comment));
    }
    return obj;
}

qint32 OAIGetMailOrders_200_response_inner::getId() const {
    return id;
}
void OAIGetMailOrders_200_response_inner::setId(const qint32 &id) {
    this->id = id;
    this->m_id_isSet = true;
}

bool OAIGetMailOrders_200_response_inner::is_id_Set() const{
    return m_id_isSet;
}

bool OAIGetMailOrders_200_response_inner::is_id_Valid() const{
    return m_id_isValid;
}

QString OAIGetMailOrders_200_response_inner::getStatus() const {
    return status;
}
void OAIGetMailOrders_200_response_inner::setStatus(const QString &status) {
    this->status = status;
    this->m_status_isSet = true;
}

bool OAIGetMailOrders_200_response_inner::is_status_Set() const{
    return m_status_isSet;
}

bool OAIGetMailOrders_200_response_inner::is_status_Valid() const{
    return m_status_isValid;
}

QString OAIGetMailOrders_200_response_inner::getUsername() const {
    return username;
}
void OAIGetMailOrders_200_response_inner::setUsername(const QString &username) {
    this->username = username;
    this->m_username_isSet = true;
}

bool OAIGetMailOrders_200_response_inner::is_username_Set() const{
    return m_username_isSet;
}

bool OAIGetMailOrders_200_response_inner::is_username_Valid() const{
    return m_username_isValid;
}

QString OAIGetMailOrders_200_response_inner::getPassword() const {
    return password;
}
void OAIGetMailOrders_200_response_inner::setPassword(const QString &password) {
    this->password = password;
    this->m_password_isSet = true;
}

bool OAIGetMailOrders_200_response_inner::is_password_Set() const{
    return m_password_isSet;
}

bool OAIGetMailOrders_200_response_inner::is_password_Valid() const{
    return m_password_isValid;
}

QString OAIGetMailOrders_200_response_inner::getComment() const {
    return comment;
}
void OAIGetMailOrders_200_response_inner::setComment(const QString &comment) {
    this->comment = comment;
    this->m_comment_isSet = true;
}

bool OAIGetMailOrders_200_response_inner::is_comment_Set() const{
    return m_comment_isSet;
}

bool OAIGetMailOrders_200_response_inner::is_comment_Valid() const{
    return m_comment_isValid;
}

bool OAIGetMailOrders_200_response_inner::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m_id_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_status_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_username_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_password_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_comment_isSet) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAIGetMailOrders_200_response_inner::isValid() const {
    // only required properties are required for the object to be considered valid
    return m_id_isValid && m_status_isValid && m_username_isValid && true;
}

} // namespace OpenAPI
