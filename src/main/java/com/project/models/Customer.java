package com.project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
  private Long customerId;
  private String name;
  private String phoneNo;
  private String city;
  private String email;
  private String address;
  private String addressLine1;
  private String addressLine2;

}
