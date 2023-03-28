package ssicf.leetcode2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        PermutationSolution s = new PermutationSolution();
        String[] result = s.permutation("aab");
        System.out.println(Arrays.toString(result));
    }
}

class PermutationSolution {
    Set<String> res = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    public String[] permutation(String s) {
        boolean []vis = new boolean[s.length()];
        backTrack(s, vis);
        return res.toArray(new String[0]);
    }

    private void backTrack(String s, boolean []vis) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(vis[i])
                continue;
            sb.append(s.charAt(i));
            vis[i] = true;
            backTrack(s, vis);
            vis[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
