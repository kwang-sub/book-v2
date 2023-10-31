package modernjavainaction.study.ch04

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class StreamTest {
    @Test
    fun 스트림_기본() {
        val result = menu.filter { it.calories < 400 }
            .sortedBy { it.calories }
            .toList()

        assertThat(result.size).isEqualTo(3)
        assertThat(result).allMatch { it.calories < 400 }
    }

    @Test
    fun 파이프라인() {
        val result = menu.filter { it.calories > 300 }
            .map { it.name }
            .take(3)
            .toList()

        assertThat(result.size).isEqualTo(3)
        assertThat(result).containsAll(listOf("pork", "beef", "chicken"))
    }

}