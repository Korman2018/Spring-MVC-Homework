package com.epam.springadvanced.springmvc.repository;

import com.epam.springadvanced.springmvc.entity.TestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends CrudRepository<TestUser, Long> {

}
