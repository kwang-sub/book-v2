package ex02

import ex01.Scoreable

class Criterion(

    var weight: Weight,
    var answer: Answer,
    var score: Int = 0,
) : Scoreable {
    override fun getScore(): Int = score
}