package com.epam.springadvanced.springmvc.repository;

import com.epam.springadvanced.springmvc.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
