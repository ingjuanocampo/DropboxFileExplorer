package juanocampo.test.data.mapper

import juanocampo.test.data.entity.UserRepo
import juanocampo.test.domain.entity.entity.User

class RepositoryMapperImpl: RepositoryMapper {

    override fun map(user: User?): UserRepo? {
        return if (user != null) UserRepo(user.email, user.name, user.userName, user.uiId, user.token) else null
    }

    override fun map(userRepo: UserRepo?): User? {
        return if (userRepo!= null) User(userRepo.email, userRepo.name, userRepo.userName, userRepo.uiId, userRepo.token) else null
    }
}