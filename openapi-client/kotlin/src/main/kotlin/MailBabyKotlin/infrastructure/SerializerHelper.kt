package MailBabyKotlin.infrastructure

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.EnumJsonAdapter

object SerializerHelper {
    fun addEnumUnknownDefaultCase(moshiBuilder: Moshi.Builder): Moshi.Builder {
        return moshiBuilder
            .add(MailBabyKotlin.models.DenyRuleNew.Type::class.java, EnumJsonAdapter.create(MailBabyKotlin.models.DenyRuleNew.Type::class.java)
                .withUnknownFallback(MailBabyKotlin.models.DenyRuleNew.Type.unknown_default_open_api).nullSafe())
            .add(MailBabyKotlin.models.DenyRuleRecord.Type::class.java, EnumJsonAdapter.create(MailBabyKotlin.models.DenyRuleRecord.Type::class.java)
                .withUnknownFallback(MailBabyKotlin.models.DenyRuleRecord.Type.unknown_default_open_api).nullSafe())
            .add(MailBabyKotlin.models.MailOrder.Status::class.java, EnumJsonAdapter.create(MailBabyKotlin.models.MailOrder.Status::class.java)
                .withUnknownFallback(MailBabyKotlin.models.MailOrder.Status.unknown_default_open_api).nullSafe())
            .add(MailBabyKotlin.models.MailOrderDetail.Status::class.java, EnumJsonAdapter.create(MailBabyKotlin.models.MailOrderDetail.Status::class.java)
                .withUnknownFallback(MailBabyKotlin.models.MailOrderDetail.Status.unknown_default_open_api).nullSafe())
            .add(MailBabyKotlin.models.MailStatsType.Time::class.java, EnumJsonAdapter.create(MailBabyKotlin.models.MailStatsType.Time::class.java)
                .withUnknownFallback(MailBabyKotlin.models.MailStatsType.Time.unknown_default_open_api).nullSafe())
    }
}
