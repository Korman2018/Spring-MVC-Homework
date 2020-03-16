package com.epam.springadvanced.springmvc.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String surname;

  private String patronymic;

  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
  private List<PhoneEntity> phones = new ArrayList<>();

}