package com.elminster.calc.ops.exceptions;

public class UnableInitOperationException extends CalculationException {

  /** */
  private static final long serialVersionUID = 1L;

  /** */
  public UnableInitOperationException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public UnableInitOperationException(String message, Throwable cause) {
    super(message, cause);
  }

  /** @param message */
  public UnableInitOperationException(String message) {
    super(message);
  }

  /** @param cause */
  public UnableInitOperationException(Throwable cause) {
    super(cause);
  }
}
