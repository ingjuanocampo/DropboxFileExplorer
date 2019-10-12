package juanocampo.test.domain.entity.status

import juanocampo.test.domain.entity.entity.User

sealed class UserStatus
data class UserAuthenticated(val user: User): UserStatus()
object UserNotLogged: UserStatus()
object UserError: UserStatus()