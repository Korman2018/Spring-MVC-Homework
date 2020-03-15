package com.epam.springadvanced.springmvc.repository;

import com.epam.springadvanced.springmvc.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
