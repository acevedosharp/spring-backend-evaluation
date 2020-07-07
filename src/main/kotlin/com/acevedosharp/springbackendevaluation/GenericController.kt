package com.acevedosharp.springbackendevaluation

import com.acevedosharp.springbackendevaluation.model.Comment
import com.acevedosharp.springbackendevaluation.model.Post
import com.acevedosharp.springbackendevaluation.repo.CommentRepo
import com.acevedosharp.springbackendevaluation.repo.PostRepo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.sql.Timestamp
import java.time.LocalDateTime

@RestController
class PostController(val postRepo: PostRepo, val commentRepo: CommentRepo) {

    @GetMapping("/posts")
    fun allPosts(): List<Post> = postRepo.findAll()

    @PostMapping("/posts")
    fun newPost(@RequestParam title: String, @RequestParam content: String): Post = postRepo.save(
            Post(null, title, content, Timestamp.valueOf(LocalDateTime.now()), null)
    )

    @GetMapping("/posts/{id}")
    fun postById(@PathVariable id: Int): Post = postRepo.findById(id)
            .orElseThrow { EmployeeNotFoundException(id) }

    @PostMapping("/posts/{id}")
    fun newComment(@PathVariable id: Int, @RequestParam content: String): Comment = commentRepo.save(Comment(null, content, Timestamp.valueOf(LocalDateTime.now()),id))

}

internal class EmployeeNotFoundException(id: Int) : RuntimeException("Could not find employee $id")

@ControllerAdvice
internal class EmployeeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun employeeNotFoundHandler(ex: EmployeeNotFoundException): String? {
        return ex.message
    }
}