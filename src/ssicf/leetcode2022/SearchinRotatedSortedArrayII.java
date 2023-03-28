package ssicf.leetcode2022;

public class SearchinRotatedSortedArrayII {
  public static void main(String[] args){
    SearchinRotatedSortedArrayIISolution s = new SearchinRotatedSortedArrayIISolution();
    int []nums = new int[]{1};
//    int []nums = new int[]{-1,0,1,2,4,5,6};
    boolean result = s.search(nums,0);
    System.out.println(result);
  }
}

class SearchinRotatedSortedArrayIISolution {
  public boolean search(int[] nums, int target) {
    if(nums.length < 15){
      for(int num : nums){
        if(num == target)
          return true;
      }
      return false;
    } else {
      int mid = binarySearchMid(nums, 0, nums.length - 1);
      return binarySearch(nums, target, mid + 1, nums.length - 1) ||
          binarySearch(nums, target, 0, mid);
    }
  }

  private int binarySearchMid(int[] nums, int left, int right){
    int mid = (left + right ) / 2;

    if(mid+1==nums.length || nums[mid] > nums[mid+1]){
      return mid;
    }
    if(left >= right)
      return -1;
    int result1 = binarySearchMid(nums, left, mid-1);
    if(result1 == -1){
      return binarySearchMid(nums, mid+1, right);
    }else {
      return result1;
    }
  }

  private boolean binarySearch(int[] nums, int target, int left, int right){
    int mid = (left + right ) / 2;
    if(nums[mid] == target){
      return true;
    }
    if(left >= right)
      return false;
    else if(nums[mid] > target){
      return binarySearch(nums, target, left, mid-1);
    }else if(nums[mid] < target){
      return binarySearch(nums, target, mid +1 , right);
    }
    return false;
  }
}

