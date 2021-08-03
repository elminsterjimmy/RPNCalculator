package com.elminster.calc.ops.model;

import com.elminster.calc.history.HistoryService;

public interface CalcululationContext {
  
  <T> void setModel(CalculationModel<T> model);
  
  <T> CalculationModel<T> getCalcatuionModel();

  void setToken(String token);
  
  String getToken();

  <T> HistoryService<T> getHistoryService();

  void setIdx(int idx);
  
  int getIdx();
}
