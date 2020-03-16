package com.epam.springadvanced.springmvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class PhoneEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userEntity_id")
  private UserEntity user;

  @Column(nullable = false)
  private String number;

  //  @Column(nullable = false)
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "companyEntity_id", referencedColumnName = "id", unique = true, nullable = false)
  private CompanyEntity companyEntity;

}