package com.freshmart;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
  private float salesTax;
  private Map<Item, Integer> items;

  ShoppingCart(float salesTax) {
    items = new HashMap<>();
    this.salesTax = salesTax;
  }

  void Add(Item item, int count) {
    if (!items.containsKey(item)) {
      items.put(item, count);
      return;
    }

    Integer itemCount = items.get(item);
    items.put(item, itemCount + count);
  }

  Money Checkout() {
    Money amount = new Money(0f);

    for (Item item : items.keySet()) {
      Money unitPrice = item.getPrice();
      Integer itemCount = items.get(item);
      amount = amount.add(unitPrice.times(itemCount));
    }

    Money taxAmount = computeTax(amount);
    return amount.add(taxAmount);
  }

  private Money computeTax(Money amount) {
    return amount.times(salesTax);
  }

  int getCount(Item item) {
    return items.get(item);
  }

}
