package ssicf.contest.contest299;


class Queston2 {
  public static void main(String[] args) {
    Queston2Solution s = new Queston2Solution();
    int result = s.countHousePlacements(1000);
    System.out.println(result);
  }
}

class Queston2Solution {
  public int countHousePlacements(int n) {
    return (int) ((pow(fib(n + 2), 2)) % 1000000007);
  }

  public long fib(int n) {
    int[] res = new int[n + 1];
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else {
      res[0] = 0;
      res[1] = 1;
      for (int i = 2; i <= n; i++) {
        res[i] = (res[i - 1] + res[i - 2]) % 1000000007;
      }
      return res[n];
    }
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
