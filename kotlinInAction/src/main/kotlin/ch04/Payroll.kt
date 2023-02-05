package ch04

import ch01.Person

object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {
            println("값 확인 $person")
        }
    }
}

fun main() {
    Payroll.allEmployees.add(Person("kwang", 12))
    Payroll.calculateSalary()
}