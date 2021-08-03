package com.elminster.calc.ops.impl;

import com.elminster.calc.ops.MemoableOperation;
import com.elminster.calc.ops.exceptions.CalculationException;
import com.elminster.calc.ops.model.CalcululationContext;

public class ClearOpertaion extends ContextOperation implements MemoableOperation {

  @Override
  public String getName() {
    return "clear";
  }

  @Override
  protected CalcululationContext doOperate(CalcululationContext ctx) throws CalculationException {
    ctx.getCalcatuionModel().clear();
    ctx.getHistoryService().clear(); // FIXME need to clear up the history?
    return ctx;
  }
}

