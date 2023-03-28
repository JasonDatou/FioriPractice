package ssicf.leetcode2022;

public class RegularExpressionMatching {
  public static void main(String[] args){
    RegularExpressionMatchingSolution s = new RegularExpressionMatchingSolution();
    boolean result = s.isMatch("aab","c*a*b");
    System.out.println(result);
  }
}

class RegularExpressionMatchingSolution {
  public boolean isMatch(String s, String p) {
    boolean result = true;

    int patternIndex = 0;
    char lastCharInS = s.charAt(0);
    char lastCharInP = p.charAt(0);

    for(int i=0; i<s.length(); i++){
      char sChar = s.charAt(i);
      char pChar;
      if(patternIndex < p.length()){
        pChar = p.charAt(patternIndex);
      }else{
        return false;
      }

      char pCharType = getType(pChar);
      switch (pCharType){
        case 'c':
          if(sChar != pChar ){
            result = false;
          }else{
            patternIndex++; // move to next pattern
          }
          break;
        case '.':
          patternIndex++; // move to next pattern
          break;
        case '*':
          if(getType(lastCharInP) == 'c' && sChar != lastCharInS){
            result = false;
            break;
          }
          break;
        default:
          break;
      }
      lastCharInS = sChar;
      if(patternIndex>0){
        lastCharInP = p.charAt(patternIndex-1);
      }
      if(!result) break;
    }
    return result;

  }

  char getType(char c){
    if(c != '.' && c != '*'){
      return 'c';
    }else{
      return c;
    }
  }
}
