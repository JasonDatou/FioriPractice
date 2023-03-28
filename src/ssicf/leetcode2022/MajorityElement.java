package ssicf.leetcode2022;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElementSolution s = new MajorityElementSolution();
        int result = s.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(result);
    }
}

class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        int major = nums.length / 2;
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : nums){
            int count = numMap.getOrDefault(num, 0)+1;
            if(count > major)
                return num;
            numMap.put(num, count);
        }
        return 0;
    }
}
