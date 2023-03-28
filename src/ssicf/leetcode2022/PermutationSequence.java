package ssicf.leetcode2022;

public class PermutationSequence {
  public static void main(String[] args) {
    PermutationSequenceSolution s = new PermutationSequenceSolution();
    String result = s.getPermutation(3, 2);
    System.out.println(result);
  }
}

class PermutationSequenceSolution {
  public String getPermutation(int n, int k) {
    int[] nums = new int[n];  // 1, 2, 3, 4
    boolean[] used = new boolean[n];  // 1, 2, 3, 4
    int amount = 1;  // 24
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
      amount *= nums[i];
    }
    int[] combos = new int[n]; // 6, 2, 2, 1
    for (int i = 0; i < n; i++) {
      combos[i] = amount / nums[n - i - 1];
      amount = combos[i];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int position = (k - 1) / combos[i];
      int index = 0;
      while (true) {
        if (!used[index]) {
          if (position == 0)
            break;
          position--;
        }
        index++;
      }
      used[index] = true;
      sb.append(nums[index]);
      k = k % combos[i];
      if(k == 0)
        k = combos[i];
    }
    return sb.toString();
  }
}
