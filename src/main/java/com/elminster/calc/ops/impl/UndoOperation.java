package com.elminster.calc.ops.impl;

import com.elminster.calc.ops.exceptions.CalculationException;
import com.elminster.calc.ops.model.CalculationModel;
import com.elminster.calc.ops.model.CalcululationContext;

public class UndoOperation extends ContextOperation {

  @Override
  public String getName() {
    return null;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  protected CalcululationContext doOperate(CalcululationContext ctx) throws CalculationException {
    CalculationModel perviousModel = (CalculationModel) ctx.getHistoryService().get();
    ctx.getCalcatuionModel().setModel(perviousModel);
    return ctx;
  }
}

