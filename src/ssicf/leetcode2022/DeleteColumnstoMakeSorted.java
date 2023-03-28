package ssicf.leetcode2022;

public class DeleteColumnstoMakeSorted {
  public static void main(String[] args) {
    DeleteColumnstoMakeSortedSolution s = new DeleteColumnstoMakeSortedSolution();
    String[] strs = new String[]{"cba", "daf", "ghi"};
    // cba
    // daf
    // ghi
    int result = s.minDeletionSize(strs);
    System.out.println(result);
  }
}

class DeleteColumnstoMakeSortedSolution {
  public int minDeletionSize(String[] strs) {
    int count = 0;
    for (int i=0; i<strs[0].length(); i++) {
      boolean isValid = true;
      for (int j=1; j<strs.length; j++) {
        if (strs[j].charAt(i) < strs[j-1].charAt(i)) {
          isValid = false;
          break;
        }
      }
      if (!isValid)
        count++;
    }
    return count;
  }
}
