package org.repository

import org.model.Company
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
@Transactional
class CompanyWithHibernate(private val entityManager: EntityManager): ImCompany{


    override fun getAllCompany(): List<Company> = (entityManager.createQuery("from Company")).resultList as List<Company>;

}