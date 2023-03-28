package ssicf.leetcode2022;

public class ConvertaNumbertoHexadecimal {
  public static void main(String[] args) {
    ConvertaNumbertoHexadecimalSolution s = new ConvertaNumbertoHexadecimalSolution();
    String result = s.toHex(26);
    System.out.println(result);
  }
}

class ConvertaNumbertoHexadecimalSolution {
  public String toHex(int num) {
    if (num == 0) {
      return "0";
    }
    StringBuffer sb = new StringBuffer();
    for (int i = 7; i >= 0; i--) {
      int val = (num >> (4 * i)) & 0xf;
      if (sb.length() > 0 || val > 0) {
        char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
        sb.append(digit);
      }
    }
    return sb.toString();
  }
}

