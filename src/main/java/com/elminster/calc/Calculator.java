package com.elminster.calc;

import com.elminster.calc.model.CalculationRequest;
import com.elminster.calc.model.CalculationResult;
import com.elminster.calc.ops.model.CalcululationContext;

public interface Calculator {
  
  public CalculationResult calculate(CalcululationContext ctx, CalculationRequest input);
}
