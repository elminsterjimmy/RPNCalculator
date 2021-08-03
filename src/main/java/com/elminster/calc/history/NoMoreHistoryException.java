package com.elminster.calc.history;

import com.elminster.calc.ops.exceptions.CalculationException;

public class NoMoreHistoryException extends CalculationException {

  /** */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public NoMoreHistoryException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public NoMoreHistoryException(String message, Throwable cause) {
    super(message,cause);
  }

  /**
   * @param message
   */
  public NoMoreHistoryException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public NoMoreHistoryException(Throwable cause) {
    super(cause);
  }
}
