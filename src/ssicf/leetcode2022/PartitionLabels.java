package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
  public static void main(String[] args){
    PartitionLabelsSolution s = new PartitionLabelsSolution();
    List<Integer> result = s.partitionLabels("ababcbacadefegdehijhklij");
    System.out.println(result);
  }
}

class PartitionLabelsSolution {
  public List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    int []last = new int[26];
    for(int i=0; i<s.length(); i++){
      last[s.charAt(i) - 'a'] = i;
    }
    int lastPosition = 0;
    int preEnd = 0;
    for(int i=0; i<s.length(); i++){
      lastPosition = Math.max(lastPosition, last[s.charAt(i) - 'a']);
      if(i == lastPosition){
          result.add(i+1-preEnd);
          preEnd = i+1;
      }
    }
    return result;
  }
}
