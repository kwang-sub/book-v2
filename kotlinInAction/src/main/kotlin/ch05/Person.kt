package ch05

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = Int.MIN_VALUE
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            theOldest = person
        }
    }
    println(theOldest)
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0;
    var serverErrors = 0;

    response.forEach {
        if (it.startsWith("4")) clientErrors++
        else if (it.startsWith("5")) serverErrors++
    }

    println("client $clientErrors")
    println("server $serverErrors")
}

fun salute() = println("salute")

val action = {person: Person, message: String -> sendEmail(person, message)}
val nextAction = ::sendEmail
fun sendEmail(person: Person, message: String) {}

fun main() {
    val people = listOf<Person>(Person("kwang", 12), Person("kwang1", 15))
    findTheOldest(people)
    println(people.maxBy { it.age })
    println(people.maxBy(Person::age))

    val names = people.joinToString(separator = " ", transform = { it.name })
    println(names)

    val sum = { x: Int, y: Int ->
        println("$x + $y = ${x + y}")
        x + y
    }
    val result = sum(2, 4)
    println(result)

    val errors = listOf<String>("403", "404", "500")
    printMessagesWithPrefix(errors, "Error:")
    printProblemCounts(errors)

    run (::salute)
}