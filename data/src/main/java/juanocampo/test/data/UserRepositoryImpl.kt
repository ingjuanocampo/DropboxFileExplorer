package juanocampo.test.data

import juanocampo.test.data.mapper.RepositoryMapper
import juanocampo.test.data.sources.UserLocalDataSource
import juanocampo.test.data.sources.UserRemoteDataSource
import juanocampo.test.domain.entity.entity.User
import juanocampo.test.domain.entity.repository.UserRepository

class UserRepositoryImpl(private val localDataSource: UserLocalDataSource,
                         private val remoteDataSource: UserRemoteDataSource,
                         private val mapper: RepositoryMapper): UserRepository {

    override fun login() {
        remoteDataSource.login()
    }

    override fun loadUser(): User? {
        return if (!localDataSource.isUserLogged()) {
            val user = remoteDataSource.authenticate()
            if (user != null) {
                localDataSource.saveUser(user)
            }
            mapper.map(user)
        } else {
            val user = localDataSource.loadUser()
            mapper.map(user)
        }
    }
}