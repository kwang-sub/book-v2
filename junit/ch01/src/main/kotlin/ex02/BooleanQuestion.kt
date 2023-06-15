package ex02

class BooleanQuestion(
    var id: Int,
    var text: String
) : Question(id = id, text = text, answerChoices = arrayOf("NO", "YES")) {

    override fun match(expected: Int, actual: Int): Boolean = expected == actual
}