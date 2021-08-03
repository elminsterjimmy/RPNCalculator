package com.elminster.calc.ops.scaner;

public interface Scaner {
  
  String next();
  
  boolean reachedEOF();
  
  int currentIdx();
}
