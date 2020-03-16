package com.epam.springadvanced.springmvc.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

  @NonNull
  private String name;

  @NonNull
  private String surname;

  private String patronymic;

  private List<Phone> phones;

}
