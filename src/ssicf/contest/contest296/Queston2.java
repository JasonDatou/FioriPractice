package ssicf.contest.contest296;


import java.util.Arrays;

class Queston2 {
  public static void main(String[] args) {
    Queston2Solution s = new Queston2Solution();
    int[] nums = new int[]{3,6,1,2,5};
    int result = s.partitionArray(nums, 2);
    System.out.println(result);
  }
}

//"abbaccaddaeea"
//    "aaaaa"

class Queston2Solution {
  public int partitionArray(int[] nums, int k) {
    int res = 0;
    Arrays.sort(nums);
    int i = 0;
    while (i < nums.length) {
      int minIndex = i;
      while (i < nums.length && nums[i] - nums[minIndex] <= k) {
        i++;
      }
      res++;
    }
    return res;
  }
}
