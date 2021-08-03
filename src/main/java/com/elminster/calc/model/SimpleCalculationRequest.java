package com.elminster.calc.model;

public class SimpleCalculationRequest implements CalculationRequest {

  private String input;

  public SimpleCalculationRequest(String input) {
    this.input = input;
  }

  @Override
  public Object getRequest() {
    return this.input;
  }
}
