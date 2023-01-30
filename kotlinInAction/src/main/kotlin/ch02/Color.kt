package ch02

enum class Color (
    val r: Int, val g: Int, val b: Int
){
    RED(255, 0, 0), ORANGE(255, 0, 0), YELLOW(255, 0, 0), GREEN(255, 0, 0),
    BLUE(255, 0, 0), INDIGO(255, 0, 0), VIOLET(255, 0, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}