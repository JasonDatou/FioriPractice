package ssicf.Leetcode2023;

public class GasStation {
  public static void main(String[] args) {
    GasStationSolution s = new GasStationSolution();
    int[] gas = new int[]{1, 2, 3, 4, 5};
    int[] cost = new int[]{3, 4, 5, 1, 2};

    int result = s.canCompleteCircuit(gas, cost);
//    boolean result = s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
//        "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
//        "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
//    boolean result = s.isInterleave("a", "b", "a");
    System.out.println(result);
  }
}

class GasStationSolution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int spare = 0;
    int min = Integer.MAX_VALUE;
    int minIndex = 0;
    for (int i = 0; i < n; i++) {
      spare += (gas[i] - cost[i]);
      if (spare < min) {
        min = spare;
        minIndex = i;
      }
    }
    if (spare < 0)
      return -1;
    else
      return (minIndex + 1) % n;
  }
}