package xyz.thehiddenobject.thoreports.common.infrastructure.persistence.ormlite.user.repository

import com.j256.ormlite.support.ConnectionSource
import xyz.thehiddenobject.thoreports.common.domain.user.User
import xyz.thehiddenobject.thoreports.common.domain.user.UserRepository
import xyz.thehiddenobject.thoreports.common.infrastructure.persistence.mapper.toDomain
import xyz.thehiddenobject.thoreports.common.infrastructure.persistence.mapper.toRecord
import xyz.thehiddenobject.thoreports.common.infrastructure.persistence.ormlite.OrmLiteCrudRepository
import xyz.thehiddenobject.thoreports.common.infrastructure.persistence.ormlite.user.UserRecord
import java.util.UUID

class UserRepositoryImpl(
    connectionSource: ConnectionSource
): UserRepository {
    private val crud = OrmLiteCrudRepository<UserRecord, UUID>(
        connectionSource,
        UserRecord::class
    )

    override fun create(user: User) {
        crud.create(user.toRecord())
    }

    override fun update(user: User) {
        crud.update(user.toRecord())
    }

    override fun findById(id: UUID): User? {
        return crud.findById(id)?.toDomain()
    }

    override fun deleteById(id: UUID) {
        crud.deleteById(id)
    }
}