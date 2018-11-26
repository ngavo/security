package org.controller

import org.model.User
import org.repository.UserDAO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userDAO: UserDAO){

    @GetMapping
    fun getListUser(): List<User> = userDAO.findAll().toList()

}