package com.courier.security.authservice;

import com.courier.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstname;
  private String lastname;
  private String name;
  private String email;
  private String password;

  private String phone;
  private String address;
  private boolean isActive;
  private String panCard;
  private String adharCard;
  private String departureSource;
  private String arrivalDestination;
  private String departureTime;
  private String arrivalTime;
  private String couriersource;
  private String courierdestination;

  public boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(boolean active) {
    isActive = active;
  }

  private Set<Role>roles;

}
