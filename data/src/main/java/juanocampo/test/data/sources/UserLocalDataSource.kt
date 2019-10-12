package juanocampo.test.data.sources

import juanocampo.test.data.entity.UserRepo

interface UserLocalDataSource {
    fun isUserLogged(): Boolean
    fun saveUser(user: UserRepo)
    fun loadUser(): UserRepo?
}