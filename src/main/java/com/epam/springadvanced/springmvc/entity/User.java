package com.epam.springadvanced.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @NonNull
  private Long id;

  @NonNull
  private String name;

  @NonNull
  private String surname;

  private String patronymic;

//  @OneToMany(mappedBy = "user")
//  @OneToMany(mappedBy = "user_id")
//  private List<Phone> phones = new ArrayList<>();

}