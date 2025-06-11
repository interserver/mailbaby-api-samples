cmake_minimum_required(VERSION 3.5)

project(QtOpenAPIClient)

set(CMAKE_AUTOMOC ON)

find_package(QT NAMES Qt6 Qt5 REQUIRED COMPONENTS Core Network Gui)
find_package(Qt${QT_VERSION_MAJOR} REQUIRED COMPONENTS Core Network Gui)

include(GNUInstallDirs)
include(CMakePackageConfigHelpers)

add_library(${PROJECT_NAME}
  OAIDenyRuleNew.h
  OAIDenyRuleRecord.h
  OAIEmailAddressName.h
  OAIEmailAddressTypes.h
  OAIEmailAddressesTypes.h
  OAIErrorMessage.h
  OAIGenericResponse.h
  OAIMailAttachment.h
  OAIMailBlockClickHouse.h
  OAIMailBlockRspamd.h
  OAIMailBlocks.h
  OAIMailLog.h
  OAIMailLogEntry.h
  OAIMailOrder.h
  OAIMailStatsType.h
  OAIMailStatsType_volume.h
  OAIMailStatsType_volume_from.h
  OAIMailStatsType_volume_ip.h
  OAIMailStatsType_volume_to.h
  OAISendMail.h
  OAISendMailAdv.h
  OAIBlockingApi.h
  OAIHistoryApi.h
  OAISendingApi.h
  OAIServicesApi.h
  OAIStatusApi.h
  OAIHelpers.h
  OAIHttpRequest.h
  OAIObject.h
  OAIEnum.h
  OAIHttpFileElement.h
  OAIServerConfiguration.h
  OAIServerVariable.h
  OAIOauth.h
  OAIDenyRuleNew.cpp
  OAIDenyRuleRecord.cpp
  OAIEmailAddressName.cpp
  OAIEmailAddressTypes.cpp
  OAIEmailAddressesTypes.cpp
  OAIErrorMessage.cpp
  OAIGenericResponse.cpp
  OAIMailAttachment.cpp
  OAIMailBlockClickHouse.cpp
  OAIMailBlockRspamd.cpp
  OAIMailBlocks.cpp
  OAIMailLog.cpp
  OAIMailLogEntry.cpp
  OAIMailOrder.cpp
  OAIMailStatsType.cpp
  OAIMailStatsType_volume.cpp
  OAIMailStatsType_volume_from.cpp
  OAIMailStatsType_volume_ip.cpp
  OAIMailStatsType_volume_to.cpp
  OAISendMail.cpp
  OAISendMailAdv.cpp
  OAIBlockingApi.cpp
  OAIHistoryApi.cpp
  OAISendingApi.cpp
  OAIServicesApi.cpp
  OAIStatusApi.cpp
  OAIHelpers.cpp
  OAIHttpRequest.cpp
  OAIHttpFileElement.cpp
  OAIOauth.cpp
  )

target_include_directories(${PROJECT_NAME}
    PUBLIC
        $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}>
        $<INSTALL_INTERFACE:${CMAKE_INSTALL_INCLUDEDIR}>
)

target_link_libraries(${PROJECT_NAME}
    PUBLIC
        Qt${QT_VERSION_MAJOR}::Core
        Qt${QT_VERSION_MAJOR}::Network
        Qt${QT_VERSION_MAJOR}::Gui

)

configure_package_config_file(${CMAKE_CURRENT_SOURCE_DIR}/Config.cmake.in
    "${CMAKE_CURRENT_BINARY_DIR}/${PROJECT_NAME}Config.cmake"
    INSTALL_DESTINATION "${CMAKE_INSTALL_LIBDIR}/cmake/${PROJECT_NAME}"
)

install(
    TARGETS ${PROJECT_NAME}
    EXPORT ${PROJECT_NAME}Targets
    LIBRARY DESTINATION "${CMAKE_INSTALL_LIBDIR}"
    ARCHIVE DESTINATION "${CMAKE_INSTALL_LIBDIR}"
    RUNTIME DESTINATION "${CMAKE_INSTALL_BINDIR}"
    INCLUDES DESTINATION "${CMAKE_INSTALL_INCLUDEDIR}/${PROJECT_NAME}"
)

install(
    FILES ${HEADER_FILES}
    DESTINATION ${CMAKE_INSTALL_INCLUDEDIR}/${PROJECT_NAME}
)

install(
    FILES "${CMAKE_CURRENT_BINARY_DIR}/${PROJECT_NAME}Config.cmake"
    DESTINATION ${CMAKE_INSTALL_LIBDIR}/cmake/${PROJECT_NAME}
)

install(
    EXPORT ${PROJECT_NAME}Targets
    DESTINATION ${CMAKE_INSTALL_LIBDIR}/cmake/${PROJECT_NAME}
)
