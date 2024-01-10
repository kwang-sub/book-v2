package org.example.querydsl

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.example.querydsl.domain.Member
import org.example.querydsl.domain.QMember.member
import org.example.querydsl.domain.QTeam.team
import org.example.querydsl.domain.Team
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class QuerydslBasicTest {

    @Autowired
    private lateinit var em: EntityManager

    @Autowired
    private lateinit var jpaQueryFactory: JPAQueryFactory


    @BeforeEach
    fun init() {
        val teamA = Team.create("teamA")
        val teamB = Team.create("teamB")
        em.persist(teamA)
        em.persist(teamB)

        val member1 = Member.create("member1", 10, teamA)
        val member2 = Member.create("member2", 20, teamA)
        val member3 = Member.create("member3", 30, teamB)
        val member4 = Member.create("member4", 40, teamB)

        em.persist(member1)
        em.persist(member2)
        em.persist(member3)
        em.persist(member4)

        em.flush()
    }

    @Test
    fun startJPQL() {
        val result = em.createQuery("select m from Member m where m.username = :username", Member::class.java)
            .setParameter("username", "member1")
            .singleResult

        assertThat(result.username).isEqualTo("member1")
    }

    @Test
    fun startQuerydsl() {
        val result = jpaQueryFactory.selectFrom(member)
            .where(member.username.eq("member1"))
            .fetchOne()

        assertThat(result).isNotNull()
        assertThat(result?.username).isEqualTo("member1")
    }

    @Test
    fun search() {
        val findMember = jpaQueryFactory
            .selectFrom(member)
            .where(member.username.eq("member1").and(member.age.eq(10)))
            .fetchOne()
        assertThat(findMember).isNotNull
        assertThat(findMember?.username).isEqualTo("member1")
    }

    @Test
    fun searchAndParam() {
        val findMember = jpaQueryFactory
            .selectFrom(member)
            .where(
                member.username.eq("member1"),
                (member.age.eq(10))
            )
            .fetchOne()
        assertThat(findMember).isNotNull
        assertThat(findMember?.username).isEqualTo("member1")
    }

    @Test
    fun resultFetch() {
//        val fetch = jpaQueryFactory
//            .selectFrom(member)
//            .fetch()
//
//
//        val fetchOne = jpaQueryFactory
//            .selectFrom(member)
//            .fetchOne()
//
//        val fetchFirst = jpaQueryFactory
//            .selectFrom(member)
//            .fetchFirst()

        val results = jpaQueryFactory
            .selectFrom(member)
            .fetchResults()
        results.total
        results.results

    }

    @Test
    fun sort() {
        em.persist(Member(null, null, 100))
        em.persist(Member(null, "member5", 100))
        em.persist(Member(null, "member6", 100))
        val result = jpaQueryFactory
            .selectFrom(member)
            .orderBy(member.age.desc(), member.username.asc().nullsLast())
            .fetch()

        val member5 = result[0]
        val member6 = result[1]
        val memberNull = result[2]

        assertThat(member5.username).isEqualTo("member5")
        assertThat(member6.username).isEqualTo("member6")
        assertThat(memberNull.username).isNull()
    }

    @Test
    fun paging1() {
        val fetch = jpaQueryFactory.selectFrom(member)
            .orderBy(member.username.desc())
            .offset(1)
            .limit(2)
            .fetch()
        assertThat(fetch.size).isEqualTo(2)
    }

    @Test
    fun paging2() {
        val fetch = jpaQueryFactory.selectFrom(member)
            .orderBy(member.username.desc())
            .offset(1)
            .limit(2)
            .fetchResults()
        assertThat(fetch.total).isEqualTo(4)
        assertThat(fetch.limit).isEqualTo(2)
        assertThat(fetch.offset).isEqualTo(1)
        assertThat(fetch.results.size).isEqualTo(2)
    }

    @Test
    fun aggregation() {
        val result = jpaQueryFactory.select(
            member.count(),
            member.age.sum(),
            member.age.avg(),
            member.age.max(),
            member.age.min(),

            )
            .from(member)
            .fetch()

        val tuple = result[0]
        assertThat(tuple.get(member.count())).isEqualTo(4)
        assertThat(tuple.get(member.age.sum())).isEqualTo(100)
        assertThat(tuple.get(member.age.avg())).isEqualTo(25.0)
        assertThat(tuple.get(member.age.max())).isEqualTo(40)
        assertThat(tuple.get(member.age.min())).isEqualTo(10)
    }

    @Test
    fun group() {
        val result = jpaQueryFactory.select(team, member.age.avg())
            .from(team)
            .join(team.members, member)
            .groupBy(team)
            .orderBy(team.name.asc())
            .fetch()

        val tuple = result[0]
        assertThat(tuple.get(team)?.name).isEqualTo("teamA")
        assertThat(tuple.get(member.age.avg())).isEqualTo(15.0)
    }

    @Test
    fun join() {
        val result = jpaQueryFactory
            .selectFrom(member)
            .join(member.team, team)
            .where(team.name.eq("teamA"))
            .fetch()
        assertThat(result).extracting("username")
            .containsExactly("member1", "member2")
    }

    @Test
    fun thetaJoin() {
        em.persist(Member(username = "teamA"))
        em.persist(Member(username = "teamB"))

        val result = jpaQueryFactory
            .select(member)
            .from(member, team)
            .where(member.username.eq(team.name))
            .fetch()
        assertThat(result)
            .extracting("username")
            .containsExactly("teamA", "teamB")
    }
}