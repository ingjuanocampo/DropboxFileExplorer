package juanocampo.test.data.sources

import juanocampo.test.data.entity.UserRepo

interface LocalDataSource {
    fun isUserLogged(): Boolean
    fun saveUser(user: UserRepo)
    fun loadUser(): UserRepo?
}