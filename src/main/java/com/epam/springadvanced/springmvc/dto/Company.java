package com.epam.springadvanced.springmvc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Company {

  @NonNull
  private String name;
}
