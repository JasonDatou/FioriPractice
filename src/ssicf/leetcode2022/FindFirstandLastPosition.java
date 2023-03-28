package ssicf.leetcode2022;

import java.util.Arrays;

public class FindFirstandLastPosition {
  public static void main(String[] args){
    FindFirstandLastPositionSolution s = new FindFirstandLastPositionSolution();
    int []nums = new int[]{1};
    int[] result = s.searchRange(nums,1);
    System.out.println(Arrays.toString(result));
  }
}

class FindFirstandLastPositionSolution {
  public int[] searchRange(int[] nums, int target) {
    int []result = new int[]{-1,-1};
    if(nums.length == 0)
      return result;
    int mid = binSearch(nums, 0, nums.length-1, target);
    if(mid == -1)
      return result;
    else{
      result[0] = findFirst(nums, mid, target);
      result[1] = findLast(nums, mid, target);
      return result;
    }
  }

  private int findFirst(int[] nums, int mid, int target){
    int result = mid;
    while (nums[result] == target){
      result--;
      if(result == -1)
        return 0;
    }
    return result + 1;
  }

  private int findLast(int[] nums, int mid, int target){
    int result = mid;
    while (nums[result] == target){
      result++;
      if(result == nums.length)
        return nums.length-1;
    }
    return result - 1;
  }

  private int binSearch(int srcArray[], int start, int end, int key) {
    int mid = (end - start) / 2 + start;
    if (srcArray[mid] == key) {
      return mid;
    }
    if (start >= end) {
      return -1;
    } else if (key > srcArray[mid]) {
      return binSearch(srcArray, mid + 1, end, key);
    } else if (key < srcArray[mid]) {
      return binSearch(srcArray, start, mid - 1, key);
    }
    return -1;
  }
}
