package ssicf.leetcode2022;

public class JumpGameII {
  public static void main(String[] args) {
    JumpGameIISolution s = new JumpGameIISolution();
    int[] nums = new int[]{5, 8, 1, 8, 9, 8, 7, 1, 7, 5, 8, 6, 5, 4, 7, 3, 9, 9, 0, 6, 6, 3, 4, 8, 0, 5, 8, 9, 5, 3, 7, 2, 1, 8, 2, 3, 8, 9, 4, 7, 6, 2, 5, 2, 8, 2, 7, 9, 3, 7, 6, 9, 2, 0, 8, 2, 7, 8, 4, 4, 1, 1, 6, 4, 1, 0, 7, 2, 0, 3, 9, 8, 7, 7, 0, 6, 9, 9, 7, 3, 6, 3, 4, 8, 6, 4, 3, 3, 2, 7, 8, 5, 8, 6, 0};
//    int[] nums = new int[]{2, 3, 1, 1, 4};
    int result = s.jump(nums);
    System.out.println(result);
  }
}

class JumpGameIISolution {
  public int jump(int[] nums) {
    int length = nums.length;
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < length - 1; i++) {
      maxPosition = Math.max(maxPosition, i + nums[i]);
      if (maxPosition >= length - 1) {
        steps++;
        break;
      }
      if (i == end) {
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }
}


/*
1, {3, 1, 1, 4}

1, {1,1,4}
  2 {1,4}
    3 (4)
*/
