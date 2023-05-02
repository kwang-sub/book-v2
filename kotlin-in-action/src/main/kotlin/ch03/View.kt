package ch03

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}


fun View.showOff() = println("I'm a view!")

fun Button.showOff() = println("I'm a button!")