package com.swarawan.todoapp.db.repo

import com.swarawan.todoapp.db.entity.TodoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<TodoEntity, Long> {

    fun findByName(name: String): List<TodoEntity>
}