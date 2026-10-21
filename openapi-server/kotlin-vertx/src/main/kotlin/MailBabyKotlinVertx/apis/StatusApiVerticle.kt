package MailBabyKotlinVertx.apis
import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle
import io.vertx.serviceproxy.ServiceBinder

fun main(){
    Vertx.vertx().deployVerticle(StatusApiVerticle())
}

class StatusApiVerticle:AbstractVerticle() {

    override fun start() {
        val instance = (javaClass.classLoader.loadClass("MailBabyKotlinVertx.apis.StatusApiImpl").newInstance() as StatusApi)
        instance.init(vertx,config())
        ServiceBinder(vertx)
            .setAddress(StatusApi.address)
            .register(StatusApi::class.java,instance)
    }
}