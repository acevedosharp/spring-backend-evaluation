package com.acevedosharp.springbackendevaluation.repo

import com.acevedosharp.springbackendevaluation.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepo: JpaRepository<Comment, Int>