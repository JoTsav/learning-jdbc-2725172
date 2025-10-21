package com.joseph.lil.data.entity;

import java.util.UUID;
import java.math.BigDecimal;

public class Service {

  private UUID serviceID;
  private String name;
  private BigDecimal price;

  public void serviceID(UUID serviceID) {
    this.serviceID = serviceID;
  }
  public UUID getServiceID() {
    return serviceID;
  }
  public void setServiceID(UUID serviceID) {
    this.serviceID = serviceID;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public BigDecimal getPrice() {
    return price;
  }
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Service [serviceID=" + serviceID + ", name=" + name + ", price=" + price + "]";
  }
  
}