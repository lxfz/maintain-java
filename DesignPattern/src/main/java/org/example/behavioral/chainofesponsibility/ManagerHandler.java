package org.example.behavioral.chainofesponsibility;

import java.math.BigDecimal;

public class ManagerHandler implements Handler {
  public Boolean process(Request request) {
    // 如果超过1000元，处理不了，交下一个处理:
    if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
      return null;
    }
    // 对Bob有偏见, 拒绝Bob:
    return !request.getName().equalsIgnoreCase("bob");
  }
}