package com.epam.springadvanced.springmvc.service;

import com.epam.springadvanced.springmvc.entity.User;
import com.epam.springadvanced.springmvc.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return StreamSupport
        .stream(userRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public void addUsers(List<User> users) {
    userRepository.saveAll(users);
  }
}
