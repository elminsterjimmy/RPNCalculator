package com.elminster.calc.ops.impl;

import java.math.BigDecimal;

import com.elminster.calc.ops.exceptions.CalculationException;

public class SqrtOperation extends NumbericOperation {

  @Override
  public int getOperandCount() {
    return 1;
  }

  @Override
  public String getName() {
    return "sqrt";
  }

  @Override
  protected BigDecimal doOperate(BigDecimal... operands) throws CalculationException {
    BigDecimal operand = operands[0];
    return BigDecimal.valueOf(Math.sqrt(operand.doubleValue())); // FIXME may loss precision, but sufficient here
                                                                 // for more precision, use Newton's method is a solution
  }
}

