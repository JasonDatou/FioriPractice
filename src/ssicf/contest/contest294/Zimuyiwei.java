package ssicf.contest.contest294;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Zimuyiwei {
  public static void main(String[] args) {
    ZimuyiweiSolution s = new ZimuyiweiSolution();
    String[] words = new String[]{"abba", "baba", "bbaa", "cd", "cd","bbaa"};
    List<String> result = s.removeAnagrams(words);
    System.out.println(result);
  }
}

class ZimuyiweiSolution {
  public List<String> removeAnagrams(String[] words) {
    List<String> res = new ArrayList<>();
    String hash = "";
    for (int i = 0; i < words.length; i++) {
      char[] array = words[i].toCharArray();
      Arrays.sort(array);
      String key = new String(array);
      if (i == 0) {
        hash = key;
        res.add(words[i]);
      } else {
        if (!hash.equals(key)) {
          hash = key;
          res.add(words[i]);
        }
      }
    }
    return res;
  }
}
