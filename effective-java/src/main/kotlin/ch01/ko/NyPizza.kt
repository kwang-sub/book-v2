package ch01.ko

//data class NyPizza(
//    var size: Size,
//    var builder: Builder<*>
//) : Pizza(builder) {
//    enum class Size {
//        SMALL, MEDIUM, LARGE
//    }
//
//    companion object {
//        class Builder<T>(
//            val size: Size,
//        ) : Pizza.Builder<Builder<Any>>() {
//            override fun self(): Pizza.Builder<*> {
//                return this
//            }
//            override fun build(): Pizza {
//                return NyPizza(this.size, this)
//            }
//        }
//    }
//
//    override fun toString(): String {
//        return super.toString() + "NyPizza(size=$size)"
//    }
//
//
//}