package xyz.thehiddenobject.thoreports.common.infrastructure.persistence.ormlite.user.repository

import com.github.benmanes.caffeine.cache.Caffeine
import xyz.thehiddenobject.thoreports.common.domain.user.User
import xyz.thehiddenobject.thoreports.common.domain.user.UserRepository
import java.util.UUID
import java.util.concurrent.TimeUnit

class CachedUserRepositoryImpl(
    val delegate: UserRepository
): UserRepository {
    private val cache = Caffeine.newBuilder()
        .expireAfterWrite(10, TimeUnit.MINUTES)
        .maximumSize(1000)
        .build<UUID, User>()

    override fun create(user: User) {
        delegate.create(user)
        cache.put(user.uuid, user)
    }

    override fun update(user: User) {
        delegate.update(user)
        cache.put(user.uuid, user)
    }

    override fun findById(id: UUID): User? {
        val cached = cache.getIfPresent(id)
        if (cached != null) return cached

        val user = delegate.findById(id) ?: return null
        cache.put(id, user)
        return user
    }

    override fun deleteById(id: UUID) {
        delegate.deleteById(id)
        cache.invalidate(id)
    }
}