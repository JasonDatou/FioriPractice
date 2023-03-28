package ssicf.contest.bicontest79;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ZuiDuoDanCi {
  public static void main(String[] args) {
    ZuiDuoDanCiSolution s = new ZuiDuoDanCiSolution();
    String[] messages = new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"};
    String[] senders = new String[]{"Bob", "Charlie"};
    String result = s.largestWordCount(messages, senders);
    System.out.println(result);
  }
}

class ZuiDuoDanCiSolution {
  public String largestWordCount(String[] messages, String[] senders) {
    int maxCount = 0;
    List<String> senderList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < messages.length; i++) {
      int count = map.getOrDefault(senders[i], 0) + countWords(messages[i]);
      map.put(senders[i], count);
      if (count > maxCount) {
        maxCount = count;
        senderList.clear();
        senderList.add(senders[i]);
      } else if (count == maxCount) {
        senderList.add(senders[i]);
      }
    }
    Collections.sort(senderList);
    return senderList.get(senderList.size() - 1);
  }

  int countWords(String str) {
    if (str.isEmpty())
      return 0;
    int count = 1;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ')
        count++;
    }
    return count;
  }
}
