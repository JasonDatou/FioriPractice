package ssicf.leetcode2022;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
  public static void main(String[] args){
    RomantoIntegerSolution s = new RomantoIntegerSolution();
    int result = s.intToRoman("MCMXCIV");
    System.out.println(result);
  }
}

class RomantoIntegerSolution {
  public int intToRoman(String s) {
    int result = 0;
    Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
    romanMap.put('I', 1);
    romanMap.put('V', 5);
    romanMap.put('X', 10);
    romanMap.put('L', 50);
    romanMap.put('C', 100);
    romanMap.put('D', 500);
    romanMap.put('M', 1000);

    for(int i=0; i<s.length(); i++){
      int currentNum = romanMap.get(s.charAt(i));
      int lastNum = 0;
      if(i>0){
        lastNum = romanMap.get(s.charAt(i-1));
        if(currentNum > lastNum){
          result = result + currentNum - 2 * lastNum;
        }else {
          result += currentNum;
        }
      }else {
        result += currentNum;
      }
    }
    return result;
  }
}
