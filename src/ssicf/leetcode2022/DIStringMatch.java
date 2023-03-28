package ssicf.leetcode2022;

import java.util.Arrays;

public class DIStringMatch {
  public static void main(String[] args) {
    DIStringMatchSolution s = new DIStringMatchSolution();
    int[] result = s.diStringMatch("IDID");
    System.out.println(Arrays.toString(result));
  }
}

class DIStringMatchSolution {
  public int[] diStringMatch(String s) {
    int []res = new int[s.length()+1];
    int max = s.length();
    int min =0;
    for(int i=0; i<s.length(); i++){
      if(s.charAt(i) == 'I')
        res[i]= min++;
      else
        res[i]= max--;
    }
    res[s.length()] = max;
    return res;
  }
}
