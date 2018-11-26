package org.model

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "company")
/*
class Company{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    get() = field
    set(value){
        field = value
    }



    var name: String=""
        get() = field
        set(value){
            field = value
        }

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "company", fetch = FetchType.EAGER)
    var product: Set<Product> = emptySet()
        get() = field
        set(value){
            field = value
        }

}*/

data class Company(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long=0,


        @field: Size(min = 5,max = 15,message = "Name must be between 2 and 32 characters long")
        val name: String="",

        @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "company", fetch = FetchType.EAGER)
        val product: Set<Product> = emptySet()
)
