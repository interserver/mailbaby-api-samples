package MailBabyKotlinServer

import io.ktor.server.routing.*
import MailBabyKotlinServer.apis.BlockingApi
import MailBabyKotlinServer.apis.HistoryApi
import MailBabyKotlinServer.apis.SendingApi
import MailBabyKotlinServer.apis.ServicesApi
import MailBabyKotlinServer.apis.StatusApi



fun Route.AllApis() {
    BlockingApi()
    HistoryApi()
    SendingApi()
    ServicesApi()
    StatusApi()
}
