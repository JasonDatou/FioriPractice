package ssicf.leetcode2022;

import java.util.Arrays;

public class PlusOne {
  public static void main(String[] args) {
    PlusOneSolution s = new PlusOneSolution();
    int[] num = new int[]{9};
    int[] result = s.plusOne(num);
    System.out.println(Arrays.toString(result));
  }
}

class PlusOneSolution {
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] += 1;
      if (digits[i] == 10) {
        digits[i] = 0;
      } else {
        break;
      }
    }
    if(digits[0] == 0){
      int [] newDigits = new int[digits.length + 1];
      newDigits[0] = 1;
      System.arraycopy(digits, 0, newDigits, 1, digits.length);
      return newDigits;
    }
    return digits;
  }
}
