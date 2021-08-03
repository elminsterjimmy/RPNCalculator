package com.elminster.calc.ops.impl;

import java.math.BigDecimal;

import com.elminster.calc.ops.MemoableOperation;
import com.elminster.calc.ops.exceptions.CalculationException;
import com.elminster.calc.ops.model.CalculationModel;
import com.elminster.calc.ops.model.CalcululationContext;

public class AssignOperation extends ContextOperation implements MemoableOperation {

  @Override
  public String getName() {
    return "assign";
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  protected CalcululationContext doOperate(CalcululationContext ctx) throws CalculationException {
    String token = ctx.getToken();
    try {
      BigDecimal assign = new BigDecimal(token);
      CalculationModel model = ctx.getCalcatuionModel();
      model.put(assign);
      return ctx;
    } catch (NumberFormatException nfe) {
      throw new CalculationException(nfe);
    }
  }
}
