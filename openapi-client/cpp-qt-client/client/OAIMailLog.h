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

/*
 * OAIMailLog.h
 *
 * Mail log records
 */

#ifndef OAIMailLog_H
#define OAIMailLog_H

#include <QJsonObject>

#include "OAIMailLogEntry.h"
#include <QList>

#include "OAIEnum.h"
#include "OAIObject.h"

namespace OpenAPI {
class OAIMailLogEntry;

class OAIMailLog : public OAIObject {
public:
    OAIMailLog();
    OAIMailLog(QString json);
    ~OAIMailLog() override;

    QString asJson() const override;
    QJsonObject asJsonObject() const override;
    void fromJsonObject(QJsonObject json) override;
    void fromJson(QString jsonString) override;

    qint32 getTotal() const;
    void setTotal(const qint32 &total);
    bool is_total_Set() const;
    bool is_total_Valid() const;

    qint32 getSkip() const;
    void setSkip(const qint32 &skip);
    bool is_skip_Set() const;
    bool is_skip_Valid() const;

    qint32 getLimit() const;
    void setLimit(const qint32 &limit);
    bool is_limit_Set() const;
    bool is_limit_Valid() const;

    QList<OAIMailLogEntry> getEmails() const;
    void setEmails(const QList<OAIMailLogEntry> &emails);
    bool is_emails_Set() const;
    bool is_emails_Valid() const;

    virtual bool isSet() const override;
    virtual bool isValid() const override;

private:
    void initializeModel();

    qint32 m_total;
    bool m_total_isSet;
    bool m_total_isValid;

    qint32 m_skip;
    bool m_skip_isSet;
    bool m_skip_isValid;

    qint32 m_limit;
    bool m_limit_isSet;
    bool m_limit_isValid;

    QList<OAIMailLogEntry> m_emails;
    bool m_emails_isSet;
    bool m_emails_isValid;
};

} // namespace OpenAPI

Q_DECLARE_METATYPE(OpenAPI::OAIMailLog)

#endif // OAIMailLog_H