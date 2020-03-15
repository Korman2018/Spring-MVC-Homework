package com.epam.springadvanced.springmvc.service;

import com.epam.springadvanced.springmvc.entity.Company;
import com.epam.springadvanced.springmvc.entity.Phone;
import com.epam.springadvanced.springmvc.entity.User;
import com.epam.springadvanced.springmvc.repository.CompanyRepository;
import com.epam.springadvanced.springmvc.repository.PhoneRepository;
import com.epam.springadvanced.springmvc.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PhoneRepository phoneRepository;

  public List<User> getAllUsers() {
    return StreamSupport
        .stream(userRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  public List<Phone> getAllPhones() {
    return StreamSupport
        .stream(phoneRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  public void addUsers(List<User> users) {
    userRepository.saveAll(users);
  }

  public void addCompanies(List<Company> companies) {
    companyRepository.saveAll(companies);
  }

  public void addPhone(List<Phone> phones) {
    phoneRepository.saveAll(phones);
  }
}
