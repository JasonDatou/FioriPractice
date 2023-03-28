package ssicf.leetcode2022;

public class RemoveDuplicatesfromSortedArrayII {
  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 2, 3, 3};
    RemoveDuplicatesfromSortedArrayIISolution s = new RemoveDuplicatesfromSortedArrayIISolution();
    int result = s.removeDuplicates(nums);
    System.out.println(result);
  }
}

class RemoveDuplicatesfromSortedArrayIISolution {
  public int removeDuplicates(int[] nums) {
    int index = 1;
    int tempCount = 1;
    int previous = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != previous) {
        tempCount = 1;
      } else {
        tempCount++;
      }
      previous = nums[i];
      if (i != index)
        swap(i, index, nums);
      if (tempCount <= 2) {
        index++;
      }
    }
    return index;
  }

  private void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
