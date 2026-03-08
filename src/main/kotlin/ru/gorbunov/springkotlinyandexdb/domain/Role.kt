package ru.gorbunov.springkotlinyandexdb.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "role")
class Role(

    @Id
    var id: Int,
    val name: String,


//    @ManyToMany(mappedBy = "roles")
//    val users: MutableList<User>
)