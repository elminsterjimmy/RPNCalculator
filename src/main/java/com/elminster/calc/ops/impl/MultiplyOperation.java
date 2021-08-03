package com.elminster.calc.ops.impl;

import java.math.BigDecimal;

import com.elminster.calc.ops.exceptions.CalculationException;

public class MultiplyOperation extends NumbericOperation {

  @Override
  public int getOperandCount() {
    return 2;
  }

  @Override
  public String getName() {
    return "*";
  }

  @Override
  protected BigDecimal doOperate(BigDecimal... operands) throws CalculationException {
    return operands[0].multiply(operands[1]);
  }
}

