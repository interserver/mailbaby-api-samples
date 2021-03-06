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
 * OAISendMailAdv_attachments_inner.h
 *
 * A File attachment for an email
 */

#ifndef OAISendMailAdv_attachments_inner_H
#define OAISendMailAdv_attachments_inner_H

#include <QJsonObject>

#include "OAIHttpFileElement.h"
#include <QString>

#include "OAIEnum.h"
#include "OAIObject.h"

namespace OpenAPI {

class OAISendMailAdv_attachments_inner : public OAIObject {
public:
    OAISendMailAdv_attachments_inner();
    OAISendMailAdv_attachments_inner(QString json);
    ~OAISendMailAdv_attachments_inner() override;

    QString asJson() const override;
    QJsonObject asJsonObject() const override;
    void fromJsonObject(QJsonObject json) override;
    void fromJson(QString jsonString) override;

    OAIHttpFileElement getData() const;
    void setData(const OAIHttpFileElement &data);
    bool is_data_Set() const;
    bool is_data_Valid() const;

    QString getFilename() const;
    void setFilename(const QString &filename);
    bool is_filename_Set() const;
    bool is_filename_Valid() const;

    virtual bool isSet() const override;
    virtual bool isValid() const override;

private:
    void initializeModel();

    OAIHttpFileElement data;
    bool m_data_isSet;
    bool m_data_isValid;

    QString filename;
    bool m_filename_isSet;
    bool m_filename_isValid;
};

} // namespace OpenAPI

Q_DECLARE_METATYPE(OpenAPI::OAISendMailAdv_attachments_inner)

#endif // OAISendMailAdv_attachments_inner_H
