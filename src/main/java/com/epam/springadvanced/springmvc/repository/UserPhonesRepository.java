package com.epam.springadvanced.springmvc.repository;

import com.epam.springadvanced.springmvc.dto.UserData;
import com.epam.springadvanced.springmvc.entity.Company;
import com.epam.springadvanced.springmvc.entity.Phone;
import com.epam.springadvanced.springmvc.entity.User;
import java.util.List;

public interface UserPhonesRepository {

  int[] addUsers(List<User> users);

  int[] addCompanies(List<Company> companies);

  int[] addPhones(List<Phone> phones);

  List<UserData> getUsersData();
}
