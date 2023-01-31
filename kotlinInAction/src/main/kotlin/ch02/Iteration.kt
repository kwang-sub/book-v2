package ch02

import com.sun.jdi.IntegerType
import java.io.BufferedReader
import java.io.IOException
import java.io.StringReader
import java.lang.NumberFormatException
import java.util.TreeMap
import javax.print.attribute.IntegerSyntax


fun main() {
//    for (i in 1..100) {
//        println(fizzBuzz(i))
//    }

//    for (i in 0 until  100 step 2) {
//        println(fizzBuzz(i))
//    }

//    val binaryReps = TreeMap<Char, String>()
//    for (c in 'A'..'F') {
//        val binary = Integer.toBinaryString(c.code)
//        binaryReps[c] = binary
//    }
//
//    for ((letter, binary) in binaryReps) {
//        println("$letter = $binary")
//    }

    val list = arrayListOf("10", "12", "13")
    for ((index, value) in list.withIndex()) {
        println(value)
    }

    println(isLetter('q'))
    println(recognize(1))

    val bufferedReader = BufferedReader(StringReader("2d4"))
    println(readNumber(bufferedReader))
    println(readNumberV2(bufferedReader))
}

fun fizzBuzz(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun recognize(c: Any) = when (c) {
    in 0..9 -> "digit"
    in 'a'..'z', in 'A'..'Z' -> "letter"
    else -> "?"
}

fun readNumber (reader: BufferedReader): Int? {
    return try {
        val line = reader.readLine()
        Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }
}

fun readNumberV2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    } catch (e: IOException) {
        null
    }
    print(number)
}