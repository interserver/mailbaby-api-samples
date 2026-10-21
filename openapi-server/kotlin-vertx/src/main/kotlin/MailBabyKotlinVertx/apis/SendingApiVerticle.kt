package MailBabyKotlinVertx.apis
import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle
import io.vertx.serviceproxy.ServiceBinder

fun main(){
    Vertx.vertx().deployVerticle(SendingApiVerticle())
}

class SendingApiVerticle:AbstractVerticle() {

    override fun start() {
        val instance = (javaClass.classLoader.loadClass("MailBabyKotlinVertx.apis.SendingApiImpl").newInstance() as SendingApi)
        instance.init(vertx,config())
        ServiceBinder(vertx)
            .setAddress(SendingApi.address)
            .register(SendingApi::class.java,instance)
    }
}