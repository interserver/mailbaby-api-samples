/**
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

/*
 * OAISendMailAdv_from.h
 *
 * An Email Contact
 */

#ifndef OAISendMailAdv_from_H
#define OAISendMailAdv_from_H

#include <QJsonObject>

#include <QString>

#include "OAIEnum.h"
#include "OAIObject.h"

namespace OpenAPI {

class OAISendMailAdv_from : public OAIObject {
public:
    OAISendMailAdv_from();
    OAISendMailAdv_from(QString json);
    ~OAISendMailAdv_from() override;

    QString asJson() const override;
    QJsonObject asJsonObject() const override;
    void fromJsonObject(QJsonObject json) override;
    void fromJson(QString jsonString) override;

    QString getEmail() const;
    void setEmail(const QString &email);
    bool is_email_Set() const;
    bool is_email_Valid() const;

    QString getName() const;
    void setName(const QString &name);
    bool is_name_Set() const;
    bool is_name_Valid() const;

    virtual bool isSet() const override;
    virtual bool isValid() const override;

private:
    void initializeModel();

    QString email;
    bool m_email_isSet;
    bool m_email_isValid;

    QString name;
    bool m_name_isSet;
    bool m_name_isValid;
};

} // namespace OpenAPI

Q_DECLARE_METATYPE(OpenAPI::OAISendMailAdv_from)

#endif // OAISendMailAdv_from_H