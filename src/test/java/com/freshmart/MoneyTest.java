package com.freshmart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  void getAmount() {
    Money money = new Money(10f);

    Assertions.assertEquals(10.00f, money.getAmount(), "Incorrect money amount");
  }

  @Test
  void getAmountWithPaisa() {
    Money money = new Money(10.01f);

    Assertions.assertEquals(10.01f, money.getAmount(), "Incorrect money amount");
  }

  @Test
  void getAmountWithPaisaHavingThreePrecisionForRoundUp() {
    Money money = new Money(0.567f);

    Assertions.assertEquals(0.57f, money.getAmount(), "Incorrect money amount");
  }

  @Test
  void getAmountWithPaisaHavingThreePrecisionForRoundDown() {
    Money money = new Money(0.564f);

    Assertions.assertEquals(0.56f, money.getAmount(), "Incorrect money amount");
  }

  @Test
  void nTimesZeroMoney() {
    Money money = new Money(0);

    Money newMoney = money.times(2);

    Assertions.assertEquals(0.00f, newMoney.getAmount(), "Incorrect money amount");
  }

  @Test
  void nTimesNonZeroMoney() {
    Money money = new Money(39.99f);

    Money newMoney = money.times(5);

    Assertions.assertEquals(199.95f, newMoney.getAmount(), "Incorrect money amount");
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