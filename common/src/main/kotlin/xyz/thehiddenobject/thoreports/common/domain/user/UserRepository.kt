package xyz.thehiddenobject.thoreports.common.domain.user

import java.util.UUID

interface UserRepository {
    fun create(user: User)
    fun update(user: User)
    fun findById(id: UUID): User?
    fun deleteById(id: UUID)
}