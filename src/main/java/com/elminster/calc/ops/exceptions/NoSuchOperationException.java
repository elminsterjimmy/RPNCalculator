package com.elminster.calc.ops.exceptions;

public class NoSuchOperationException extends CalculationException {

  /** */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public NoSuchOperationException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public NoSuchOperationException(String message, Throwable cause) {
    super(message,cause);
  }

  /**
   * @param message
   */
  public NoSuchOperationException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public NoSuchOperationException(Throwable cause) {
    super(cause);
  }
}
