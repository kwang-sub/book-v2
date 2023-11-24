package com.example.querydslkotlin.repository

import com.example.querydslkotlin.domain.Cat
import com.example.querydslkotlin.domain.QCat
import com.querydsl.jpa.JPAExpressions
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
class CatQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory,
) {

    val qChildCat = QCat("qChildCat")
    val qParentCat = QCat("qParentCat")

    fun findByParentName(parentName: String): Optional<Cat> {
        val result = jpaQueryFactory.selectFrom(qChildCat)
            .innerJoin(qChildCat.parentCat, qParentCat)
            .where(qParentCat.name.eq(parentName))
            .fetchOne()

        return Optional.ofNullable(result)
    }

    fun findByMaxParentAge(): Optional<Cat> {
        val result = jpaQueryFactory.selectFrom(qChildCat)
            .innerJoin(qChildCat.parentCat, qParentCat)
            .where(
                qParentCat.age.eq(
                    JPAExpressions.select(qParentCat.age.max()).from(qParentCat)
                )
            )
            .fetchOne()

        return Optional.ofNullable(result)
    }

}