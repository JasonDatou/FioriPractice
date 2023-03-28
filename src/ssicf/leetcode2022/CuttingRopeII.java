package ssicf.leetcode2022;

public class CuttingRopeII {
  public static void main(String[] args) {
    CuttingRopeIISolution s = new CuttingRopeIISolution();
    int result = s.cuttingRope(120);
    System.out.println(result);
  }
}

class CuttingRopeIISolution {
  public int cuttingRope(int n) {
    if (n <= 3) return n - 1;
    int a = n / 3, b = n % 3;
    if (b == 0) return (int) (pow(3, a) % 1000000007);
    if (b == 1) return (int) (pow(3, a - 1) * 4 % 1000000007);
    return (int) (pow(3, a) * 2 % 1000000007);
  }

  long pow(long n,long m){
    long ans=1;
    while(m > 0){
      ans=ans*n%1000000007;
      --m;
    }
    return ans;
  }
}
