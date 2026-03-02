package xyz.thehiddenobject.thoreports.common.infrastructure.persistence.ormlite.user

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import java.util.UUID

@DatabaseTable(tableName = "thoreports_users")
data class UserRecord(
    @DatabaseField(id = true)
    val uuid: UUID = UUID.randomUUID(),

    @DatabaseField
    val reportsSent: Int = 0,

    @DatabaseField
    val reportsReceived: Int = 0,

    @DatabaseField
    val trustScore: Int = 100
)