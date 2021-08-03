package com.elminster.calc.ops.model;

import com.elminster.calc.history.HistoryService;
import com.elminster.calc.history.impl.CalculateModelHistoryService;

public class RPNCalculateContext implements CalcululationContext {
  
  @SuppressWarnings("rawtypes")
  private CalculationModel model;
  private String token;
  @SuppressWarnings("rawtypes")
  private HistoryService historyService;
  private int idx;
  
  public RPNCalculateContext() {
    this.historyService = new CalculateModelHistoryService();
  }

  @Override
  public <T> void setModel(CalculationModel<T> model) {
    this.model = model;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> CalculationModel<T> getCalcatuionModel() {
    return this.model;
  }

  @Override
  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String getToken() {
    return this.token;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> HistoryService<T> getHistoryService() {
    return this.historyService;
  }

  @Override
  public void setIdx(int idx) {
    this.idx = idx;
  }

  @Override
  public int getIdx() {
    return idx;
  }
}
