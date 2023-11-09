package modernjavainaction.study.ch05

import modernjavainaction.base.chap04.Dish
import modernjavainaction.study.ch04.menu
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.stream.IntStream
import kotlin.math.sqrt
import kotlin.streams.toList

class StreamTest2 {
    @Test
    fun 숫자형_스트림() {
        val reduce = menu.stream().map { it.calories }.reduce(0, Integer::sum)
        val sum = menu.sumOf { it.calories }

        assertThat(reduce).isEqualTo(sum)
    }

    @Test
    fun 특화스트림_복원() {
        val intStream = menu.stream().mapToInt(Dish::getCalories)
        val boxed = intStream.boxed()

        val maxCalories = menu.stream().mapToInt(Dish::getCalories)
            .max().orElseGet { 0 }

        val rangeClosed = IntStream.rangeClosed(1, 100).toList()
        val range = IntStream.range(1, 100).toList()

        assertThat(rangeClosed.size).isEqualTo(100)
        assertThat(range.size).isEqualTo(99)
    }

    @Test
    fun 피타고라스() {
        val a = 10
        IntStream.rangeClosed(1, 100)
            .mapToObj { Triple(a, it, sqrt(((a * a + it * it).toDouble()))) }
            .filter { it.third % 1 == 0.0 }
            .forEach(System.out::println)
    }
}