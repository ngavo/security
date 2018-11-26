package org.model

import javax.persistence.*

@Entity
@Table(name="\"user\"")
data class User(
        @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long=0,

        var name: String="",

        var pass: String=""
)