package juanocampo.test.data.mapper

import juanocampo.test.data.entity.*
import juanocampo.test.domain.entity.*
import java.io.File

internal class RepositoryMapperImpl : RepositoryMapper {

    override fun map(file: FileBoxRepo): FileD {

        val type = when (file.type) {
            is FolderBox -> Folder
            is DocumentBox -> Document
            is ImageBox -> Image
        }
        return FileD(
            fileType = type,
            imagePath = file.pathLower,
            id = file.id,
            name = file.name,
            rev = file.rev
        )

    }

    override fun map(result: Pair<String, File>): FileIntent? =
        FileIntent(result.first, result.second)


    override fun map(user: User?): UserRepo? {
        return if (user != null) UserRepo(
            user.email,
            user.name,
            user.userName,
            user.uiId,
            user.token
        ) else null
    }

    override fun map(userRepo: UserRepo?): User? {
        return if (userRepo != null) User(
            userRepo.email,
            userRepo.name,
            userRepo.userName,
            userRepo.uiId,
            userRepo.token
        ) else null
    }
}