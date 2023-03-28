package ssicf.contest.contest293;


import java.util.ArrayList;
import java.util.List;

class Tongji {
  public static void main(String[] args) {
    CountIntervals countIntervals = new CountIntervals();
    countIntervals.add(39, 44);  // 将 [2, 3] 添加到区间集合中
    countIntervals.add(13, 49); // 将 [7, 10] 添加到区间集合中
    System.out.println(countIntervals.count());
    countIntervals.add(47, 50); // 将 [7, 10] 添加到区间集合中
    System.out.println(countIntervals.count());
  }
}

class CountIntervals {
  List<Interval> list;

  public CountIntervals() {
    list = new ArrayList<>();
  }

  public void add(int left, int right) {
    for (Interval intverval : list) {
      if (right > intverval.left && left < intverval.left) {
        intverval.left = left;
        return;
      } else if (right > intverval.right && left < intverval.right) {
        intverval.right = right;
        return;
      } else if (right > intverval.right && left < intverval.left) {
        intverval.left = left;
        intverval.right = right;
        return;
      }
    }
    list.add(new Interval(left, right));
  }

  public int count() {
    int count = 0;
    for (Interval intverval : list) {
      count += intverval.getInterval();
    }
    return count;
  }
}

class Interval {
  int left;
  int right;

  Interval(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public int getInterval() {
    return right - left + 1;
  }
}
