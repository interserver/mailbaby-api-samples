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

#include "OAISendMailAdv.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAISendMailAdv::OAISendMailAdv(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAISendMailAdv::OAISendMailAdv() {
    this->initializeModel();
}

OAISendMailAdv::~OAISendMailAdv() {}

void OAISendMailAdv::initializeModel() {

    m_subject_isSet = false;
    m_subject_isValid = false;

    m_body_isSet = false;
    m_body_isValid = false;

    m_from_isSet = false;
    m_from_isValid = false;

    m_to_isSet = false;
    m_to_isValid = false;

    m_replyto_isSet = false;
    m_replyto_isValid = false;

    m_cc_isSet = false;
    m_cc_isValid = false;

    m_bcc_isSet = false;
    m_bcc_isValid = false;

    m_attachments_isSet = false;
    m_attachments_isValid = false;

    m_id_isSet = false;
    m_id_isValid = false;
}

void OAISendMailAdv::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAISendMailAdv::fromJsonObject(QJsonObject json) {

    m_subject_isValid = ::OpenAPI::fromJsonValue(m_subject, json[QString("subject")]);
    m_subject_isSet = !json[QString("subject")].isNull() && m_subject_isValid;

    m_body_isValid = ::OpenAPI::fromJsonValue(m_body, json[QString("body")]);
    m_body_isSet = !json[QString("body")].isNull() && m_body_isValid;

    m_from_isValid = ::OpenAPI::fromJsonValue(m_from, json[QString("from")]);
    m_from_isSet = !json[QString("from")].isNull() && m_from_isValid;

    m_to_isValid = ::OpenAPI::fromJsonValue(m_to, json[QString("to")]);
    m_to_isSet = !json[QString("to")].isNull() && m_to_isValid;

    m_replyto_isValid = ::OpenAPI::fromJsonValue(m_replyto, json[QString("replyto")]);
    m_replyto_isSet = !json[QString("replyto")].isNull() && m_replyto_isValid;

    m_cc_isValid = ::OpenAPI::fromJsonValue(m_cc, json[QString("cc")]);
    m_cc_isSet = !json[QString("cc")].isNull() && m_cc_isValid;

    m_bcc_isValid = ::OpenAPI::fromJsonValue(m_bcc, json[QString("bcc")]);
    m_bcc_isSet = !json[QString("bcc")].isNull() && m_bcc_isValid;

    m_attachments_isValid = ::OpenAPI::fromJsonValue(m_attachments, json[QString("attachments")]);
    m_attachments_isSet = !json[QString("attachments")].isNull() && m_attachments_isValid;

    m_id_isValid = ::OpenAPI::fromJsonValue(m_id, json[QString("id")]);
    m_id_isSet = !json[QString("id")].isNull() && m_id_isValid;
}

QString OAISendMailAdv::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAISendMailAdv::asJsonObject() const {
    QJsonObject obj;
    if (m_subject_isSet) {
        obj.insert(QString("subject"), ::OpenAPI::toJsonValue(m_subject));
    }
    if (m_body_isSet) {
        obj.insert(QString("body"), ::OpenAPI::toJsonValue(m_body));
    }
    if (m_from.isSet()) {
        obj.insert(QString("from"), ::OpenAPI::toJsonValue(m_from));
    }
    if (m_to.size() > 0) {
        obj.insert(QString("to"), ::OpenAPI::toJsonValue(m_to));
    }
    if (m_replyto.size() > 0) {
        obj.insert(QString("replyto"), ::OpenAPI::toJsonValue(m_replyto));
    }
    if (m_cc.size() > 0) {
        obj.insert(QString("cc"), ::OpenAPI::toJsonValue(m_cc));
    }
    if (m_bcc.size() > 0) {
        obj.insert(QString("bcc"), ::OpenAPI::toJsonValue(m_bcc));
    }
    if (m_attachments.size() > 0) {
        obj.insert(QString("attachments"), ::OpenAPI::toJsonValue(m_attachments));
    }
    if (m_id_isSet) {
        obj.insert(QString("id"), ::OpenAPI::toJsonValue(m_id));
    }
    return obj;
}

