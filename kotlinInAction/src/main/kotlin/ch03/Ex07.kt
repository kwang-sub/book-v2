package ch03

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

fun saveUserV1(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id} : empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
}

fun saveUserV2(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id} : empty ${fieldName}")
        }
    }
}

fun saveUserV3(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id} : empty ${fieldName}")
        }
    }
}

fun User.saveUserV4() {

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${this.id} : empty ${fieldName}")
        }
    }
    validate(this.name, "name")
    validate(this.address, "address")
}

fun main() {
    val user: User = User(1, "kwang", "")
    user.saveUserV4()
}