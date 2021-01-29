package com.swarawan.todoapp.controller

import com.swarawan.todoapp.db.entity.TodoEntity
import com.swarawan.todoapp.db.repo.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/todo"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TodoController @Autowired constructor(private val todoRepository: TodoRepository) {

    @GetMapping
    fun getAll(): ResponseEntity<Any> {
        val result: List<TodoEntity> = todoRepository.findAll()
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping("{id}")
    fun getById(@PathVariable("id") id: Long): ResponseEntity<Any> {
        val result: TodoEntity = todoRepository.findById(id)
            .orElseThrow { throw Exception("Data not found for id: $id") }
        return ResponseEntity(result, HttpStatus.OK)
    }
}