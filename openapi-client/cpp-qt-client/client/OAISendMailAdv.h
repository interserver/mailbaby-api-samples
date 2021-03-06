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

/*
 * OAISendMailAdv.h
 *
 * Details for an Email
 */

#ifndef OAISendMailAdv_H
#define OAISendMailAdv_H

#include <QJsonObject>

#include "OAISendMailAdv_attachments_inner.h"
#include "OAISendMailAdv_bcc_inner.h"
#include "OAISendMailAdv_cc_inner.h"
#include "OAISendMailAdv_from.h"
#include "OAISendMailAdv_replyto_inner.h"
#include "OAISendMailAdv_to_inner.h"
#include <QList>
#include <QString>

#include "OAIEnum.h"
#include "OAIObject.h"

namespace OpenAPI {
class OAISendMailAdv_from;
class OAISendMailAdv_to_inner;
class OAISendMailAdv_replyto_inner;
class OAISendMailAdv_cc_inner;
class OAISendMailAdv_bcc_inner;
class OAISendMailAdv_attachments_inner;

class OAISendMailAdv : public OAIObject {
public:
    OAISendMailAdv();
    OAISendMailAdv(QString json);
    ~OAISendMailAdv() override;

    QString asJson() const override;
    QJsonObject asJsonObject() const override;
    void fromJsonObject(QJsonObject json) override;
    void fromJson(QString jsonString) override;

    QString getSubject() const;
    void setSubject(const QString &subject);
    bool is_subject_Set() const;
    bool is_subject_Valid() const;

    QString getBody() const;
    void setBody(const QString &body);
    bool is_body_Set() const;
    bool is_body_Valid() const;

    OAISendMailAdv_from getFrom() const;
    void setFrom(const OAISendMailAdv_from &from);
    bool is_from_Set() const;
    bool is_from_Valid() const;

    QList<OAISendMailAdv_to_inner> getTo() const;
    void setTo(const QList<OAISendMailAdv_to_inner> &to);
    bool is_to_Set() const;
    bool is_to_Valid() const;

    QList<OAISendMailAdv_replyto_inner> getReplyto() const;
    void setReplyto(const QList<OAISendMailAdv_replyto_inner> &replyto);
    bool is_replyto_Set() const;
    bool is_replyto_Valid() const;

    QList<OAISendMailAdv_cc_inner> getCc() const;
    void setCc(const QList<OAISendMailAdv_cc_inner> &cc);
    bool is_cc_Set() const;
    bool is_cc_Valid() const;

    QList<OAISendMailAdv_bcc_inner> getBcc() const;
    void setBcc(const QList<OAISendMailAdv_bcc_inner> &bcc);
    bool is_bcc_Set() const;
    bool is_bcc_Valid() const;

    QList<OAISendMailAdv_attachments_inner> getAttachments() const;
    void setAttachments(const QList<OAISendMailAdv_attachments_inner> &attachments);
    bool is_attachments_Set() const;
    bool is_attachments_Valid() const;

    qint64 getId() const;
    void setId(const qint64 &id);
    bool is_id_Set() const;
    bool is_id_Valid() const;

    virtual bool isSet() const override;
    virtual bool isValid() const override;

private:
    void initializeModel();

    QString subject;
    bool m_subject_isSet;
    bool m_subject_isValid;

    QString body;
    bool m_body_isSet;
    bool m_body_isValid;

    OAISendMailAdv_from from;
    bool m_from_isSet;
    bool m_from_isValid;

    QList<OAISendMailAdv_to_inner> to;
    bool m_to_isSet;
    bool m_to_isValid;

    QList<OAISendMailAdv_replyto_inner> replyto;
    bool m_replyto_isSet;
    bool m_replyto_isValid;

    QList<OAISendMailAdv_cc_inner> cc;
    bool m_cc_isSet;
    bool m_cc_isValid;

    QList<OAISendMailAdv_bcc_inner> bcc;
    bool m_bcc_isSet;
    bool m_bcc_isValid;

    QList<OAISendMailAdv_attachments_inner> attachments;
    bool m_attachments_isSet;
    bool m_attachments_isValid;

    qint64 id;
    bool m_id_isSet;
    bool m_id_isValid;
};

} // namespace OpenAPI

Q_DECLARE_METATYPE(OpenAPI::OAISendMailAdv)

#endif // OAISendMailAdv_H
