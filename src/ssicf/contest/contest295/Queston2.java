package ssicf.contest.contest295;


class Queston2 {
  public static void main(String[] args) {
    Queston2Solution s = new Queston2Solution();
    int result = s.rearrangeCharacters("aaaa", "aa");
    System.out.println(result);
  }
}

//"abbaccaddaeea"
//    "aaaaa"

class Queston2Solution {
  public int rearrangeCharacters(String s, String target) {
    int res = Integer.MAX_VALUE;
    int[] tChars = new int[26];
    for (char c : target.toCharArray())
      tChars[c - 'a']++;
    int[] sChars = new int[26];
    for (char c : s.toCharArray())
      sChars[c - 'a']++;

    for (int i = 0; i < 26; i++) {
      if (tChars[i] > 0) {
        int temp = sChars[i] / tChars[i];
        res = Math.min(res, temp);
      }
    }
    return res;
  }
}
