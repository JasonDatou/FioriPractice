package ssicf.contest.contest298;


class Queston1 {
  public static void main(String[] args) {
    Queston1Solution s = new Queston1Solution();
    String result = s.greatestLetter("AAAAAAAAA");
    System.out.println(result);
  }
}

class Queston1Solution {
  public String greatestLetter(String s) {
    int res = -1;
    boolean[] hash1 = new boolean[26];
    boolean[] hash2 = new boolean[26];
    for (char c : s.toCharArray()) {
      int pos = c >= 'a' ? c - 'a' : c - 'A';
      if (c >= 'a') {
        hash1[pos] = true;
      } else {
        hash2[pos] = true;
      }
      if (hash1[pos] && hash2[pos])
        res = Math.max(res, Character.toUpperCase(c));
    }
    if (res == -1)
      return "";
    else
      return String.valueOf((char) res);
  }
}
