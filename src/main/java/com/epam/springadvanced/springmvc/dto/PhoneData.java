package com.epam.springadvanced.springmvc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class PhoneData {

  private Long id;
  private UserData userData;
  private String phoneNumber;
  private String companyName;

}
