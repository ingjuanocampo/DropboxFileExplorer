package juanocampo.test.domain.entity.repository

import juanocampo.test.domain.entity.entity.User

interface UserRepository {

    fun login()

    fun loadUser(): User?
}