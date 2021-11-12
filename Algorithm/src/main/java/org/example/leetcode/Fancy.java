package org.example.leetcode;

import java.util.*;

class Fancy {

  private static final long M = 1_000_000_007;

  private int p = 0; // 空位置
  private int[] a = new int[100001];
  private List<Operation> operationList = new ArrayList<>();


  class Operation{

    public Operation(long type, long val, long position) {
      this.type = type;
      this.val = val;
      this.position = position;
    }

    public long type; // 0=addAll, 1 =multiAll
    public long val;
    public long position;
  }

  public Fancy() {
      
  }
  
  public void append(int val) {
     a[p++] = val; 
  }
  
  public void addAll(int inc) {
    operationList.add(new Operation(0, inc, p-1));
  }
  
  public void multAll(int m) {
    operationList.add(new Operation(1, m, p-1));
  }
  
  public int getIndex(int idx) {
    long res = a[idx];
    if(idx >= p-1) return -1;
    Operation operation = null;
    for(int i=0; i<operationList.size(); i++) {
      operation = operationList.get(i);
      if(operation.position <= idx) {
        if(operation.type == 0) {
          res = (res + operation.val) % M;
        } else {
          res = (res * operation.val) % M;
        }
      } else {
        break;
      }
    }
    return (int)res;
  }
}

/**
* Your Fancy object will be instantiated and called as such:
* Fancy obj = new Fancy();
* obj.append(val);
* obj.addAll(inc);
* obj.multAll(m);
* long param_4 = obj.getIndex(idx);
*/