package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.List;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;

public class OrderDTO {
  private Long id;
  private Instant moment;
  private OrderStatus status;
  private UserMinDTO client;
  private PaymentDTO payment;
  private List<OrderItemDTO> items;

  public OrderDTO() {}

  public OrderDTO(Long id, Instant moment, OrderStatus status, UserMinDTO client, PaymentDTO payment) {
    this.id = id;
    this.moment = moment;
    this.status = status;
    this.client = client;
    this.payment = payment;
  }

  public OrderDTO(Order entity) {
    this.id = entity.getId();
    this.moment = entity.getMoment();
    this.status = entity.getStatus();
    this.client = new UserMinDTO(entity.getClient());
    this.payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
    this.items = entity.getItems().stream().map(OrderItemDTO::new).toList();
  }

  public Double getTotal() {
    double sum = 0.0;
    for (OrderItemDTO item : items) {
      sum += item.getSubTotal();
    }
    return sum;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public UserMinDTO getClient() {
    return client;
  }

  public void setClient(UserMinDTO client) {
    this.client = client;
  }

  public PaymentDTO getPayment() {
    return payment;
  }

  public void setPayment(PaymentDTO payment) {
    this.payment = payment;
  }

  public List<OrderItemDTO> getItems() {
    return items;
  }

  public void setItems(List<OrderItemDTO> items) {
    this.items = items;
  }
  
}
