package com.elminster.calc.ops.exceptions;

public class CalculationException extends Exception {

  /** */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public CalculationException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public CalculationException(String message, Throwable cause) {
    super(message,cause);
  }

  /**
   * @param message
   */
  public CalculationException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public CalculationException(Throwable cause) {
    super(cause);
  }
}
