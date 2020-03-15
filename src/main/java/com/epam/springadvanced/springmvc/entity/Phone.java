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
public class Phone {

  @Id
  @NonNull
  private Long id;

//  @ManyToOne
//  @JoinColumn(name = "user_id", nullable = true)
//  private User user;

//    @JoinColumn(name = "user_id", nullable = true)
//  private Long userId;

//  @OneToOne(mappedBy = "company_id")
//  private Company company;

  //  @ManyToOne
  private Long userId;

  private Long companyId;

  @NonNull
  private String number;
}