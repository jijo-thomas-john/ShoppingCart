package com.freshmart;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
  private Map<Item, Integer> Items;

  ShoppingCart() {
    Items = new HashMap<>();
  }

  void Add(Item item, int count) {
    Items.put(item, count);
  }

  Money Checkout() {
    return Item.DOVE_SOAP.getPrice().times(Items.get(Item.DOVE_SOAP));
  }

  int getCount(Item item) {
    return Items.get(item);
  }

}
