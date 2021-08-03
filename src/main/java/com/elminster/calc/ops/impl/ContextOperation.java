package com.elminster.calc.ops.impl;

import com.elminster.calc.ops.CalculateOperation;
import com.elminster.calc.ops.exceptions.CalculationException;
import com.elminster.calc.ops.exceptions.NoOperandException;
import com.elminster.calc.ops.model.CalcululationContext;

abstract public class ContextOperation implements CalculateOperation<CalcululationContext, CalcululationContext> {
  
  @Override
  public CalcululationContext operate(CalcululationContext... ctx) throws CalculationException {
    if (null == ctx || ctx.length < 1) {
      throw new NoOperandException();
    }
    return doOperate(ctx[0]);
  }
  
  @Override
  public int getOperandCount() {
    return 1;
  }

  abstract protected CalcululationContext doOperate(CalcululationContext ctx) throws CalculationException;
}

