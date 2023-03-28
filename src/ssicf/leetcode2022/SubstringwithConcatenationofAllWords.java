package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
  public static void main(String[] args){
    String []words = new String[]{"bar","foo","the"};
    String str = "barfoofoobarthefoobarman";
    SubstringwithConcatenationofAllWordsSolution s = new SubstringwithConcatenationofAllWordsSolution();
    List<Integer> result = s.findSubstring(str, words);
    System.out.println(result);
  }
}

class SubstringwithConcatenationofAllWordsSolution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    int size = words.length;
    int single = words[0].length();
    // init target hashmap
    HashMap<String, Integer> target = new HashMap<>();
    for (String word : words) {
      if (target.containsKey(word))
        target.put(word, target.get(word) + 1);
      else
        target.put(word, 1);
    }
    for(int i=0; i<s.length()-size*single+1; i++){
      if(compare(s.substring(i, i+size*single), target, size, single)){
        result.add(i);
      }
    }
    return result;
  }

  private boolean compare(String s, Map<String,Integer> target, int size, int single){
    HashMap<String, Integer> actual = new HashMap<>();
    for(int i = 0; i < size; i++){
      String word = s.substring(i*single,(i+1)*single);
      if (actual.containsKey(word))
        actual.put(word, actual.get(word) + 1);
      else
        actual.put(word, 1);
    }
    return target.equals(actual);
  }
}
