package ch03

fun main() {
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split('.'))
    println("12.345-6.A".split('.', '-', limit = 2))
    parsePathV2("/Users/yole/kotlin-book/chapter.adoc")

    val kotlinLogo = """
        
                              .|  //
                              .| //
                              .|/ \
                            """.trimMargin()
    println(kotlinLogo)

}

fun parsePathV1 (path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun parsePathV2(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}