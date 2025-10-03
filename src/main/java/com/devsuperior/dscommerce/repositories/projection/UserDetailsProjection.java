package com.devsuperior.dscommerce.repositories.projection;

public interface UserDetailsProjection {
  
  String getUsername();
  String getPassword();
  Long getRoleId();
  String getAuthority();
}
