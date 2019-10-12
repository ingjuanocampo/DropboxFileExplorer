package juanocampo.test.data.mapper

import juanocampo.test.data.entity.*
import juanocampo.test.domain.entity.entity.*

class RepositoryMapperImpl: RepositoryMapper {

    override fun map(list: List<FileBoxRepo>): List<FileD>? {
        return list.map {
            val type = when (it.type) {
                is FolderBox -> Folder
                is DocumentBox -> Document
                is ImageBox -> Image
            }
            FileD(fileType = type, imagePath = it.pathLower, id = it.id, name = it.name)
        }
    }

    override fun map(user: User?): UserRepo? {
        return if (user != null) UserRepo(user.email, user.name, user.userName, user.uiId, user.token) else null
    }

    override fun map(userRepo: UserRepo?): User? {
        return if (userRepo!= null) User(userRepo.email, userRepo.name, userRepo.userName, userRepo.uiId, userRepo.token) else null
    }
}