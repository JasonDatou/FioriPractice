package ssicf.leetcode2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import ssicf.commons.TreeNode;

public class Codec {
  public static void main(String[] args){
    CodecSolution s = new CodecSolution();
    TreeNode root = new TreeNode("1,2,3,null,null,4,5");
    String result = s.serialize(root);
    TreeNode rootback = s.deserialize(result);
    System.out.println(result);
    System.out.println(rootback.toString());
  }
}

class CodecSolution {

  public String serialize(TreeNode root) {
    return rserialize(root, "");
  }


  public TreeNode deserialize(String data) {
    String[] dataArray = data.split(",");
    List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
    return rdeserialize(dataList);
  }

  private String rserialize(TreeNode root, String str) {
    List<String> test = new ArrayList<>(new HashSet<String>(Collections.singleton("123")));


    if (root == null) {
      str += "None,";
    } else {
      str += str.valueOf(root.val) + ",";
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }
    return str;
  }

  public TreeNode rdeserialize(List<String> dataList) {
    if (dataList.get(0).equals("None")) {
      dataList.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
    dataList.remove(0);
    root.left = rdeserialize(dataList);
    root.right = rdeserialize(dataList);

    return root;
  }
}
