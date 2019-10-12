package juanocampo.test.data

import juanocampo.test.data.mapper.RepositoryMapper
import juanocampo.test.data.sources.LocalDataSource
import juanocampo.test.data.sources.RemoteDataSource
import juanocampo.test.domain.entity.entity.User
import juanocampo.test.domain.entity.repository.UserRepository

class UserRepositoryImpl(private val localDataSource: LocalDataSource,
                         private val remoteDataSource: RemoteDataSource,
                         private val mapper: RepositoryMapper): UserRepository {

    override fun login() {
        remoteDataSource.login()
    }

    override fun loadUser(): User? {
        return if (localDataSource.isUserLogged()) {
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