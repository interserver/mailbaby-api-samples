package MailBabyKotlinVertx.apis
import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle
import io.vertx.serviceproxy.ServiceBinder

fun main(){
    Vertx.vertx().deployVerticle(HistoryApiVerticle())
}

class HistoryApiVerticle:AbstractVerticle() {

    override fun start() {
        val instance = (javaClass.classLoader.loadClass("MailBabyKotlinVertx.apis.HistoryApiImpl").newInstance() as HistoryApi)
        instance.init(vertx,config())
        ServiceBinder(vertx)
            .setAddress(HistoryApi.address)
            .register(HistoryApi::class.java,instance)
    }
}