package com.elminster.calc.ops.impl;

import java.math.BigDecimal;

import com.elminster.calc.ops.exceptions.CalculationException;

public class DivideOperation extends NumbericOperation {

  @Override
  public int getOperandCount() {
    return 2;
  }

  @Override
  public String getName() {
    return "/";
  }

  @Override
  protected BigDecimal doOperate(BigDecimal... operands) throws CalculationException {
    try {
      return operands[0].divide(operands[1]);
    } catch (ArithmeticException ae) {
      throw new CalculationException(ae);
    }
  }
}

