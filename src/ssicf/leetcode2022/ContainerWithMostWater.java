package ssicf.leetcode2022;

public class ContainerWithMostWater {
  public static void main(String[] args){
    ContainerWithMostWaterSolution s = new ContainerWithMostWaterSolution();
    int []height = new int[]{1,8,6,2,5,4,8,3,7};
    int result = s.maxArea(height);
    System.out.println(result);
  }
}

class ContainerWithMostWaterSolution {
//  public int maxArea(int[] height) {
//    // 遍历所有可能
//    int maxArea = 0;
//    int length = height.length;
//    for(int i=0; i < length; i++){
//      for(int j=i+1; j < length; j++){
//        int area = Math.min(height[i], height[j]) * (j - i);
//        if(area > maxArea) maxArea = area;
//      }
//    }
//    return maxArea;
//  }

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    while (left < right){
      int area = Math.min(height[left], height[right]) * (right - left);
      if(area > maxArea) maxArea = area;
      if(height[left] < height[right]) left++;
      else right--;
    }
    return maxArea;
  }
}
