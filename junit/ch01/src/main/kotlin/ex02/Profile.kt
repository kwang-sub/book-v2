package ex02

data class Profile(
    val answers: MutableMap<String, Answer> = mutableMapOf(),
    var score: Int = 0,
    var name: String
) {
    fun add(answer: Answer) {
        answer.getQuestionText()?.let { answers[it] = answer }
    }


}
