package com.elminster.calc.history;

import java.util.List;

public interface HistoryService<T> {
  
  public T put(T model);
  public T get() throws NoMoreHistoryException;
  public void clear();
  public List<T> listHistories();
}
