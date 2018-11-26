package org.controller

import org.model.Company
import org.repository.CompanyDAO
import org.repository.CompanyWithHibernate
import org.repository.ImCompany
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.io.IOException
import java.util.concurrent.atomic.AtomicLong
import javax.validation.Valid

@RestController("/greeting")
class GreetingController {

    @Autowired
    lateinit var companyDao: CompanyDAO

    @Autowired
    lateinit var co: ImCompany


    val counter = AtomicLong()

    @GetMapping
    fun greeting(): List<Company> = co.getAllCompany()

    @PostMapping
    fun postDataCompany(@Valid @RequestBody newCompany: Company): Company? {
        try {
            return companyDao.save(newCompany)
        }catch (e: IOException){
            return null;
        }

    }

    @PutMapping
    fun updateDataCompany(@RequestBody updateCompany: Company): Company? = if (companyDao.exists(updateCompany.id)) companyDao.save(updateCompany) else null
    /*fun updateDataCompany(@RequestBody updateCompany: Company): Company?{

        if (companyDao.exists(updateCompany.id)) {

            if (companyDao.exists(updateCompany.id)) {

                return  companyDao.save(updateCompany);
            }

        }

        return null;
    }*/

    @DeleteMapping("/{id}")
    fun deleleDataCompany(@PathVariable id: Long): Boolean {
        if (companyDao.exists(id)) {
            companyDao.delete(id);
            return true;
        } else {
            return false;
        }
    }



}