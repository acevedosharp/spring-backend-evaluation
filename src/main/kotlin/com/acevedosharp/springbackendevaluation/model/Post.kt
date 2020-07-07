package com.acevedosharp.springbackendevaluation.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name="post", schema = "evaluation")
data class Post (
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column(name = "id")
    val id: Int?,

    @Column(name = "title", nullable = false, unique = true)
    val title: String,

    @Column(name = "content", nullable = false, unique = false)
    val content: String,

    @Column(name = "moment_created", nullable = false, unique = false)
    val momentCreated: Timestamp,

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val comments: List<Comment>?
)