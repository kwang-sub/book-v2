package ex02

class PercentileQuestion(
    var id: Int,
    var text: String,
    var answerChoices: Array<String>
) : Question(text, answerChoices, id) {

    override fun match(expected: Int, actual: Int): Boolean = expected <= actual
}