QString OAISendMailAdv::getSubject() const {
    return m_subject;
}
void OAISendMailAdv::setSubject(const QString &subject) {
    m_subject = subject;
    m_subject_isSet = true;
}

bool OAISendMailAdv::is_subject_Set() const{
    return m_subject_isSet;
}

bool OAISendMailAdv::is_subject_Valid() const{
    return m_subject_isValid;
}

QString OAISendMailAdv::getBody() const {
    return m_body;
}
void OAISendMailAdv::setBody(const QString &body) {
    m_body = body;
    m_body_isSet = true;
}

bool OAISendMailAdv::is_body_Set() const{
    return m_body_isSet;
}

bool OAISendMailAdv::is_body_Valid() const{
    return m_body_isValid;
}

OAIEmailAddressName OAISendMailAdv::getFrom() const {
    return m_from;
}
void OAISendMailAdv::setFrom(const OAIEmailAddressName &from) {
    m_from = from;
    m_from_isSet = true;
}

bool OAISendMailAdv::is_from_Set() const{
    return m_from_isSet;
}

bool OAISendMailAdv::is_from_Valid() const{
    return m_from_isValid;
}

QList<OAIEmailAddressName> OAISendMailAdv::getTo() const {
    return m_to;
}
void OAISendMailAdv::setTo(const QList<OAIEmailAddressName> &to) {
    m_to = to;
    m_to_isSet = true;
}

bool OAISendMailAdv::is_to_Set() const{
    return m_to_isSet;
}

bool OAISendMailAdv::is_to_Valid() const{
    return m_to_isValid;
}

QList<OAIEmailAddressName> OAISendMailAdv::getReplyto() const {
    return m_replyto;
}
void OAISendMailAdv::setReplyto(const QList<OAIEmailAddressName> &replyto) {
    m_replyto = replyto;
    m_replyto_isSet = true;
}

bool OAISendMailAdv::is_replyto_Set() const{
    return m_replyto_isSet;
}

bool OAISendMailAdv::is_replyto_Valid() const{
    return m_replyto_isValid;
}

QList<OAIEmailAddressName> OAISendMailAdv::getCc() const {
    return m_cc;
}
void OAISendMailAdv::setCc(const QList<OAIEmailAddressName> &cc) {
    m_cc = cc;
    m_cc_isSet = true;
}

bool OAISendMailAdv::is_cc_Set() const{
    return m_cc_isSet;
}

bool OAISendMailAdv::is_cc_Valid() const{
    return m_cc_isValid;
}

QList<OAIEmailAddressName> OAISendMailAdv::getBcc() const {
    return m_bcc;
}
void OAISendMailAdv::setBcc(const QList<OAIEmailAddressName> &bcc) {
    m_bcc = bcc;
    m_bcc_isSet = true;
}

bool OAISendMailAdv::is_bcc_Set() const{
    return m_bcc_isSet;
}

bool OAISendMailAdv::is_bcc_Valid() const{
    return m_bcc_isValid;
}

QList<OAIMailAttachment> OAISendMailAdv::getAttachments() const {
    return m_attachments;
}
void OAISendMailAdv::setAttachments(const QList<OAIMailAttachment> &attachments) {
    m_attachments = attachments;
    m_attachments_isSet = true;
}

bool OAISendMailAdv::is_attachments_Set() const{
    return m_attachments_isSet;
}

bool OAISendMailAdv::is_attachments_Valid() const{
    return m_attachments_isValid;
}

qint64 OAISendMailAdv::getId() const {
    return m_id;
}
void OAISendMailAdv::setId(const qint64 &id) {
    m_id = id;
    m_id_isSet = true;
}

bool OAISendMailAdv::is_id_Set() const{
    return m_id_isSet;
}

bool OAISendMailAdv::is_id_Valid() const{
    return m_id_isValid;
}

bool OAISendMailAdv::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m_subject_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_body_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_from.isSet()) {
            isObjectUpdated = true;
            break;
        }

        if (m_to.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_replyto.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_cc.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_bcc.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_attachments.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_id_isSet) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAISendMailAdv::isValid() const {
    // only required properties are required for the object to be considered valid
    return m_subject_isValid && m_body_isValid && m_from_isValid && m_to_isValid && true;
}

} // namespace OpenAPI