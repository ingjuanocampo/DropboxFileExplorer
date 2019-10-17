package juanocampo.test.domain.repository

import juanocampo.test.domain.entity.User

interface UserRepository {

    fun login()

    fun loadUser(): User?
}