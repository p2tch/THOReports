package xyz.thehiddenobject.thoreports.common.application

import xyz.thehiddenobject.thoreports.common.domain.user.User
import xyz.thehiddenobject.thoreports.common.domain.user.UserRepository
import java.util.UUID

class UserService(
    val userRepository: UserRepository
) {
    fun create(user: User) =
        userRepository.create(user)

    fun update(user: User) =
        userRepository.update(user)

    fun findById(id: UUID): User? =
        userRepository.findById(id)

    fun deleteById(id: UUID) =
        userRepository.deleteById(id)
}