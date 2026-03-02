package xyz.thehiddenobject.thoreports.common.domain.user

import java.util.UUID

@JvmInline
value class TrustScore(val value: Int)

data class User(
    val uuid: UUID,
    val reportsSent: Int,
    val reportsReceived: Int,
    val trustScore: TrustScore
)
