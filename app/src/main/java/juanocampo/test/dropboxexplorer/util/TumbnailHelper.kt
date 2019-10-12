package juanocampo.test.dropboxexplorer.util

import com.squareup.picasso.Picasso
import com.squareup.picasso.Request
import com.squareup.picasso.RequestHandler
import okio.Okio
import java.lang.Exception
/*
class TumbnailHelper(private val scheme: String,
                     private val host: String,
                     private val loader: mDbxClient
): RequestHandler() {

    override fun canHandleRequest(data: Request?): Boolean {
        return scheme == data?.uri?.scheme && host == data?.uri?.host
    }

    override fun load(request: Request?, networkPolicy: Int): Result? {
        return try {

            val downloader = loader.files().getThumbnailBuilder(request.uri.path!!)
                .withFormat(ThumbnailFormat.JPEG)
                .withSize(ThumbnailSize.W1024H768)
                .start()

            return RequestHandler.Result(
                Okio.source(downloader.getInputStream()),
                Picasso.LoadedFrom.NETWORK
            )
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }



}*/

