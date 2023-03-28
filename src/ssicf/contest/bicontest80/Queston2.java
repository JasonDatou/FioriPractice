package ssicf.contest.bicontest80;


import java.util.Arrays;
import java.util.TreeMap;

class Queston2 {
  public static void main(String[] args) {
    Queston2Solution s = new Queston2Solution();
    int[] spells = new int[]{5, 1, 3};
    int[] potions = new int[]{1, 2, 3, 4, 5};
    int[] result = s.successfulPairs(spells, potions, 7);
    System.out.println(Arrays.toString(result));
  }
}

//[40,11,24,28,40,22,26,38,28,10,31,16,10,37,13,21,9,22,21,18,34,2,40,40,6,16,9,14,14,15,37,15,32,4,27,20,24,12,26,39,32,39,20,19,22,33,2,22,9,18,12,5]
//    [31,40,29,19,27,16,25,8,33,25,36,21,7,27,40,24,18,26,32,25,22,21,38,22,37,34,15,36,21,22,37,14,31,20,36,27,28,32,21,26,33,37,27,39,19,36,20,23,25,39,40]
//    600

class Queston2Solution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    TreeMap<Long, Integer> map = new TreeMap<>();
    map.put(Long.MAX_VALUE, potions.length);
    for (int i = potions.length - 1; i >= 0; i--) {
      map.put((long) potions[i], i);
    }
    for (int i = 0; i < spells.length; i++) {
      spells[i] = potions.length - map.ceilingEntry((success + spells[i] - 1) / spells[i]).getValue();
    }
    return spells;
  }
}
