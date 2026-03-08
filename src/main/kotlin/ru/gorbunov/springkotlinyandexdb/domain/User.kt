package ru.gorbunov.springkotlinyandexdb.domain

import jakarta.persistence.*
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode


@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String?,
    val name: String,

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(
        name = "users_role",
        joinColumns = [JoinColumn("user_id")],
        inverseJoinColumns = [JoinColumn("role_id")]
    )
    val roles: MutableSet<Role>

){
     fun copy(user: User): User = User(null, user.name, user.roles.toMutableSet())
}