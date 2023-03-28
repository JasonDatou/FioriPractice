package ssicf.leetcode2022;

public class ImplementstrStr {
  public static void main(String[] args){
    ImplementstrStrSolution s = new ImplementstrStrSolution();
    int result = s.strStr("a","a");
    System.out.println(result);
  }
}

class ImplementstrStrSolution {
  public int strStr(String haystack, String needle) {
    if(needle.isEmpty())
      return 0;
    int x = haystack.length();
    int y = needle.length();

    for(int i=0;i<x-y+1; i++){
      boolean same = true;
      for(int j=0; j<y; j++){
        if(needle.charAt(j) != haystack.charAt(i+j)){
          same = false;
          break;
        }
      }
      if(same)
        return i;
    }
    return -1;
  }
}

