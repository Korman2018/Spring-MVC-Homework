package com.epam.springadvanced.springmvc.service;

import com.epam.springadvanced.springmvc.dto.UserData;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface UserDataService {

  ByteArrayInputStream getAllUsersPDF();

  List<UserData> getAllUsers();

  void addUsers(MultipartFile[] multipartFiles);

}
