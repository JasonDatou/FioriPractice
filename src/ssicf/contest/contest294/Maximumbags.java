package ssicf.contest.contest294;


import java.util.Arrays;

class Maximumbags {
  public static void main(String[] args) {
    MaximumbagsSolution s = new MaximumbagsSolution();
    int[] capacity = new int[]{2, 3, 4, 5};
    int[] rocks = new int[]{1, 2, 4, 4};
    int result = s.maximumBags(capacity, rocks, 2);
    System.out.println(result);
  }
}

class MaximumbagsSolution {
  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int[] rest = new int[capacity.length];
    for (int i = 0; i < capacity.length; i++) {
      rest[i] = capacity[i] - rocks[i];
    }
    Arrays.sort(rest);
    int res = 0;
    for (int value : rest) {
      if (value == 0)
        res++;
      else {
        if (additionalRocks >= value) {
          additionalRocks -= value;
          res++;
        } else {
          break;
        }
      }
    }
    return res;
  }
}
