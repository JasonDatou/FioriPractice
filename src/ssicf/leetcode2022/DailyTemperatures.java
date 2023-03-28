package ssicf.leetcode2022;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
  public static void main(String[] args){
    DailyTemperaturesSolution s = new DailyTemperaturesSolution();
    int[] nums = new int[]{73,74,75,71,69,72,76,73};
    int[] result = s.dailyTemperatures(nums);
    System.out.println(Arrays.toString(result));
  }
}

class DailyTemperaturesSolution {
  public int[] dailyTemperatures(int[] temperatures) {
    int length = temperatures.length;
    int[] ans = new int[length];
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      int temperature = temperatures[i];
      while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
        int prevIndex = stack.pop();
        ans[prevIndex] = i - prevIndex;
      }
      stack.push(i);
    }
    return ans;
  }
}
