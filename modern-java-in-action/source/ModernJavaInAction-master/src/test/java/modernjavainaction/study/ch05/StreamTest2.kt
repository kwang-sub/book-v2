package modernjavainaction.study.ch05

import modernjavainaction.study.ch04.menu
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StreamTest2 {
    @Test
    fun 숫자형_스트림() {
        val reduce = menu.stream().map { it.calories }.reduce(0, Integer::sum)
        val sum = menu.sumOf { it.calories }

        assertThat(reduce).isEqualTo(sum)
    }
}