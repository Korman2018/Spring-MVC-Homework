package com.epam.springadvanced.springmvc.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Phone {

  private Long id;
  private Long userId;
  private Long companyId;
  private String number;

}