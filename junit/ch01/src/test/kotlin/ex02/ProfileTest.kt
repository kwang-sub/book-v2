package ex02

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class ProfileTest {

    @Test
    fun matchAnswersFalseWhenMustMathCriteriaNotNet() {
        val profile = Profile("Bull Hockey, Inc")
        val question = BooleanQuestion(1, "Got bonuses?")
        val profileAnswer = Answer(question, Bool.FALSE)
        profile.add(profileAnswer)
        val criteria = Criteria()
        val criteriaAnswer = Answer(question, Bool.TRUE)
        val criterion = Criterion(criteriaAnswer, Weight.MustMatch)
        criteria.add(criterion)

        val matches = profile.matches(criteria)
        assertFalse(matches)
    }

}