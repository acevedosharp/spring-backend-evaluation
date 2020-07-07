package com.acevedosharp.springbackendevaluation.repo

import com.acevedosharp.springbackendevaluation.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo: JpaRepository<Post, Int>