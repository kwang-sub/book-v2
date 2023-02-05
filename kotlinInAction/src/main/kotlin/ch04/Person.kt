package ch04


data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

fun main() {
    val persons = listOf<ch04.Person>(ch04.Person("kwang"), ch04.Person("Asub"))
    println(persons.sortedWith(ch04.Person.NameComparator))

    A.bar()
}
