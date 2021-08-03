package com.elminster.calc.ops.model;

import java.util.Iterator;

public interface CalculationModel<T> {
  
  public T put(T data);
  public T get() throws NoSuchElementException;
  public void clear();
  public void setModel(CalculationModel<T> model);
  public CalculationModel<T> cloneModel();
  
  Iterator<T> iterator();
}
