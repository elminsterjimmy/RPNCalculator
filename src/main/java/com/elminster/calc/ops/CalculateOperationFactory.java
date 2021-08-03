package com.elminster.calc.ops;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.elminster.calc.ops.exceptions.NoSuchOperationException;
import com.elminster.calc.ops.exceptions.UnableInitOperationException;
import com.elminster.calc.ops.model.CalculateOperations;

public class CalculateOperationFactory {
  
  public static CalculateOperationFactory FACTORY = new CalculateOperationFactory();
  @SuppressWarnings("rawtypes")
  private Map<String, CalculateOperation> cache = new HashMap<>();

  private CalculateOperationFactory() {}
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  public <T, K> CalculateOperation<T, K> getOperation(String operation) throws NoSuchOperationException, UnableInitOperationException {
    if (isNum(operation)) {
      operation = CalculateOperations.ASSIGN.getName();
    }
    CalculateOperation op = cache.get(operation);
    if (null == op) {
      CalculateOperations ops = CalculateOperations.getOperation(operation);
      Class<? extends CalculateOperation> clazz = ops.getClazz();
      try {
        op = clazz.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        throw new UnableInitOperationException(e);
      }
      cache.put(operation, op);
    }
    return op;
  }

  private boolean isNum(String operation) {
    try {
      new BigDecimal(operation);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }
}
