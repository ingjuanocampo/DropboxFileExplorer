package juanocampo.test.data.sources

import juanocampo.test.data.entity.UserRepo

interface UserRemoteDataSource {
    fun login()
    fun authenticate(): UserRepo?
}