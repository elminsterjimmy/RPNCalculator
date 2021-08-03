package com.elminster.calc.ops.model;

import com.elminster.calc.ops.CalculateOperation;
import com.elminster.calc.ops.exceptions.NoSuchOperationException;
import com.elminster.calc.ops.impl.AssignOperation;
import com.elminster.calc.ops.impl.ClearOpertaion;
import com.elminster.calc.ops.impl.DivideOperation;
import com.elminster.calc.ops.impl.MinusOperation;
import com.elminster.calc.ops.impl.MultiplyOperation;
import com.elminster.calc.ops.impl.PlusOperation;
import com.elminster.calc.ops.impl.SqrtOperation;
import com.elminster.calc.ops.impl.UndoOperation;

public enum CalculateOperations {
  PLUS("+", PlusOperation.class),
  MINUS("-", MinusOperation.class),
  MULTIPLY("*", MultiplyOperation.class),
  DIVIDE("/", DivideOperation.class),
  SQRT("sqrt", SqrtOperation.class),
  UNDO("undo", UndoOperation.class),
  CLEAR("clear", ClearOpertaion.class),
  ASSIGN("assign", AssignOperation.class);
  
  private String name;
  @SuppressWarnings("rawtypes")
  private Class<? extends CalculateOperation> clazz;
  
  <T, K> CalculateOperations(String name, Class<? extends CalculateOperation<T, K>> clazz) {
    this.name = name;
    this.clazz = clazz;
  }
  
  public String getName() {
    return name;
  }
  
  @SuppressWarnings("rawtypes")
  public <T, K> Class<? extends CalculateOperation> getClazz() {
    return clazz;
  }
  
  public static CalculateOperations getOperation(String name) throws NoSuchOperationException {
    for (CalculateOperations op : values()) {
      if (op.name.equals(name)) {
        return op;
      }
    }
    throw new NoSuchOperationException(String.format("No such operation [%s].", name));
  }
}
