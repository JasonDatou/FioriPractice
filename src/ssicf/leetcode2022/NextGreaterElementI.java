package ssicf.leetcode2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
  public static void main(String[] args) {
    NextGreaterElementISolution s = new NextGreaterElementISolution();
    int[] nums1 = new int[]{4, 1, 2};
    int[] nums2 = new int[]{1, 3, 4, 2};
    int[] result = s.nextGreaterElement(nums1, nums2);
    System.out.println(Arrays.toString(result));
  }
}

class NextGreaterElementISolution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length];
    Map<Integer, Integer> monoRes = new HashMap<>();
    Deque<Integer> monostack = new ArrayDeque<>();
    for (int i = 0; i < nums2.length; i++) {
      while (!monostack.isEmpty() && nums2[monostack.peek()] < nums2[i]) {
        monoRes.put(nums2[monostack.pop()], nums2[i]);
      }
      monostack.push(i);
    }
    for (int i = 0; i < nums1.length; i++) {
      res[i] = monoRes.getOrDefault(nums1[i], -1);
    }
    return res;
  }
}
