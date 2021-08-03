package com.elminster.calc.ops.exceptions;

public class UnableMemoException extends CalculationException {

  /** */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public UnableMemoException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public UnableMemoException(String message, Throwable cause) {
    super(message,cause);
  }

  /**
   * @param message
   */
  public UnableMemoException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public UnableMemoException(Throwable cause) {
    super(cause);
  }
}
