package com.elminster.calc.ops.exceptions;

public class NotEnoughOperandException extends CalculationException {

  /** */
  private static final long serialVersionUID = 1L;

  /** */
  public NotEnoughOperandException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public NotEnoughOperandException(String message, Throwable cause) {
    super(message, cause);
  }

  /** @param message */
  public NotEnoughOperandException(String message) {
    super(message);
  }

  /** @param cause */
  public NotEnoughOperandException(Throwable cause) {
    super(cause);
  }
}
