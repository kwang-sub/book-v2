package ch04

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class PersonV2(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): PersonV2 = PersonV2(jsonText);
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class PersonV3(val name: String) {
    companion object : JSONFactory<PersonV3> {
        override fun fromJSON(jsonText: String): PersonV3 = PersonV3(jsonText)
    }
}

data class PersonV4(val firstName: String, val lastName: String) {
    companion object {}
}

fun PersonV4.Companion.fromJSON(json: String): PersonV4 {
    println("확장함수~")
    return PersonV4(json, json)
}

val listener = object : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent?) {
        super.mouseClicked(e)
    }

    override fun mousePressed(e: MouseEvent?) {
        super.mousePressed(e)
    }
}

fun main() {
    val person = PersonV2.Loader.fromJSON("kwang")
    println(person.name)

    val person2 = PersonV2.fromJSON("kwang2")
    println(person2.name)
    println(Singleton.TEST_STRING)

    val person3 = PersonV3.fromJSON("kwang3")
    println(person3.name)

    println(PersonV4.fromJSON("kwang"))
}