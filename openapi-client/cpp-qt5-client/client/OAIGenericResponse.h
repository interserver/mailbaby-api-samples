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

/*
 * OAIGenericResponse.h
 *
 * 
 */

#ifndef OAIGenericResponse_H
#define OAIGenericResponse_H

#include <QJsonObject>

#include <QString>

#include "OAIEnum.h"
#include "OAIObject.h"

namespace OpenAPI {

class OAIGenericResponse : public OAIObject {
public:
    OAIGenericResponse();
    OAIGenericResponse(QString json);
    ~OAIGenericResponse() override;

    QString asJson() const override;
    QJsonObject asJsonObject() const override;
    void fromJsonObject(QJsonObject json) override;
    void fromJson(QString jsonString) override;

    QString getStatus() const;
    void setStatus(const QString &status);
    bool is_status_Set() const;
    bool is_status_Valid() const;

    QString getStatusText() const;
    void setStatusText(const QString &status_text);
    bool is_status_text_Set() const;
    bool is_status_text_Valid() const;

    virtual bool isSet() const override;
    virtual bool isValid() const override;

private:
    void initializeModel();

    QString status;
    bool m_status_isSet;
    bool m_status_isValid;

    QString status_text;
    bool m_status_text_isSet;
    bool m_status_text_isValid;
};

} // namespace OpenAPI

Q_DECLARE_METATYPE(OpenAPI::OAIGenericResponse)

#endif // OAIGenericResponse_H