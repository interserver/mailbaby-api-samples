/**
 * Mail Baby API
 * This is an API for accesssing the mail services.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

#include "OAISendMail.h"

#include <QDebug>
#include <QJsonArray>
#include <QJsonDocument>
#include <QObject>

#include "OAIHelpers.h"

namespace OpenAPI {

OAISendMail::OAISendMail(QString json) {
    this->initializeModel();
    this->fromJson(json);
}

OAISendMail::OAISendMail() {
    this->initializeModel();
}

OAISendMail::~OAISendMail() {}

void OAISendMail::initializeModel() {

    m_id_isSet = false;
    m_id_isValid = false;

    m_from_isSet = false;
    m_from_isValid = false;

    m_to_isSet = false;
    m_to_isValid = false;

    m_subject_isSet = false;
    m_subject_isValid = false;

    m_body_isSet = false;
    m_body_isValid = false;

    m_replyto_isSet = false;
    m_replyto_isValid = false;

    m_cc_isSet = false;
    m_cc_isValid = false;

    m_bcc_isSet = false;
    m_bcc_isValid = false;

    m_attachments_isSet = false;
    m_attachments_isValid = false;
}

void OAISendMail::fromJson(QString jsonString) {
    QByteArray array(jsonString.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
}

void OAISendMail::fromJsonObject(QJsonObject json) {

    m_id_isValid = ::OpenAPI::fromJsonValue(id, json[QString("id")]);
    m_id_isSet = !json[QString("id")].isNull() && m_id_isValid;

    m_from_isValid = ::OpenAPI::fromJsonValue(from, json[QString("from")]);
    m_from_isSet = !json[QString("from")].isNull() && m_from_isValid;

    m_to_isValid = ::OpenAPI::fromJsonValue(to, json[QString("to")]);
    m_to_isSet = !json[QString("to")].isNull() && m_to_isValid;

    m_subject_isValid = ::OpenAPI::fromJsonValue(subject, json[QString("subject")]);
    m_subject_isSet = !json[QString("subject")].isNull() && m_subject_isValid;

    m_body_isValid = ::OpenAPI::fromJsonValue(body, json[QString("body")]);
    m_body_isSet = !json[QString("body")].isNull() && m_body_isValid;

    m_replyto_isValid = ::OpenAPI::fromJsonValue(replyto, json[QString("replyto")]);
    m_replyto_isSet = !json[QString("replyto")].isNull() && m_replyto_isValid;

    m_cc_isValid = ::OpenAPI::fromJsonValue(cc, json[QString("cc")]);
    m_cc_isSet = !json[QString("cc")].isNull() && m_cc_isValid;

    m_bcc_isValid = ::OpenAPI::fromJsonValue(bcc, json[QString("bcc")]);
    m_bcc_isSet = !json[QString("bcc")].isNull() && m_bcc_isValid;

    m_attachments_isValid = ::OpenAPI::fromJsonValue(attachments, json[QString("attachments")]);
    m_attachments_isSet = !json[QString("attachments")].isNull() && m_attachments_isValid;
}

QString OAISendMail::asJson() const {
    QJsonObject obj = this->asJsonObject();
    QJsonDocument doc(obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject OAISendMail::asJsonObject() const {
    QJsonObject obj;
    if (m_id_isSet) {
        obj.insert(QString("id"), ::OpenAPI::toJsonValue(id));
    }
    if (from.isSet()) {
        obj.insert(QString("from"), ::OpenAPI::toJsonValue(from));
    }
    if (to.size() > 0) {
        obj.insert(QString("to"), ::OpenAPI::toJsonValue(to));
    }
    if (m_subject_isSet) {
        obj.insert(QString("subject"), ::OpenAPI::toJsonValue(subject));
    }
    if (m_body_isSet) {
        obj.insert(QString("body"), ::OpenAPI::toJsonValue(body));
    }
    if (replyto.size() > 0) {
        obj.insert(QString("replyto"), ::OpenAPI::toJsonValue(replyto));
    }
    if (cc.size() > 0) {
        obj.insert(QString("cc"), ::OpenAPI::toJsonValue(cc));
    }
    if (bcc.size() > 0) {
        obj.insert(QString("bcc"), ::OpenAPI::toJsonValue(bcc));
    }
    if (attachments.size() > 0) {
        obj.insert(QString("attachments"), ::OpenAPI::toJsonValue(attachments));
    }
    return obj;
}

qint64 OAISendMail::getId() const {
    return id;
}
void OAISendMail::setId(const qint64 &id) {
    this->id = id;
    this->m_id_isSet = true;
}

bool OAISendMail::is_id_Set() const{
    return m_id_isSet;
}

bool OAISendMail::is_id_Valid() const{
    return m_id_isValid;
}

OAIMailContact OAISendMail::getFrom() const {
    return from;
}
void OAISendMail::setFrom(const OAIMailContact &from) {
    this->from = from;
    this->m_from_isSet = true;
}

bool OAISendMail::is_from_Set() const{
    return m_from_isSet;
}

bool OAISendMail::is_from_Valid() const{
    return m_from_isValid;
}

QList<OAIMailContact> OAISendMail::getTo() const {
    return to;
}
void OAISendMail::setTo(const QList<OAIMailContact> &to) {
    this->to = to;
    this->m_to_isSet = true;
}

bool OAISendMail::is_to_Set() const{
    return m_to_isSet;
}

bool OAISendMail::is_to_Valid() const{
    return m_to_isValid;
}

QString OAISendMail::getSubject() const {
    return subject;
}
void OAISendMail::setSubject(const QString &subject) {
    this->subject = subject;
    this->m_subject_isSet = true;
}

bool OAISendMail::is_subject_Set() const{
    return m_subject_isSet;
}

bool OAISendMail::is_subject_Valid() const{
    return m_subject_isValid;
}

QString OAISendMail::getBody() const {
    return body;
}
void OAISendMail::setBody(const QString &body) {
    this->body = body;
    this->m_body_isSet = true;
}

bool OAISendMail::is_body_Set() const{
    return m_body_isSet;
}

bool OAISendMail::is_body_Valid() const{
    return m_body_isValid;
}

QList<OAIMailContact> OAISendMail::getReplyto() const {
    return replyto;
}
void OAISendMail::setReplyto(const QList<OAIMailContact> &replyto) {
    this->replyto = replyto;
    this->m_replyto_isSet = true;
}

bool OAISendMail::is_replyto_Set() const{
    return m_replyto_isSet;
}

bool OAISendMail::is_replyto_Valid() const{
    return m_replyto_isValid;
}

QList<OAIMailContact> OAISendMail::getCc() const {
    return cc;
}
void OAISendMail::setCc(const QList<OAIMailContact> &cc) {
    this->cc = cc;
    this->m_cc_isSet = true;
}

bool OAISendMail::is_cc_Set() const{
    return m_cc_isSet;
}

bool OAISendMail::is_cc_Valid() const{
    return m_cc_isValid;
}

QList<OAIMailContact> OAISendMail::getBcc() const {
    return bcc;
}
void OAISendMail::setBcc(const QList<OAIMailContact> &bcc) {
    this->bcc = bcc;
    this->m_bcc_isSet = true;
}

bool OAISendMail::is_bcc_Set() const{
    return m_bcc_isSet;
}

bool OAISendMail::is_bcc_Valid() const{
    return m_bcc_isValid;
}

QList<OAIMailAttachment> OAISendMail::getAttachments() const {
    return attachments;
}
void OAISendMail::setAttachments(const QList<OAIMailAttachment> &attachments) {
    this->attachments = attachments;
    this->m_attachments_isSet = true;
}

bool OAISendMail::is_attachments_Set() const{
    return m_attachments_isSet;
}

bool OAISendMail::is_attachments_Valid() const{
    return m_attachments_isValid;
}

bool OAISendMail::isSet() const {
    bool isObjectUpdated = false;
    do {
        if (m_id_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (from.isSet()) {
            isObjectUpdated = true;
            break;
        }

        if (to.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (m_subject_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (m_body_isSet) {
            isObjectUpdated = true;
            break;
        }

        if (replyto.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (cc.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (bcc.size() > 0) {
            isObjectUpdated = true;
            break;
        }

        if (attachments.size() > 0) {
            isObjectUpdated = true;
            break;
        }
    } while (false);
    return isObjectUpdated;
}

bool OAISendMail::isValid() const {
    // only required properties are required for the object to be considered valid
    return m_id_isValid && m_from_isValid && m_to_isValid && m_subject_isValid && m_body_isValid && true;
}

} // namespace OpenAPI