package juanocampo.test.data.sources

import juanocampo.test.data.entity.UserRepo

interface RemoteDataSource {
    fun login()
    fun authenticate(): UserRepo?
}