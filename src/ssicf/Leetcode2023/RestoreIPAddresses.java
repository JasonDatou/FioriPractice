package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIPAddresses {
  public static void main(String[] args) {
    RestoreIPAddressesSolution s = new RestoreIPAddressesSolution();
    List<String> result = s.restoreIpAddresses("25525511135");
    System.out.println(result);
  }
}

class RestoreIPAddressesSolution {
  List<String> temp = new ArrayList<>();
  List<List<String>> result = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    backtrack(s, 0);
    return result.stream().map(this::convertIp).collect(Collectors.toList());
  }

  private String convertIp(List<String> ip) {
    StringBuilder sb = new StringBuilder();
    sb.append(ip.get(0));
    for (int i = 1; i < ip.size(); i++) {
      sb.append('.').append(ip.get(i));
    }
    return sb.toString();
  }

  private void backtrack(String s, int startIndex) {
    if (temp.size() == 4) {
      if (startIndex == s.length())
        result.add(new ArrayList<>(temp));
      return;
    }
    for (int i = 1; i <= 3; i++) {
      if (startIndex + i <= s.length() && ((s.charAt(startIndex) != '0' && i > 1) || i == 1)
          && Integer.parseInt(s.substring(startIndex, startIndex + i)) <= 255) {
        temp.add(s.substring(startIndex, startIndex + i));
        backtrack(s, startIndex + i);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
