package ssicf.leetcode2022;

public class SearchinRotatedSortedArray {
  public static void main(String[] args){
    SearchinRotatedSortedArraySolution s = new SearchinRotatedSortedArraySolution();
    int []nums = new int[]{4,5,6,7,0,1,2};
    int result = s.search(nums,0);
    System.out.println(result);
  }
}

class SearchinRotatedSortedArraySolution {
  public int search(int[] nums, int target) {
    int result = -1;
    // find k
    int k = 0;
    for(int i=1; i<nums.length; i++){
      if(nums[i] < nums[i-1]){
        k=i;
        break;
      }
    }
    result = binSearch(nums, 0, k-1, target);
    if(result == -1)
      result = binSearch(nums, k, nums.length-1, target);
    return result;
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
