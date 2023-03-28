package ssicf.leetcode2022;

public class SearchInsertPosition {
  public static void main(String[] args){
    SearchInsertPositionSolution s = new SearchInsertPositionSolution();
    int []nums = new int[]{1,3};
    int result = s.searchInsert(nums,0);
    System.out.println(result);
  }
}

class SearchInsertPositionSolution {
  public int searchInsert(int[] nums, int target) {
    return binSearch(nums, 0, nums.length-1, target);

  }

  private int binSearch(int srcArray[], int start, int end, int key) {
    int mid = (end - start) / 2 + start;
    if (srcArray[mid] == key) {
      return mid;
    }
    if (start >= end) {
      return (end < 0) || (srcArray[end] < key) ? end+1 : end;
    } else if (key > srcArray[mid]) {
      return binSearch(srcArray, mid + 1, end, key);
    } else if (key < srcArray[mid]) {
      return binSearch(srcArray, start, mid - 1, key);
    }
    return -1;
  }
}
