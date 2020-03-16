package com.epam.springadvanced.springmvc.controller;

import com.epam.springadvanced.springmvc.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UIController {

  @Autowired
  private UserDataService userDataService;

  @RequestMapping("/")
  public String forwardUpload() {
    return "upload_files";
  }

  @PostMapping(value = "/")
  public String uploadFiles(@RequestParam("uploadedFiles") MultipartFile[] uploadedFiles) {
    userDataService.addUsers(uploadedFiles);
    return "redirect:/";
  }

  @GetMapping(value = "/getUsers")
  public String getUsers(Model model) {
    model.addAttribute("users", userDataService.getAllUsers());

    return "get_users";
  }

}