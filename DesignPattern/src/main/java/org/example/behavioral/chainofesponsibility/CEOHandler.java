package org.example.behavioral.chainofesponsibility;

import java.math.BigDecimal;

public class CEOHandler implements Handler{
  public Boolean process(Request request) {
    // CEO 可以审核任意额度。
    return Boolean.TRUE;
  }
}
