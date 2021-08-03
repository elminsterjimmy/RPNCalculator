package com.elminster.calc.model;

import com.elminster.calc.ops.model.CalculationModel;

@SuppressWarnings("rawtypes")
public class SimpleCalculationResult implements CalculationResult {
  
  private final CalculationModel model;

  public SimpleCalculationResult(CalculationModel model) {
    this.model = model;
  }

  @SuppressWarnings("unchecked")
  @Override
  public CalculationModel getResult() {
    return model;
  }
}
