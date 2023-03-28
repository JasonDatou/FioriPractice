package ssicf.leetcode2022;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
  public static void main(String[] args) {
    KthLargestElementinanArraySolution s = new KthLargestElementinanArraySolution();
    int[] nums = new int[]{3, 2, 1, 5, 6, 4};
    int result = s.findKthLargest(nums, 1);
    System.out.println(result);
  }
}

class KthLargestElementinanArraySolution {
  public int findKthLargest(int[] nums, int k) {
    int len = nums.length;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }

    for (int i = k; i < len; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }
    return minHeap.peek();
  }
}
