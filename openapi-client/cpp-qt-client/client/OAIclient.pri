QT += network

HEADERS += \
# Models
    $${PWD}/OAIDenyRuleNew.h \
    $${PWD}/OAIDenyRuleRecord.h \
    $${PWD}/OAIEmailAddressName.h \
    $${PWD}/OAIEmailAddressTypes.h \
    $${PWD}/OAIEmailAddressesTypes.h \
    $${PWD}/OAIErrorMessage.h \
    $${PWD}/OAIGenericResponse.h \
    $${PWD}/OAIGetStats_200_response_inner.h \
    $${PWD}/OAIMailAttachment.h \
    $${PWD}/OAIMailBlockClickHouse.h \
    $${PWD}/OAIMailBlockRspamd.h \
    $${PWD}/OAIMailBlocks.h \
    $${PWD}/OAIMailLog.h \
    $${PWD}/OAIMailLogEntry.h \
    $${PWD}/OAIMailOrder.h \
    $${PWD}/OAISendMail.h \
    $${PWD}/OAISendMailAdv.h \
# APIs
    $${PWD}/OAIBlockingApi.h \
    $${PWD}/OAIHistoryApi.h \
    $${PWD}/OAISendingApi.h \
    $${PWD}/OAIServicesApi.h \
    $${PWD}/OAIStatusApi.h \
# Others
    $${PWD}/OAIHelpers.h \
    $${PWD}/OAIHttpRequest.h \
    $${PWD}/OAIObject.h \
    $${PWD}/OAIEnum.h \
    $${PWD}/OAIHttpFileElement.h \
    $${PWD}/OAIServerConfiguration.h \
    $${PWD}/OAIServerVariable.h \
    $${PWD}/OAIOauth.h

SOURCES += \
# Models
    $${PWD}/OAIDenyRuleNew.cpp \
    $${PWD}/OAIDenyRuleRecord.cpp \
    $${PWD}/OAIEmailAddressName.cpp \
    $${PWD}/OAIEmailAddressTypes.cpp \
    $${PWD}/OAIEmailAddressesTypes.cpp \
    $${PWD}/OAIErrorMessage.cpp \
    $${PWD}/OAIGenericResponse.cpp \
    $${PWD}/OAIGetStats_200_response_inner.cpp \
    $${PWD}/OAIMailAttachment.cpp \
    $${PWD}/OAIMailBlockClickHouse.cpp \
    $${PWD}/OAIMailBlockRspamd.cpp \
    $${PWD}/OAIMailBlocks.cpp \
    $${PWD}/OAIMailLog.cpp \
    $${PWD}/OAIMailLogEntry.cpp \
    $${PWD}/OAIMailOrder.cpp \
    $${PWD}/OAISendMail.cpp \
    $${PWD}/OAISendMailAdv.cpp \
# APIs
    $${PWD}/OAIBlockingApi.cpp \
    $${PWD}/OAIHistoryApi.cpp \
    $${PWD}/OAISendingApi.cpp \
    $${PWD}/OAIServicesApi.cpp \
    $${PWD}/OAIStatusApi.cpp \
# Others
    $${PWD}/OAIHelpers.cpp \
    $${PWD}/OAIHttpRequest.cpp \
    $${PWD}/OAIHttpFileElement.cpp \
    $${PWD}/OAIOauth.cpp
