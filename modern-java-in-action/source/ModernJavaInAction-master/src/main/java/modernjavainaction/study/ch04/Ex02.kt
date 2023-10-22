package modernjavainaction.study.ch04

fun main() {
    val title = listOf("Java8", "In", "Action")
    val s = title.stream()
    s.forEach(System.out::println)
    s.forEach(System.out::println)
}