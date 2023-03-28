package ssicf.contest.bicontest79;


import java.util.Arrays;

class DaoLu {
  public static void main(String[] args) {
    DaoLuSolution s = new DaoLuSolution();
    int[][] roads = new int[][]{{0, 1}};
    long result = s.maximumImportance(2, roads);
    System.out.println(result);
  }
}

class DaoLuSolution {
  public long maximumImportance(int n, int[][] roads) {
    int[] deg = new int[n];
    for (int[] road : roads) {
      deg[road[0]]++;
      deg[road[1]]++;
    }
    Arrays.sort(deg);
    long res = 0;
    for (int i = 1; i <= n; i++) {
      res += (long) i * deg[i - 1];
    }
    return res;
  }
}

//  int res = 0;
//  Map<Integer, Integer> map = new HashMap<>();
//    for (int i = 0; i < n; i++) {
//    map.put(i, 0);
//    }
//    for (int[] road : roads) {
//    map.put(road[0], map.get(road[0]) + 1);
//    map.put(road[1], map.get(road[1]) + 1);
//    }
//    List<Integer> list = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
//    .map(Map.Entry::getKey).collect(Collectors.toList());
//    Map<Integer, Integer> map2 = new HashMap<>();
//    for (int i = 0; i < list.size(); i++) {
//    map2.put(list.get(i), n - i);
//    }
//    for (int[] road : roads) {
//    res += (map2.get(road[0]) + map2.get(road[1]));
//    }
//    return res;

