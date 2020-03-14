package com.epam.springadvanced.springmvc.service;

import com.epam.springadvanced.springmvc.entity.User;
import com.epam.springadvanced.springmvc.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return StreamSupport
        .stream(userRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public void addUsers(final List<User> users) {
    userRepository.saveAll(users);
  }
}
