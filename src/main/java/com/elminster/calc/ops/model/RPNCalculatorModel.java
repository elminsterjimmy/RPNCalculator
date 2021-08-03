package com.elminster.calc.ops.model;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class RPNCalculatorModel implements CalculationModel<BigDecimal> {

  Stack<BigDecimal> stack = new Stack<>();

  @Override
  public BigDecimal get() throws NoSuchElementException {
    try {
      BigDecimal data = stack.pop();
      return data;
    } catch (EmptyStackException ese) {
      throw new NoSuchElementException(ese);
    }
  }

  @Override
  public BigDecimal put(BigDecimal data) {
    return this.stack.push(data);
  }

  @Override
  public void clear() {
    this.stack.clear();
  }

  @Override
  public void setModel(CalculationModel<BigDecimal> model) {
    this.stack = ((RPNCalculatorModel)model).stack;
  }

  @Override
  public CalculationModel<BigDecimal> cloneModel() {
    try {
      return this.clone();
    } catch (CloneNotSupportedException e) {
      // should not happened
      return null;
    }
  }

  @Override
  protected RPNCalculatorModel clone() throws CloneNotSupportedException {
    RPNCalculatorModel cloned = new RPNCalculatorModel();
    Stack<BigDecimal> st = new Stack<>();
    for (BigDecimal bd : this.stack) {
      st.add(bd);
    }
    cloned.stack = st;
    return cloned;
  }

  @Override
  public String toString() {
    return stack.toString();
  }

  @Override
  public Iterator<BigDecimal> iterator() {
    return stack.iterator();
  }
}
