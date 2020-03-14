package com.epam.springadvanced.springmvc.service;

import com.epam.springadvanced.springmvc.entity.User;
import java.util.List;

public interface UserService {

  List<User> getAllUsers();

  void addUsers(List<User> users);
}
