package com.elminster.calc.ops.model;

import com.elminster.calc.ops.exceptions.CalculationException;

public class NoSuchElementException extends CalculationException {

  /** */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public NoSuchElementException() {
    super();
  }

  /**
   * @param message
   * @param cause
   */
  public NoSuchElementException(String message, Throwable cause) {
    super(message,cause);
  }

  /**
   * @param message
   */
  public NoSuchElementException(String message) {
    super(message);
  }

  /**
   * @param cause
   */
  public NoSuchElementException(Throwable cause) {
    super(cause);
  }
}
