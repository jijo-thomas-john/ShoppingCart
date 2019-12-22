package com.freshmart;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
  private final BigDecimal amount;

  private Money(BigDecimal amount) {
    this.amount = amount.setScale(2, RoundingMode.HALF_UP);
  }

  Money(float monetaryAmount) {
    amount = BigDecimal.valueOf(monetaryAmount).setScale(2, RoundingMode.HALF_UP);
  }

  float getAmount() {
    return amount.floatValue();
  }

  Money times(Integer multiplier) {
    return new Money(amount.multiply(BigDecimal.valueOf(multiplier)));
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Money)) {
      return false;
    }

    Money money = (Money) obj;

    return amount.equals(money.amount);
  }
}