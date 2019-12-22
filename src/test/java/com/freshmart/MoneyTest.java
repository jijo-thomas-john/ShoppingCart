package com.freshmart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  void timesZeroMoney() {
    Money money = new Money(0);

    Money newMoney = money.times(2);

    Assertions.assertEquals(money, newMoney, "Incorrect money amount");
  }

  @Test
  void timesNonZeroMoney() {
    Money money = new Money(39.99f);
    Money expectedMoney = new Money(211.95f);

    Money newMoney = money.times(5.3f);

    Assertions.assertEquals(expectedMoney, newMoney, "Incorrect money amount");
  }

  @Test
  void addMoneyWithNull() {
    Money money = new Money(39.99f);
    Money expectedMoney = new Money(39.99f);

    Money newMoney = money.add(null);

    Assertions.assertEquals(expectedMoney, newMoney, "Incorrect money amount");
  }

  @Test
  void addMoneyWithAnotherMoney() {
    Money money = new Money(39.99f);
    Money expectedMoney = new Money(50.00f);

    Money newMoney = money.add(new Money(10.01f));

    Assertions.assertEquals(expectedMoney, newMoney, "Incorrect money amount");
  }

  @Test
  void moneyEqualsSameMoney() {
    Money money = new Money(39.99f);

    Assertions.assertEquals(money, money, "Money not equal to same money");
  }

  @Test
  void moneyNotEqualsObject() {
    Money money = new Money(39.99f);

    Assertions.assertNotEquals(money, new Object(), "Valid money is equal to object");
  }

  @Test
  void moneyNotEqualsAnotherMoney() {
    Money money = new Money(39.99f);
    Money anotherMoney = new Money(59.99f);

    Assertions.assertNotEquals(money, anotherMoney, "Incorrect money comparison");
  }

  @Test
  void moneyEqualsAnotherMoneyOfSameValue() {
    Money money = new Money(39.99f);
    Money anotherMoney = new Money(39.99f);

    Assertions.assertEquals(money, anotherMoney, "Incorrect money comparison");
  }

}