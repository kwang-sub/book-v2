package ch04

open class RichButton: Clickable {

    fun disable() {} // 상속불가능

    open fun animate() {} // 상속가능

    final override fun click() {} // 구현, 상속한 메서드는 기본적으로 상속가능 final을 통해 상속불가능 선언
}