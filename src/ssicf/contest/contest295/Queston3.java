package ssicf.contest.contest295;


class Queston3 {
  public static void main(String[] args) {
    Queston3Solution s = new Queston3Solution();
    int[] nums = new int[]{5,3,4,4,7,3,6,11,8,5,11};
    int result = s.totalSteps(nums);
    System.out.println(result);
  }
}

class Queston3Solution {
  int res = 0;

  public int totalSteps(int[] nums) {
    backTrack(nums.length, nums);
    return res-1;
  }

  void backTrack(int length, int[] nums) {
    res++;
    int currIndex = 1;
    for (int i = 1; i < length; i++) {
      int previous = nums[i - 1];
      swap(currIndex, i, nums);
      if (nums[i] >= previous) {
        currIndex++;
      }
    }
    if (currIndex != length)
      backTrack(currIndex, nums);
  }

  void swap(int i, int j, int[] nums) {
    if (i != j) {
      nums[i] = nums[j];
    }
  }
}
