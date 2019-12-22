package com.freshmart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

  @Test
  void addOneItemToShoppingCart() {
    ShoppingCart cart = new ShoppingCart();

    cart.Add(Item.DOVE_SOAP, 5);

    assertEquals(5, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
  }

  @Test
  void checkoutShoppingCartWithOneItem() {
    ShoppingCart cart = new ShoppingCart();
    Money expectedAmount = new Money(39.99f);

    cart.Add(Item.DOVE_SOAP, 1);
    Money amount = cart.Checkout();

    assertEquals(1, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

  @Test
  void checkoutShoppingCartWithMultipleNumberOfSameItem() {
    ShoppingCart cart = new ShoppingCart();
    Money expectedAmount = new Money(199.95f);

    cart.Add(Item.DOVE_SOAP, 5);
    Money amount = cart.Checkout();

    assertEquals(5, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

  @Test
  void checkoutShoppingCartAddingItemsInTwoSteps() {
    ShoppingCart cart = new ShoppingCart();
    Money expectedAmount = new Money(319.92f);

    cart.Add(Item.DOVE_SOAP, 5);
    cart.Add(Item.DOVE_SOAP, 3);
    Money amount = cart.Checkout();

    assertEquals(8, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

}