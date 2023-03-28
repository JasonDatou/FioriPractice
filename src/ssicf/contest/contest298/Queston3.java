package ssicf.contest.contest298;


class Queston3 {
  public static void main(String[] args) {
    Queston3Solution s = new Queston3Solution();
    double result = s.longestSubsequence("00101001", 6);
    System.out.println(result);
  }
}

class Queston3Solution {
  public int longestSubsequence(String s, int k) {
    int zeros = 0;
    for(char c: s.toCharArray()){
      if(c=='0') zeros++;
    }
    int ones = 0;
    for(int i = s.length()-1; i>=0; i--){
      if(s.charAt(i)=='1'){
        if(s.length()-i > 32) break;  // 判断超出int上限
        if(Long.parseLong(s.substring(i),2) > k){
          break;
        }
        ones++;
      }
    }
    return zeros + ones;
  }
}
