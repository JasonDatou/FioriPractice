package ssicf.contest.contest295;


class Queston1 {
  public static void main(String[] args) {
    Queston1Solution s = new Queston1Solution();
    String result = s.discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28);
    System.out.println(result);
  }
}

//"706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6"
//    28

class Queston1Solution {
  public String discountPrices(String sentence, int discount) {
    StringBuilder sb = new StringBuilder();
    String[] words = sentence.split(" ");
    for (int i = 0; i < words.length; i++) {
      if (words[i].charAt(0) == '$') {
        try {
          long num = Long.parseLong(words[i].substring(1));
          double disNum = (double) num / 100 * (100 - discount);
          if (i > 0)
            sb.append(" ");
          sb.append('$').append(String.format("%.2f", disNum));
          continue;
        } catch (NumberFormatException e) {
          if (i > 0)
            sb.append(" ");
          sb.append(words[i]);
          continue;
        }
      }
      if (i > 0)
        sb.append(" ");
      sb.append(words[i]);
    }
    return sb.toString();
  }
}
