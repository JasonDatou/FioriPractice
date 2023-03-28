package ssicf.leetcode2022;

public class PalindromeNumber {
  public static void main(String[] args){
    PalindromeNumberSolution s = new PalindromeNumberSolution();
    boolean result = s.isPalindrome(121);
    System.out.println(result);
  }
}

class PalindromeNumberSolution {
  public boolean isPalindrome(int x) {
    if(x < 0){
      return false;
    }
    if(x < 10){
      return true;
    }
    String s =  String.valueOf(x);
    int length = s.length();
    float halfLength = (float)length / 2;

    boolean result = true;
    for(int i = 0; i < halfLength; i++){
      if(s.charAt(i) != s.charAt(length-i-1)){
        result = false;
        break;
      }
    }
    return result;
  }
}
