QT += network

HEADERS += \
# Models
    $${PWD}/OAIErrorResponse.h \
    $${PWD}/OAIGenericResponse.h \
    $${PWD}/OAIMailAttachment.h \
    $${PWD}/OAIMailContact.h \
    $${PWD}/OAIMailLog.h \
    $${PWD}/OAIMailOrder.h \
    $${PWD}/OAISendMail.h \
    $${PWD}/OAISendMailAdv.h \
    $${PWD}/OAISendMailAdv_from.h \
# APIs
    $${PWD}/OAIDefaultApi.h \
# Others
    $${PWD}/OAIHelpers.h \
    $${PWD}/OAIHttpRequest.h \
    $${PWD}/OAIObject.h \
    $${PWD}/OAIEnum.h \
    $${PWD}/OAIHttpFileElement.h \
    $${PWD}/OAIServerConfiguration.h \
    $${PWD}/OAIServerVariable.h

SOURCES += \
# Models
    $${PWD}/OAIErrorResponse.cpp \
    $${PWD}/OAIGenericResponse.cpp \
    $${PWD}/OAIMailAttachment.cpp \
    $${PWD}/OAIMailContact.cpp \
    $${PWD}/OAIMailLog.cpp \
    $${PWD}/OAIMailOrder.cpp \
    $${PWD}/OAISendMail.cpp \
    $${PWD}/OAISendMailAdv.cpp \
    $${PWD}/OAISendMailAdv_from.cpp \
# APIs
    $${PWD}/OAIDefaultApi.cpp \
# Others
    $${PWD}/OAIHelpers.cpp \
    $${PWD}/OAIHttpRequest.cpp \
    $${PWD}/OAIHttpFileElement.cpp

