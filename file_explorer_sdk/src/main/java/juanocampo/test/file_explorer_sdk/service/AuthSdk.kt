package juanocampo.test.file_explorer_sdk.service

interface AuthSdk {

    fun authenticate()

    fun geTokenAndUid(): Pair<String, String>?

}