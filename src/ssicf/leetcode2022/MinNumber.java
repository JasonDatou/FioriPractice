package ssicf.leetcode2022;

import java.util.Arrays;

public class MinNumber {
    public static void main(String[] args) {
        MinNumberSolution s = new MinNumberSolution();
        String result = s.minNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(result);
    }
}

class MinNumberSolution {
    public String minNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder ss=new StringBuilder();
        for(String c:s){
            ss.append(c);
        }
        return ss.toString();
    }
}