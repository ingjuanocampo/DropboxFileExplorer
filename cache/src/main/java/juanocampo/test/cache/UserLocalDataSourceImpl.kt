package juanocampo.test.cache

import juanocampo.test.data.entity.UserRepo
import juanocampo.test.data.sources.UserLocalDataSource

internal class UserLocalDataSourceImpl: UserLocalDataSource {

    private var userRepo: UserRepo? = null

    override fun isUserLogged(): Boolean {
        return userRepo != null
    }

    override fun saveUser(user: UserRepo) {
        this.userRepo = userRepo
    }

    override fun loadUser(): UserRepo? = userRepo
}