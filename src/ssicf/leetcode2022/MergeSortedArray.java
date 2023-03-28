package ssicf.leetcode2022;

import java.util.Arrays;

public class MergeSortedArray {
  public static void main(String[] args) {
    MergeSortedArraySolution s = new MergeSortedArraySolution();
    int[] a = new int[1];
    int[] b = new int[]{1};

    s.merge(a, 0, b, 1);
    System.out.println(Arrays.toString(a));
  }
}

class MergeSortedArraySolution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int aIndex = m - 1;
    int bIndex = n - 1;
    while (aIndex >= 0 && bIndex >= 0) {
      if (nums1[aIndex] > nums2[bIndex]) {
        nums1[aIndex + bIndex + 1] = nums1[aIndex];
        aIndex--;
      } else {
        nums1[aIndex + bIndex + 1] = nums2[bIndex];
        bIndex--;
      }
    }
    while (bIndex >=0){
      nums1[bIndex] = nums2[bIndex];
      bIndex--;
    }
  }
}
