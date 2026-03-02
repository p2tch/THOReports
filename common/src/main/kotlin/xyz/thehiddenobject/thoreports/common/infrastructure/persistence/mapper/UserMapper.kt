package xyz.thehiddenobject.thoreports.common.infrastructure.persistence.mapper

import xyz.thehiddenobject.thoreports.common.domain.user.TrustScore
import xyz.thehiddenobject.thoreports.common.domain.user.User
import xyz.thehiddenobject.thoreports.common.infrastructure.persistence.ormlite.user.UserRecord

fun User.toRecord(): UserRecord =
    UserRecord(uuid, reportsSent, reportsReceived, trustScore.value)

fun UserRecord.toDomain(): User =
    User(uuid, reportsSent, reportsReceived, TrustScore(trustScore))