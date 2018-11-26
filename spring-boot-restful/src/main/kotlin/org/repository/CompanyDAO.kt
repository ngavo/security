package org.repository

import org.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface  CompanyDAO: JpaRepository<Company, Long>{

}