package com.epam.springadvanced.springmvc.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

  private Long id;
  private String name;
  private String patronymic;
  private String surname;

}