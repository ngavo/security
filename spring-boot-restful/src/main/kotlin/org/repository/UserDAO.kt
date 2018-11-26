package org.repository

import org.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDAO: CrudRepository<User, Long> {
}