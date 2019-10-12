package juanocampo.test.data.mapper

import juanocampo.test.data.entity.FileBoxRepo
import juanocampo.test.data.entity.UserRepo
import juanocampo.test.domain.entity.entity.FileD
import juanocampo.test.domain.entity.entity.User

interface RepositoryMapper {

    fun map(user: User?): UserRepo?

    fun map(userRepo: UserRepo?): User?

    fun map(list: List<FileBoxRepo>): List<FileD>?

}