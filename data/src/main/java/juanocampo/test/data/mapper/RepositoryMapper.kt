package juanocampo.test.data.mapper

import juanocampo.test.data.entity.FileBoxRepo
import juanocampo.test.data.entity.UserRepo
import juanocampo.test.domain.entity.FileD
import juanocampo.test.domain.entity.FileIntent
import juanocampo.test.domain.entity.User
import java.io.File

interface RepositoryMapper {

    fun map(user: User?): UserRepo?

    fun map(userRepo: UserRepo?): User?

    fun map(file: FileBoxRepo): FileD

    fun map(result: Pair<String, File>): FileIntent?

}