package com.acevedosharp.springbackendevaluation.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name="comment", schema = "evaluation")
data class Comment (
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    val id: Int?,

    @Column(name = "content", nullable = false, unique = false)
    val content: String,

    @Column(name = "moment_created", nullable = false, unique = false)
    val momentCreated: Timestamp,

    @Column(name = "post")
    val post: Int
)