package ssicf.contest.contest296;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Queston3 {
  public static void main(String[] args) {
    Queston3Solution s = new Queston3Solution();
    int[] nums = new int[]{1, 2, 4, 6};
    int[][] operations = new int[][]{{1, 3}, {4, 7}, {6, 1}};
//    int[] nums = new int[]{1, 2};
//    int[][] operations = new int[][]{{1, 3}, {2, 1}, {3, 2}};
//    int[] nums = new int[]{1};
//    int[][] operations = new int[][]{{1, 2}, {2, 3}, {3, 1000000}, {1000000, 1}};
    int[] result = s.arrayChange(nums, operations);
    System.out.println(Arrays.toString(result));
  }
}

class Queston3Solution {
  public int[] arrayChange(int[] nums, int[][] operations) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> revmap = new HashMap<>();
    for (int[] op : operations) {
      if (revmap.containsKey(op[0])) {
        map.put(revmap.get(op[0]), op[1]);
        revmap.put(op[1], revmap.get(op[0]));
        revmap.remove(op[0]);
      } else {
        map.put(op[0], op[1]);
        revmap.put(op[1], op[0]);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]))
        nums[i] = map.get(nums[i]);
    }
    return nums;
  }
}
