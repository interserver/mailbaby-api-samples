package MailBabyKotlinVertx.apis
import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle
import io.vertx.serviceproxy.ServiceBinder

fun main(){
    Vertx.vertx().deployVerticle(ServicesApiVerticle())
}

class ServicesApiVerticle:AbstractVerticle() {

    override fun start() {
        val instance = (javaClass.classLoader.loadClass("MailBabyKotlinVertx.apis.ServicesApiImpl").newInstance() as ServicesApi)
        instance.init(vertx,config())
        ServiceBinder(vertx)
            .setAddress(ServicesApi.address)
            .register(ServicesApi::class.java,instance)
    }
}