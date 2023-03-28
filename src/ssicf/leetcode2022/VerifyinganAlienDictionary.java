package ssicf.leetcode2022;

public class VerifyinganAlienDictionary {
  public static void main(String[] args) {
    VerifyinganAlienDictionarySolution s = new VerifyinganAlienDictionarySolution();
    String[] words = new String[]{"kuvp", "q"};
    boolean result = s.isAlienSorted(words, "ngxlkthsjuoqcpavbfdermiywz");
    System.out.println(result);
  }
}

class VerifyinganAlienDictionarySolution {
  public boolean isAlienSorted(String[] words, String order) {
    int[] ord = new int[26];
    for (int i = 0; i < order.length(); i++) {
      ord[order.charAt(i) - 'a'] = i;
    }
    boolean isValid = false;
    for (int i = 1; i < words.length; i++) {
      int j = 0;
      while (j < words[i].length() && j < words[i - 1].length()) {
        if (ord[words[i].charAt(j) - 'a'] < ord[words[i - 1].charAt(j) - 'a'])
          return false;
        else if (ord[words[i].charAt(j) - 'a'] > ord[words[i - 1].charAt(j) - 'a']){
          isValid = true;
          break;
        }
        j++;
      }
      if(isValid)
        continue;
      if (words[i].length() < words[i - 1].length())
        return false;
    }
    return true;
  }
}
