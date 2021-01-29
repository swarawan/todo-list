package com.swarawan.todoapp.db.entity

import javax.persistence.*

@Entity
@Table(name = "todo")
data class TodoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "description")
    var description: String? = null
)