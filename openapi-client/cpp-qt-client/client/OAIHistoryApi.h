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

#ifndef OAI_OAIHistoryApi_H
#define OAI_OAIHistoryApi_H

#include "OAIHelpers.h"
#include "OAIHttpRequest.h"
#include "OAIServerConfiguration.h"
#include "OAIOauth.h"

#include "OAIErrorMessage.h"
#include "OAIMailLog.h"
#include "OAIMailStatsType.h"
#include <QString>

#include <QObject>
#include <QByteArray>
#include <QStringList>
#include <QList>
#include <QNetworkAccessManager>

namespace OpenAPI {

class OAIHistoryApi : public QObject {
    Q_OBJECT

public:
    OAIHistoryApi(const int timeOut = 0);
    ~OAIHistoryApi();

    void initializeServerConfigs();
    int setDefaultServerValue(int serverIndex,const QString &operation, const QString &variable,const QString &val);
    void setServerIndex(const QString &operation, int serverIndex);
    void setApiKey(const QString &apiKeyName, const QString &apiKey);
    void setBearerToken(const QString &token);
    void setUsername(const QString &username);
    void setPassword(const QString &password);
    void setTimeOut(const int timeOut);
    void setWorkingDirectory(const QString &path);
    void setNetworkAccessManager(QNetworkAccessManager* manager);
    int addServerConfiguration(const QString &operation, const QUrl &url, const QString &description = "", const QMap<QString, OAIServerVariable> &variables = QMap<QString, OAIServerVariable>());
    void setNewServerForAllOperations(const QUrl &url, const QString &description = "", const QMap<QString, OAIServerVariable> &variables =  QMap<QString, OAIServerVariable>());
    void setNewServer(const QString &operation, const QUrl &url, const QString &description = "", const QMap<QString, OAIServerVariable> &variables =  QMap<QString, OAIServerVariable>());
    void addHeaders(const QString &key, const QString &value);
    void enableRequestCompression();
    void enableResponseCompression();
    void abortRequests();
    QString getParamStylePrefix(const QString &style);
    QString getParamStyleSuffix(const QString &style);
    QString getParamStyleDelimiter(const QString &style, const QString &name, bool isExplode);

    /**
    * @param[in]  time QString [optional]
    */
    virtual void getStats(const ::OpenAPI::OptionalParam<QString> &time = ::OpenAPI::OptionalParam<QString>());

    /**
    * @param[in]  id qint64 [optional]
    * @param[in]  origin QString [optional]
    * @param[in]  mx QString [optional]
    * @param[in]  from QString [optional]
    * @param[in]  to QString [optional]
    * @param[in]  subject QString [optional]
    * @param[in]  mailid QString [optional]
    * @param[in]  skip qint32 [optional]
    * @param[in]  limit qint32 [optional]
    * @param[in]  start_date qint64 [optional]
    * @param[in]  end_date qint64 [optional]
    * @param[in]  replyto QString [optional]
    * @param[in]  headerfrom QString [optional]
    * @param[in]  delivered QString [optional]
    */
    virtual void viewMailLog(const ::OpenAPI::OptionalParam<qint64> &id = ::OpenAPI::OptionalParam<qint64>(), const ::OpenAPI::OptionalParam<QString> &origin = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<QString> &mx = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<QString> &from = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<QString> &to = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<QString> &subject = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<QString> &mailid = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<qint32> &skip = ::OpenAPI::OptionalParam<qint32>(), const ::OpenAPI::OptionalParam<qint32> &limit = ::OpenAPI::OptionalParam<qint32>(), const ::OpenAPI::OptionalParam<qint64> &start_date = ::OpenAPI::OptionalParam<qint64>(), const ::OpenAPI::OptionalParam<qint64> &end_date = ::OpenAPI::OptionalParam<qint64>(), const ::OpenAPI::OptionalParam<QString> &replyto = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<QString> &headerfrom = ::OpenAPI::OptionalParam<QString>(), const ::OpenAPI::OptionalParam<QString> &delivered = ::OpenAPI::OptionalParam<QString>());


private:
    QMap<QString,int> _serverIndices;
    QMap<QString,QList<OAIServerConfiguration>> _serverConfigs;
    QMap<QString, QString> _apiKeys;
    QString _bearerToken;
    QString _username;
    QString _password;
    int _timeOut;
    QString _workingDirectory;
    QNetworkAccessManager* _manager;
    QMap<QString, QString> _defaultHeaders;
    bool _isResponseCompressionEnabled;
    bool _isRequestCompressionEnabled;
    OAIHttpRequestInput _latestInput;
    OAIHttpRequestWorker *_latestWorker;
    QStringList _latestScope;
    OauthCode _authFlow;
    OauthImplicit _implicitFlow;
    OauthCredentials _credentialFlow;
    OauthPassword _passwordFlow;
    int _OauthMethod = 0;

    void getStatsCallback(OAIHttpRequestWorker *worker);
    void viewMailLogCallback(OAIHttpRequestWorker *worker);

Q_SIGNALS:

    void getStatsSignal(OAIMailStatsType summary);
    void viewMailLogSignal(OAIMailLog summary);


    void getStatsSignalFull(OAIHttpRequestWorker *worker, OAIMailStatsType summary);
    void viewMailLogSignalFull(OAIHttpRequestWorker *worker, OAIMailLog summary);

    Q_DECL_DEPRECATED_X("Use getStatsSignalError() instead")
    void getStatsSignalE(OAIMailStatsType summary, QNetworkReply::NetworkError error_type, QString error_str);
    void getStatsSignalError(OAIMailStatsType summary, QNetworkReply::NetworkError error_type, const QString &error_str);
    Q_DECL_DEPRECATED_X("Use viewMailLogSignalError() instead")
    void viewMailLogSignalE(OAIMailLog summary, QNetworkReply::NetworkError error_type, QString error_str);
    void viewMailLogSignalError(OAIMailLog summary, QNetworkReply::NetworkError error_type, const QString &error_str);

    Q_DECL_DEPRECATED_X("Use getStatsSignalErrorFull() instead")
    void getStatsSignalEFull(OAIHttpRequestWorker *worker, QNetworkReply::NetworkError error_type, QString error_str);
    void getStatsSignalErrorFull(OAIHttpRequestWorker *worker, QNetworkReply::NetworkError error_type, const QString &error_str);
    Q_DECL_DEPRECATED_X("Use viewMailLogSignalErrorFull() instead")
    void viewMailLogSignalEFull(OAIHttpRequestWorker *worker, QNetworkReply::NetworkError error_type, QString error_str);
    void viewMailLogSignalErrorFull(OAIHttpRequestWorker *worker, QNetworkReply::NetworkError error_type, const QString &error_str);

    void abortRequestsSignal();
    void allPendingRequestsCompleted();

public Q_SLOTS:
    void tokenAvailable();
};

} // namespace OpenAPI
#endif
