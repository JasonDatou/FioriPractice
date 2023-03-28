package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestNumberinMultiplicationTable {
  public static void main(String[] args){
    KthSmallestNumberinMultiplicationTableSolution s = new KthSmallestNumberinMultiplicationTableSolution();
    String result = s.convert("PAYPALISHIRING",3);
    System.out.println(result);
  }
}

class KthSmallestNumberinMultiplicationTableSolution {
  public String convert(String s, int numRows) {
    // Init a StringBuilder list
    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < Math.min(numRows, s.length()); i++)
      rows.add(new StringBuilder());

    int roundTrip = 2 * numRows - 2;
    int currentIndex = 0;
    for ( int i = 0 ; i < s.length() ; i++ ){
      int currentNum = i % roundTrip;
      if(currentNum < numRows){
        // go down
        currentIndex = currentNum;
      }else{
        // go up
        currentIndex = numRows * 2 - currentNum - 2;
      }
      rows.get(currentIndex).append(s.charAt(i));
    }
    //merge rows into one string
    StringBuilder ret = new StringBuilder();
    for (StringBuilder row : rows) ret.append(row);
    return ret.toString();
  }
}
