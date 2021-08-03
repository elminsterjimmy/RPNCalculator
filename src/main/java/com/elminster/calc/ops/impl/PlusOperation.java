package com.elminster.calc.ops.impl;

import java.math.BigDecimal;

import com.elminster.calc.ops.exceptions.CalculationException;

public class PlusOperation extends NumbericOperation {

  @Override
  public int getOperandCount() {
    return 2;
  }

  @Override
  protected BigDecimal doOperate(BigDecimal... operands) throws CalculationException {
    BigDecimal operand1 = operands[0];
    BigDecimal operand2 = operands[1];
    return operand1.add(operand2);
  }

  @Override
  public String getName() {
    return "+";
  }
}
