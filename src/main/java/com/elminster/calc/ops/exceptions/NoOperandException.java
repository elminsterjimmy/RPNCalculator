package com.elminster.calc.ops.exceptions;

public class NoOperandException extends CalculationException {

  /** */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public NoOperandException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public NoOperandException(String message, Throwable cause) {
    super(message,cause);
  }

  /**
   * @param message
   */
  public NoOperandException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public NoOperandException(Throwable cause) {
    super(cause);
  }
}
