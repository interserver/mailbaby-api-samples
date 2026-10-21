package MailBabyKotlinVertx.apis
import io.vertx.core.Vertx
import io.vertx.core.AbstractVerticle
import io.vertx.serviceproxy.ServiceBinder

fun main(){
    Vertx.vertx().deployVerticle(BlockingApiVerticle())
}

class BlockingApiVerticle:AbstractVerticle() {

    override fun start() {
        val instance = (javaClass.classLoader.loadClass("MailBabyKotlinVertx.apis.BlockingApiImpl").newInstance() as BlockingApi)
        instance.init(vertx,config())
        ServiceBinder(vertx)
            .setAddress(BlockingApi.address)
            .register(BlockingApi::class.java,instance)
    }
}