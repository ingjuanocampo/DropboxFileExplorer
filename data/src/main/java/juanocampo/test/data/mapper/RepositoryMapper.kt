package juanocampo.test.data.mapper

import juanocampo.test.data.entity.UserRepo
import juanocampo.test.domain.entity.entity.User

interface RepositoryMapper {

    fun map(user: User?): UserRepo?

    fun map(userRepo: UserRepo?): User?

}