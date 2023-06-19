package ex03

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AssertTest {

    private lateinit var str: String
    @BeforeEach
    fun init() {
        str = "kwang"
    }

    @Test
    fun assertTest() {
        assertTrue(str != null)
        assertTrue(str == "kwang")

        assertEquals(str, "kwang")
        assertEquals(str.startsWith("k"), true)

        val list1 = mutableListOf("k", "k1")
        val list2 = mutableListOf("k", "k1")
        assertLinesMatch(list1, list2)

        assertNotEquals(str, "k")

        assertNotEquals(2.32 * 3, 6.96)
        assertEquals(Math.abs((2.32 * 3) - 6.96) < 0.0005, true)
        assertEquals(1, 1,"1은 1이다")
    }
}