package ssicf.leetcode2022;

import java.util.Deque;
import java.util.LinkedList;

public class SimplyPath {
  public static void main(String[] args) {
    SimplyPathSolution s = new SimplyPathSolution();
    String result = s.simplifyPath("/../");
    System.out.println(result);
  }
}

class SimplyPathSolution {
  public String simplifyPath(String path) {
    String[] paths = path.split("/");
    Deque<String> stack = new LinkedList<>();
    for (String s : paths) {
      if (s.equals("..")) {
        if (!stack.isEmpty())
          stack.pop();
      } else if (!s.isEmpty() && !s.equals(".")) {
        stack.push(s);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/").append(stack.pollLast());
    }
    String res = sb.toString();
    if (res.isEmpty())
      return "/";
    else
      return sb.toString();
  }
}
