package ssicf.contest.contest296;


class Queston1 {
  public static void main(String[] args) {
    Queston1Solution s = new Queston1Solution();
    int[] nums = new int[]{3};
    int result = s.minMaxGame(nums);
    System.out.println(result);
  }
}

// 0 1 2 3 4 5 6 7 8
// 0 0 / 2
// 1 2 / 2
// 2 4 / 2
class Queston1Solution {
  public int minMaxGame(int[] nums) {
    int length = nums.length;
    while (length != 1) {
      length = length >> 1;
      for (int i = 0; i < length; i++) {
        if (i % 2 == 0)
          nums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
        else
          nums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
      }
    }
    return nums[0];
  }
}
