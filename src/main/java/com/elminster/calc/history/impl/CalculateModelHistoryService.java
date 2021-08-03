package com.elminster.calc.history.impl;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.elminster.calc.history.HistoryService;
import com.elminster.calc.ops.model.CalculationModel;

@SuppressWarnings("rawtypes")
public class CalculateModelHistoryService implements HistoryService<CalculationModel> {

  private Stack<CalculationModel> snapshots = new Stack<>();

  @Override
  public CalculationModel put(CalculationModel model) {
    return snapshots.push(model.cloneModel());
  }

  @Override
  public CalculationModel get() {
    return snapshots.pop();
  }

  @Override
  public void clear() {
    snapshots.clear();
  }

  @Override
  public List<CalculationModel> listHistories() {
    return Collections.unmodifiableList(snapshots);
  }
}
