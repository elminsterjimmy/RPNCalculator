package com.elminster.calc.ops;

import com.elminster.calc.ops.exceptions.CalculationException;

public interface CalculateOperation<T, K> {
  
  K operate(@SuppressWarnings("unchecked") T... operands) throws CalculationException;
  
  int getOperandCount();
  
  String getName();
}
