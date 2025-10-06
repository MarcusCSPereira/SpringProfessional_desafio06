package com.devsuperior.dscommerce.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class OrderRequestDTO {
  @NotEmpty(message = "Deve ter pelo menos um item")
  private List<OrderItemDTO> items;

  public OrderRequestDTO() {
  }

  public OrderRequestDTO(List<OrderItemDTO> items) {
    this.items = items;
  }

  public List<OrderItemDTO> getItems() {
    return items;
  }
}
