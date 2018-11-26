package org.model

import javax.persistence.*

@Entity @Table(name="product")
/*
class  Product{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long=0
    get() = field
    set(value) {
        field = value;
    }

    var name: String = ""
    get() = field
    set(value) {
        field = value;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    var company: Company? = null
    get() = field
    set(value) {
        field = value;
    }



}*/

data class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long=0,
        var name: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="company_id")
        var company: Company? = null

)