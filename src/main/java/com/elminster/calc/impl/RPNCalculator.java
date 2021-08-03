package com.elminster.calc.impl;

import java.math.BigDecimal;

import com.elminster.calc.Calculator;
import com.elminster.calc.model.CalculationRequest;
import com.elminster.calc.model.CalculationResult;
import com.elminster.calc.model.SimpleCalculationResult;
import com.elminster.calc.ops.CalculateOperation;
import com.elminster.calc.ops.CalculateOperationFactory;
import com.elminster.calc.ops.MemoableOperation;
import com.elminster.calc.ops.exceptions.CalculationException;
import com.elminster.calc.ops.exceptions.NotEnoughOperandException;
import com.elminster.calc.ops.impl.ContextOperation;
import com.elminster.calc.ops.impl.NumbericOperation;
import com.elminster.calc.ops.model.CalculationModel;
import com.elminster.calc.ops.model.CalcululationContext;
import com.elminster.calc.ops.model.NoSuchElementException;
import com.elminster.calc.ops.scaner.Scaner;
import com.elminster.calc.ops.scaner.impl.TokenScaner;

public class RPNCalculator implements Calculator {

  private CalculateOperationFactory opFactory = CalculateOperationFactory.FACTORY;

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public CalculationResult calculate(CalcululationContext ctx, CalculationRequest input) {
    Object request = input.getRequest();
    String strReq = (String) request;
    String token = null;
    Scaner scaner = new TokenScaner(strReq);
    try {
      while (!scaner.reachedEOF()) {
        token = scaner.next();
        ctx.setToken(token);
        ctx.setIdx(scaner.currentIdx());
        CalculateOperation op = opFactory.getOperation(token);
        int count = op.getOperandCount();
        Object[] operands;
        if (op instanceof MemoableOperation) {
          ctx.getHistoryService().put(ctx.getCalcatuionModel());
        }
        if (op instanceof NumbericOperation) {
          operands = new BigDecimal[count];
          for (int i = 0; i < count; i++) {
            try {
              BigDecimal operand = (BigDecimal) ctx.getCalcatuionModel().get();
              operands[count - i - 1] = operand;
            } catch (NoSuchElementException nse) {
              ctx.setModel((CalculationModel) ctx.getHistoryService().get()); // restore to previous status
              throw new NotEnoughOperandException("insucient parameters");
            }
          }
          Object rst = op.operate(operands);
          ctx.getCalcatuionModel().put(rst);
        } else if (op instanceof ContextOperation) {
          operands = new CalcululationContext[] {ctx};
          op.operate(operands);
        }
      }
    } catch (CalculationException ce) {
      System.out.println(String.format("operator %s (position %d): %s", token, scaner.currentIdx(), ce.getMessage()));
    }
    
    return new SimpleCalculationResult(ctx.getCalcatuionModel().cloneModel());
  }
}
