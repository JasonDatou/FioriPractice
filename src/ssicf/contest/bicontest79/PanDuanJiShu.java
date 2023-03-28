package ssicf.contest.bicontest79;


class PanDuanJiShu {
  public static void main(String[] args) {
    PanDuanJiShuSolution s = new PanDuanJiShuSolution();
    boolean result = s.digitCount("030");
    System.out.println(result);
  }
}

class PanDuanJiShuSolution {
  public boolean digitCount(String num) {
    int[] hash = new int[11];
    for (int i = 0; i < num.length(); i++) {
      hash[num.charAt(i) - '0']++;
    }
    for (int i = 0; i < num.length(); i++) {
      if (hash[i] != num.charAt(i) - '0')
        return false;
    }
    return true;
  }
}
