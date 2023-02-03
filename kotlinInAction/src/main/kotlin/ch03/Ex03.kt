package ch03

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
//    override fun showOff() = println("오버라이드 안됨!")
}

fun View.showOff() = println("view showOff")
fun Button.showOff() = println("button showOff")

fun main() {
    val view: View = Button()
    view.click()
    view.showOff()
}