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
public class Company {

  @Id
  @NonNull
  private Long id;

//  @OneToOne
//  private Phone phone;

//  @OneToOne
//  private Long phoneId

  @NonNull
  private String name;

}