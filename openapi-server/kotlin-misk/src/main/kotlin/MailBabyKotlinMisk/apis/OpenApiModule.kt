package MailBabyKotlinMisk.apis

import misk.inject.KAbstractModule
import misk.web.WebActionModule
import jakarta.inject.Singleton
import MailBabyKotlinMisk.apis.BlockingApiAction
import MailBabyKotlinMisk.apis.HistoryApiAction
import MailBabyKotlinMisk.apis.SendingApiAction
import MailBabyKotlinMisk.apis.ServicesApiAction
import MailBabyKotlinMisk.apis.StatusApiAction

@Singleton
class OpenApiModule : KAbstractModule() {
    override fun configure() {
        install(WebActionModule.create<BlockingApiAction>())
        install(WebActionModule.create<HistoryApiAction>())
        install(WebActionModule.create<SendingApiAction>())
        install(WebActionModule.create<ServicesApiAction>())
        install(WebActionModule.create<StatusApiAction>())
    }
}