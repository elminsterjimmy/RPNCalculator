package com.elminster.calc.ops.scaner.impl;

import com.elminster.calc.ops.scaner.Scaner;

public class TokenScaner implements Scaner {
  
  private static final char SPACE = ' ';
  private static final char TAB = '\t';
  
  private String string;
  private int idx;
  
  public TokenScaner(String str) {
    this.string = str;
    this.idx = 0;
  }

  @Override
  public String next() {
    StringBuilder sb = new StringBuilder(10);
    while (idx < string.length()) {
      char c = string.charAt(idx);
      if (SPACE == c || TAB == c) {
        if (sb.length() > 0) {
          return sb.toString();
        }
      } else {
        sb.append(c);
      }
      idx++;
    }
    return sb.toString();
  }

  @Override
  public boolean reachedEOF() {
    return idx >= string.length();
  }

  @Override
  public int currentIdx() {
    return idx;
  }
}
