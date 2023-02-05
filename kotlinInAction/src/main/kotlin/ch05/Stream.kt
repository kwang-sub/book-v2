package ch05

val canBeInClub27 = {p: Person -> p.age <= 27}

fun main() {
    val list = listOf<Int>(1, 2, 3, 4)
    val people = listOf<Person>(Person("kwang1", 12), Person("kwang2", 22), Person("kwang4", 22), Person("kwang3", 13))
    println(list.filter { it % 2 == 0 })
    println(people.filter { it.age > 20 }.map(Person::name))

    val maxAge = people.maxBy(Person::age).age
    println(people.filter { it.age == maxAge })

    println(people.all(canBeInClub27))
}