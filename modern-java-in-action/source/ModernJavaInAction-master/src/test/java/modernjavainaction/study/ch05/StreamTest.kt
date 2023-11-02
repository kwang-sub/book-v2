package modernjavainaction.study.ch05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StreamTest {

    @Test
    fun 중복제거() {
        val list = listOf(1, 2, 1, 3, 3, 2, 4)
        val result = list.filter { it % 2 == 0 }
            .distinct()

        assertThat(result).allMatch { it % 2 == 0 }
        assertThat(result.size).isEqualTo(result.toSet().size)
    }

    @Test
    fun takeWhile() {
        val filteredMenu = specialMenu.filter { it.calories < 320 }
        val slicedMenu1 = specialMenu.takeWhile { it.calories < 320 }

        assertThat(filteredMenu).isNotEqualTo(slicedMenu1)
    }

    @Test
    fun dropWhile() {
        val dropWhile = specialMenu.dropWhile { it.calories < 320 }
        assertThat(dropWhile).anyMatch{it.calories < 320}
    }

    @Test
    fun limit() {
        val take = specialMenu.take(3)
        assertThat(take.size).isEqualTo(3)
    }
}