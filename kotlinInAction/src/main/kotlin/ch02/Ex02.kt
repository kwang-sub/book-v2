package ch02

import geometry.shapes.Rectangle
import geometry.shapes.createRandomRectangle

fun main() {
    val personV2 = PersonV2("kwang", true)
    println(personV2.name)
    println(personV2.isMarried)

    personV2.isMarried = false
    println(personV2.isMarried)

    val rectangle: Rectangle = Rectangle(33, 33)

    println("값 확인 ${rectangle.isSquare}")

    val result = createRandomRectangle()
    println(result.height)
    println(result.width)
    println(result.isSquare)

    val rgb = Color.BLUE
    println(rgb.rgb())

    val test = getMnemonic(Color.ORANGE)
    println(test)
}