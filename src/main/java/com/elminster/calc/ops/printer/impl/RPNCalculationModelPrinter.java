package com.elminster.calc.ops.printer.impl;

import java.math.BigDecimal;
import java.util.Iterator;

import com.elminster.calc.ops.model.CalculationModel;
import com.elminster.calc.ops.printer.Printer;

public class RPNCalculationModelPrinter implements Printer<CalculationModel<BigDecimal>, String> {

  private static final String SPACE = " ";

  @Override
  public String print(CalculationModel<BigDecimal> calculationModel) {
    CalculationModel<BigDecimal> cloned = calculationModel.cloneModel();
    StringBuilder sb = new StringBuilder(100).append("stack:");
    Iterator<BigDecimal> it = cloned.iterator();
    while (it.hasNext()) {
      sb.append(SPACE);
      BigDecimal num = it.next();
      sb.append(format(num));
    }
    return sb.toString();
  }

  private String format(BigDecimal num) {
    int scale = num.scale();
    return num.setScale(scale > 10 ? 10 : scale, BigDecimal.ROUND_HALF_UP).toString();
  }
}
