package ssicf.leetcode2022;

public class AddStrings {
  public static void main(String[] args){
    AddStringsSolution s = new AddStringsSolution();
    String result = s.addStrings("999", "222");
    System.out.println(result);
  }
}

class AddStringsSolution {
  public String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1, add = 0;
    StringBuilder ans = new StringBuilder();
    while (i >= 0 || j >= 0 || add != 0) {
      int x = i >= 0 ? num1.charAt(i) - '0' : 0;
      int y = j >= 0 ? num2.charAt(j) - '0' : 0;
      int result = x + y + add;
      ans.append(result % 10);
      add = result / 10;
      i--;
      j--;
    }
    return ans.reverse().toString();
  }
}
