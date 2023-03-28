package ssicf.leetcode2022;

public class AddBinary {
  public static void main(String[] args) {
    AddBinarySolution s = new AddBinarySolution();
    String result = s.addBinary("100", "110010");
    System.out.println(result);
  }
}

class AddBinarySolution {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int aIndex = a.length() - 1;
    int bIndex = b.length() - 1;
    int rest = 0;
    while (rest != 0 || bIndex >= 0 || aIndex >= 0) {
      int anum = aIndex >= 0 ? a.charAt(aIndex--) - '0' : 0;
      int bnum = bIndex >= 0 ? b.charAt(bIndex--) - '0' : 0;
      int res = anum + bnum + rest;
      if (res == 3) {
        sb.append('1');
        rest = 1;
      } else if (res == 2) {
        sb.append('0');
        rest = 1;
      } else {
        sb.append((char) (res + '0'));
        rest = 0;
      }
    }
    return sb.reverse().toString();
  }
}
