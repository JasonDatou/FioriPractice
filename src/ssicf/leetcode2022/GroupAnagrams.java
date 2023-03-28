package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static void main(String[] args) {
    GroupAnagramsSolution s = new GroupAnagramsSolution();
    String[] strs = new String[]{"ddddddddddg", "dgggggggggg"};
    List<List<String>> result = s.groupAnagrams(strs);
    System.out.println(result);
  }
}

class GroupAnagramsSolution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      char[] array = str.toCharArray();
      Arrays.sort(array);
      String key = new String(array);
      List<String> list = map.getOrDefault(key, new ArrayList<String>());
      list.add(str);
      map.put(key, list);
    }
    return new ArrayList<List<String>>(map.values());
  }
}

