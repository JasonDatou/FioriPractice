package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations  {
  public static void main(String[] args){
    LetterCombinationsSolution s = new LetterCombinationsSolution();
    List<String> result = s.letterCombinations("");
    System.out.println(result.toString());
  }
}

class LetterCombinationsSolution {
      public List<String> letterCombinations(String digits) {
        Map<Character, String> phone = new HashMap<>();
        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");


        // get size
        List<String> result = new ArrayList<>();

        if(digits.isEmpty()) return result;

        backtrack(result, phone, digits, 0, new StringBuffer());
        return result;
  }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
      if (index == digits.length()) {
        combinations.add(combination.toString());
      } else {
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
          combination.append(letters.charAt(i));
          backtrack(combinations, phoneMap, digits, index + 1, combination);
          combination.deleteCharAt(index);
        }
      }
    }

}
