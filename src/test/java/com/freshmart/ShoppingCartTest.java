package com.freshmart;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

  @Test
  void addOneItemToShoppingCart() {
    ShoppingCart cart = new ShoppingCart(0);

    cart.Add(Item.DOVE_SOAP, 5);

    assertEquals(5, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
  }

  @Test
  void checkoutShoppingCartWithOneItem() {
    ShoppingCart cart = new ShoppingCart(0);
    Money expectedAmount = new Money(39.99f);

    cart.Add(Item.DOVE_SOAP, 1);
    Money amount = cart.Checkout();

    assertEquals(1, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

  @Test
  void checkoutShoppingCartWithMultipleNumberOfSameItem() {
    ShoppingCart cart = new ShoppingCart(0);
    Money expectedAmount = new Money(199.95f);

    cart.Add(Item.DOVE_SOAP, 5);
    Money amount = cart.Checkout();

    assertEquals(5, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

  @Test
  void checkoutShoppingCartAddingItemsInTwoSteps() {
    ShoppingCart cart = new ShoppingCart(0);
    Money expectedAmount = new Money(319.92f);

    cart.Add(Item.DOVE_SOAP, 5);
    cart.Add(Item.DOVE_SOAP, 3);
    Money amount = cart.Checkout();

    assertEquals(8, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

  @Test
  void checkoutShoppingCartWithDifferentItems() {
    ShoppingCart cart = new ShoppingCart(0);
    Money expectedAmount = new Money(279.96f);

    cart.Add(Item.DOVE_SOAP, 2);
    cart.Add(Item.AXE_DEO, 2);
    Money amount = cart.Checkout();

    assertEquals(2, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(2, cart.getCount(Item.AXE_DEO), String.format("Incorrect count of item %s", Item.AXE_DEO.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

  @Test
  void checkoutShoppingCartWithDifferentItemsWithSalesTax() {
    ShoppingCart cart = new ShoppingCart(0.125f);
    Money expectedAmount = new Money(314.96f);

    cart.Add(Item.DOVE_SOAP, 2);
    cart.Add(Item.AXE_DEO, 2);
    Money amount = cart.Checkout();

    assertEquals(2, cart.getCount(Item.DOVE_SOAP), String.format("Incorrect count of item %s", Item.DOVE_SOAP.getName()));
    assertEquals(2, cart.getCount(Item.AXE_DEO), String.format("Incorrect count of item %s", Item.AXE_DEO.getName()));
    assertEquals(expectedAmount, amount, "Incorrect amount for items in cart");
  }

}