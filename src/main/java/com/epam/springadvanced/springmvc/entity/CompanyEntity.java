package com.epam.springadvanced.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(mappedBy = "companyEntity")
  private PhoneEntity phone;

  @Column(nullable = false, unique = true)
  private String name;

}