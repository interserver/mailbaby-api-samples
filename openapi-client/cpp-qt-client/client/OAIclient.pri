QT += network

HEADERS += \
# Models
    $${PWD}/OAIGenericResponse.h \
    $${PWD}/OAIGetMailOrders_200_response_inner.h \
    $${PWD}/OAIGetMailOrders_401_response.h \
    $${PWD}/OAIMailLog.h \
    $${PWD}/OAIMailLogEntry.h \
    $${PWD}/OAISendMail.h \
    $${PWD}/OAISendMailAdv.h \
    $${PWD}/OAISendMailAdv_attachments_inner.h \
    $${PWD}/OAISendMailAdv_bcc_inner.h \
    $${PWD}/OAISendMailAdv_cc_inner.h \
    $${PWD}/OAISendMailAdv_from.h \
    $${PWD}/OAISendMailAdv_replyto_inner.h \
    $${PWD}/OAISendMailAdv_to_inner.h \
# APIs
    $${PWD}/OAIDefaultApi.h \
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
    $${PWD}/OAIGenericResponse.cpp \
    $${PWD}/OAIGetMailOrders_200_response_inner.cpp \
    $${PWD}/OAIGetMailOrders_401_response.cpp \
    $${PWD}/OAIMailLog.cpp \
    $${PWD}/OAIMailLogEntry.cpp \
    $${PWD}/OAISendMail.cpp \
    $${PWD}/OAISendMailAdv.cpp \
    $${PWD}/OAISendMailAdv_attachments_inner.cpp \
    $${PWD}/OAISendMailAdv_bcc_inner.cpp \
    $${PWD}/OAISendMailAdv_cc_inner.cpp \
    $${PWD}/OAISendMailAdv_from.cpp \
    $${PWD}/OAISendMailAdv_replyto_inner.cpp \
    $${PWD}/OAISendMailAdv_to_inner.cpp \
# APIs
    $${PWD}/OAIDefaultApi.cpp \
# Others
    $${PWD}/OAIHelpers.cpp \
    $${PWD}/OAIHttpRequest.cpp \
    $${PWD}/OAIHttpFileElement.cpp \
    $${PWD}/OAIOauth.cpp
