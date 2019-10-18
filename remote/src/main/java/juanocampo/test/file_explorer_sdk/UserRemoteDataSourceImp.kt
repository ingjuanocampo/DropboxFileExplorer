package juanocampo.test.file_explorer_sdk

import juanocampo.test.data.entity.UserRepo
import juanocampo.test.data.sources.UserRemoteDataSource
import juanocampo.test.file_explorer_sdk.service.AuthSdk
import juanocampo.test.file_explorer_sdk.service.Client

internal class UserRemoteDataSourceImp(private val authSdk: AuthSdk, private val client: Client) : UserRemoteDataSource {

    override fun login() {
        authSdk.authenticate()
    }

    override fun authenticate(): UserRepo? {

        val tokenAndUId = authSdk.geTokenAndUid() ?: return null
        client.init(tokenAndUId?.first)
        val user = client.getUser()
        return if (user != null)
            UserRepo(
                email = user.email,
                name = user.name.displayName,
                userName = user.accountType.name,
                uiId = tokenAndUId.second,
                token = tokenAndUId.first
            ) else null
    }
}