package ssicf.Leetcode2023;

import java.util.HashSet;
import java.util.Set;
import ssicf.commons.TreeNode;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    LongestConsecutiveSequenceSolution s = new LongestConsecutiveSequenceSolution();
    int result = s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    System.out.println(result);
  }
}

class LongestConsecutiveSequenceSolution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> numset = new HashSet<>();
    for (int num : nums) {
      numset.add(num);
    }
    int longest = 0;
    for (int num : numset) {
      int curr = 1;
      if (!numset.contains(num - 1)) {
        while (numset.contains(num + 1)) {
          curr++;
          num++;
        }
        longest = Math.max(longest, curr);
      }
    }
    return longest;

  }
}