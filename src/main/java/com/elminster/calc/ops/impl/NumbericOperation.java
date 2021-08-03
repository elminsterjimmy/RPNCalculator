package com.elminster.calc.ops.impl;

import java.math.BigDecimal;

import com.elminster.calc.ops.CalculateOperation;
import com.elminster.calc.ops.MemoableOperation;
import com.elminster.calc.ops.exceptions.CalculationException;
import com.elminster.calc.ops.exceptions.NoOperandException;
import com.elminster.calc.ops.exceptions.NotEnoughOperandException;

abstract public class NumbericOperation implements CalculateOperation<BigDecimal, BigDecimal>, MemoableOperation {
  
  @Override
  public BigDecimal operate(BigDecimal... operands) throws CalculationException {
    checkOperandsLen(operands);
    return doOperate(operands);
  }
  
  private void checkOperandsLen(BigDecimal... operands) throws CalculationException {
    if (null == operands) {
      throw new NoOperandException();
    }
    if (operands.length < this.getOperandCount()) {
//      throw new NotEnoughOperandException(String.format("[%s] requires [%d] operands, but got [%d].", this.getName(), this.getOperandCount(), operands.length));
      throw new NotEnoughOperandException("insucient parameters");
    }
  }

  abstract protected BigDecimal doOperate(BigDecimal... operands) throws CalculationException;
}
