package com.epam.springadvanced.springmvc.repository;

import com.epam.springadvanced.springmvc.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends CrudRepository<UserEntity, Long> {

}
