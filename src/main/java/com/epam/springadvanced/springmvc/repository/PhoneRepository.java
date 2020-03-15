package com.epam.springadvanced.springmvc.repository;

import com.epam.springadvanced.springmvc.entity.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {

}
