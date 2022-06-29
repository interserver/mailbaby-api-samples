cmake_minimum_required(VERSION 3.2)

project(client)
set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_INCLUDE_CURRENT_DIR ON)
set(CMAKE_AUTOMOC ON)

if (MSVC)
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} /W4")
else ()
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -fPIC -Wall -Wno-unused-variable")
endif ()

find_package(Qt5Core REQUIRED)
find_package(Qt5Network REQUIRED)
find_package(Qt5Gui REQUIRED)

add_library(${PROJECT_NAME}
    OAIGenericResponse.cpp
    OAIGetMailOrders_200_response_inner.cpp
    OAIGetMailOrders_401_response.cpp
    OAIMailLog.cpp
    OAIMailLogEntry.cpp
    OAISendMail.cpp
    OAISendMailAdv.cpp
    OAISendMailAdv_attachments_inner.cpp
    OAISendMailAdv_bcc_inner.cpp
    OAISendMailAdv_cc_inner.cpp
    OAISendMailAdv_from.cpp
    OAISendMailAdv_replyto_inner.cpp
    OAISendMailAdv_to_inner.cpp
    OAIDefaultApi.cpp
    OAIHelpers.cpp
    OAIHttpRequest.cpp
    OAIHttpFileElement.cpp
    OAIOauth.cpp
)
target_link_libraries(${PROJECT_NAME} PRIVATE Qt5::Core Qt5::Network Qt5::Gui)
if(NOT APPLE)
  find_package(OpenSSL REQUIRED)
  target_link_libraries(${PROJECT_NAME} PRIVATE ssl crypto)
endif()

set_property(TARGET ${PROJECT_NAME} PROPERTY CXX_STANDARD 14)
set_property(TARGET ${PROJECT_NAME} PROPERTY CXX_STANDARD_REQUIRED ON)
set_property(TARGET ${PROJECT_NAME} PROPERTY CXX_EXTENSIONS OFF)

install(TARGETS ${PROJECT_NAME} RUNTIME DESTINATION bin LIBRARY DESTINATION lib ARCHIVE DESTINATION lib)
