package com.epam.springadvanced.springmvc;

import com.epam.springadvanced.springmvc.entity.Company;
import com.epam.springadvanced.springmvc.entity.Phone;
import com.epam.springadvanced.springmvc.entity.User;
import com.epam.springadvanced.springmvc.service.TestUserServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

  @Autowired
  private TestUserServiceImpl userService;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    List<Company> companies = new ArrayList<>();
    List<Phone> phones = new ArrayList<>();
    List<User> users = new ArrayList<>();

    Company company = new Company(4L, "MTS");
    companies.add(company);
    userService.addCompanies(companies);

    User user = new User(3L, "Ovan", "Ovanov");
    user.setPhones(phones);
    users.add(user);
    userService.addUsers(users);

    Phone phone = new Phone(3L, "12346");
//        phone.setUser(user);
    phone.setCompany(company);
    phones.add(phone);
    userService.addPhone(phones);

//        Company company = new Company(1L, "MTS");
//        Phone phone = new Phone(1L, "123456");
//        phone.setCompany(company);
//        user.getPhones().add(phone);
//
//        company.setPhone(phone);
//        phone.setUser(user);

    List<User> userList = userService.getAllUsers();
    List<Phone> phonesList = userService.getAllPhones();
    System.out.println(phonesList);
    System.out.println(userList);
  }
}