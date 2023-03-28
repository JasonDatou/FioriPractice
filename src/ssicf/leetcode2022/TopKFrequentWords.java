package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
  public static void main(String[] args){
    TopKFrequentWordsSolution s = new TopKFrequentWordsSolution();
    String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
    List<String> result = s.topKFrequent(words,3);
    System.out.println(result.toString());
  }
}

class TopKFrequentWordsSolution {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> wordsMap = new HashMap<>();
    for(String word : words){
      wordsMap.put(word, wordsMap.getOrDefault(word, 0)+1);
    }
    List<String> wordsList = new ArrayList<>();
    for(Map.Entry<String, Integer> entry : wordsMap.entrySet()){
      wordsList.add(entry.getKey());
    }
    wordsList.sort((o1, o2) -> {
      int count1 = wordsMap.get(o1);
      int count2 = wordsMap.get(o2);
      if (count1 != count2) {
        return count2 - count1;
      } else {
        return o1.compareTo(o2);
      }
    });
    return wordsList.subList(0,k);
  }
}
