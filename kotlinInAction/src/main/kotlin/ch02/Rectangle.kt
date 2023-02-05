package geometry.shapes

import java.util.Random
import kotlin.math.absoluteValue

class Rectangle(
    val height: Int,
    val width: Int) {

    val isSquare: Boolean
        get() =  height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt().absoluteValue, random.nextInt().absoluteValue)
}