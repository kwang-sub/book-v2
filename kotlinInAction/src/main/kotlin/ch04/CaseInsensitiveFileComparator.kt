package ch04

import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {

    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

fun main() {
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
    val files = listOf<File>(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}