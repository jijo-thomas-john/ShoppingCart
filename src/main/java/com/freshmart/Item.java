package com.freshmart;

public enum Item {
  DOVE_SOAP("Dove Soap", new Money(39.99f));

  private final String name;
  private final Money price;

  Item(String name, Money price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Money getPrice() {
    return price;
  }
}
