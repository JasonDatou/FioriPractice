package ssicf.leetcode2022;

public class TrappingRainWater {
  public static void main(String[] args) {
    TrappingRainWaterSolution s = new TrappingRainWaterSolution();
    int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    int result = s.trap(heights);
    System.out.println(result);
  }
}

class TrappingRainWaterSolution {
  public int trap(int[] height) {
    int result = 0;
    int left = height[0];
    int[] right = new int[height.length];
    int rightMax = height[height.length - 1];
    for (int i = height.length - 1; i > 0; i--) {
      rightMax = Math.max(height[i], rightMax);
      right[i] = rightMax;
    }
    for (int i = 1; i < height.length - 1; i++) {
      result += Math.max(Math.min(left, right[i + 1]), height[i]) - height[i];
      left = Math.max(left, height[i]);
    }
    return result;
  }
}
