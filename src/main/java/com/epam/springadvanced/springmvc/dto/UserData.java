package com.epam.springadvanced.springmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserData {

  private Long id;
  private String name;
  private String surname;
  private String patronymic;

}
