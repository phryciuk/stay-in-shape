package org.hryciuk.stayinshape.data_structures.stack;

import java.util.Stack;

class BaseballGame {
  public int calPoints(String[] ops) {
    if (ops == null || ops.length == 0) {
      return 0;
    }
    int points = 0;
    int lastValidRound = 0;
    int secondToLastValidRound = 0;
    Stack<String> stack = new Stack<>();
    for (int i = ops.length - 1; i >= 0; --i) {
      stack.push(ops[i]);
    }

    while (!stack.isEmpty()) {
      String s = stack.pop();
      if (s.equals("D")) {
        points += (lastValidRound * 2);
        secondToLastValidRound = lastValidRound;
        lastValidRound = lastValidRound * 2;
      } else if (s.equals("C")) {
        points -= lastValidRound;
        lastValidRound = secondToLastValidRound;
      } else if (s.equals("+")) {
        points += lastValidRound + secondToLastValidRound;
      } else {
        try {
          int val = Integer.parseInt(s);
          points += val;
          secondToLastValidRound = lastValidRound;
          lastValidRound = val;
        } catch (Exception e) {
          return -99;
        }
      }
    }

    return points;
  }
}
