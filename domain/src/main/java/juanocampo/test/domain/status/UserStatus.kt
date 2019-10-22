package juanocampo.test.domain.status

import juanocampo.test.domain.entity.User

sealed class UserStatus
data class UserAuthenticated(val user: User): UserStatus()
object UserNotLogged: UserStatus()
object UserError: UserStatus()