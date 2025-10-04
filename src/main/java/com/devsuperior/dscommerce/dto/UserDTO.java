package com.devsuperior.dscommerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;

import com.devsuperior.dscommerce.entities.User;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;

    private List<String> roles = new ArrayList<>();

    

    public UserDTO(User entity) {
      this.id = entity.getId();
      this.name = entity.getName();
      this.email = entity.getEmail();
      this.phone = entity.getPhone();
      this.birthDate = entity.getBirthDate();
      this.roles = entity.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public LocalDate getBirthDate() {
      return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
      this.birthDate = birthDate;
    }

    public List<String> getRoles() {
      return roles;
    }
}
