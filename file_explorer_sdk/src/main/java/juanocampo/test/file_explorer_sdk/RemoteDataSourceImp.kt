package juanocampo.test.file_explorer_sdk

import android.content.Context
import com.dropbox.core.android.Auth
import com.dropbox.core.v2.DbxClientV2
import juanocampo.test.data.entity.UserRepo
import juanocampo.test.data.sources.RemoteDataSource
import juanocampo.test.file_explorer_sdk.service.DropboxClientFactory
import juanocampo.test.file_explorer_sdk.service.PicassoClient

class RemoteDataSourceImp(private val context: Context) : RemoteDataSource {

    private var client: DbxClientV2? = null

    override fun login() {
        Auth.startOAuth2Authentication(context, context.getString(R.string.app_key))
    }

    override fun authenticate(): UserRepo? {
        val accessToken = Auth.getOAuth2Token()
        val uid = Auth.getUid()

        DropboxClientFactory.init(accessToken)
        PicassoClient.init(context, client)

        client = DropboxClientFactory.getClient()

        val user = client?.users()?.currentAccount
        return if (user != null)
            UserRepo(
                email = user.email,
                name = user.name.displayName,
                userName = user.accountType.name,
                uiId = uid,
                token = accessToken
            ) else null
    }
}