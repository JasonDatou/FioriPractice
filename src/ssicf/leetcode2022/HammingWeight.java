package ssicf.leetcode2022;

public class HammingWeight {
  public static void main(String[] args) {
    HammingWeightSolution s = new HammingWeightSolution();
    int result = s.hammingWeight(11);
    System.out.println(result);
  }
}

// A B C E
// S F C S
// A D E E

class HammingWeightSolution {
  public int hammingWeight(int n) {
    int res = 0;
    while (n != 0){
      n &= n-1;
      res++;
    }
    return res;
  }
}


//public class Solution {
//  public int hammingWeight(int n) {
//    int ans = 0;
//    while (n != 0) {
//      ans += (n & 1);
//      n >>>= 1;
//    }
//    return ans;
//  }
//}
