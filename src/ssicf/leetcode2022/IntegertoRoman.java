package ssicf.leetcode2022;

public class IntegertoRoman {
  public static void main(String[] args){
    IntegertoRomanSolution s = new IntegertoRomanSolution();
    String result = s.intToRoman(1994);
    System.out.println(result);
  }
}

class IntegertoRomanSolution {
  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    Roman[] romanList = new Roman[13];
    romanList[12] = new Roman(1, "I");
    romanList[11] = new Roman(4, "IV");
    romanList[10] = new Roman(5, "V");
    romanList[9] = new Roman(9, "IX");
    romanList[8] = new Roman(10, "X");
    romanList[7] = new Roman(40, "XL");
    romanList[6] = new Roman(50, "L");
    romanList[5] = new Roman(90, "XC");
    romanList[4] = new Roman(100, "C");
    romanList[3] = new Roman(400, "CD");
    romanList[2] = new Roman(500, "D");
    romanList[1] = new Roman(900, "CM");
    romanList[0] = new Roman(1000, "M");
    int numTemp = num;
    for (Roman roman : romanList) {
      int count = numTemp / roman.i;
      for (int j = 0; j < count; j++) {
        sb.append(roman.c);
      }
      numTemp %= roman.i;
    }
    return sb.toString();
  }
}

class Roman{
  int i;
  String c;

  public Roman(int i1, String c1) {
    i = i1;
    c = c1;
  }
}
