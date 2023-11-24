package com.example.test.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Sample(
    @Id
    var id: Long? = null,
)