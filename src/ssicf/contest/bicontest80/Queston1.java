package ssicf.contest.bicontest80;


class Queston1 {
  public static void main(String[] args) {
    Queston1Solution s = new Queston1Solution();
    boolean result = s.strongPasswordCheckerII("IloveLe3tcode!");
    System.out.println(result);
  }
}

// 0 1 2 3 4 5 6 7 8
// 0 0 / 2
// 1 2 / 2
// 2 4 / 2
class Queston1Solution {
  public boolean strongPasswordCheckerII(String password) {
    boolean containsCap = false;
    boolean containsSmall = false;
    boolean containsDigit = false;
    boolean containsSpecial= false;

    String special = "!@#$%^&*()-+";
    boolean[] isspecial = new boolean[128];
    for (char c : special.toCharArray()) {
      isspecial[c] = true;
    }
    char last = 0;
    if (password.length() < 8)
      return false;
    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      if (c >= 'a' && c <= 'z')
        containsSmall = true;
      if (c >= 'A' && c <= 'Z')
        containsCap = true;
      if (c >= '0' && c <= '9')
        containsDigit = true;
      if (isspecial[c])
        containsSpecial = true;
      if (i > 0) {
        if (last == c) {
          return false;
        }
      }
      last = c;
    }
    return containsSmall && containsCap && containsDigit && containsSpecial;
  }
}
