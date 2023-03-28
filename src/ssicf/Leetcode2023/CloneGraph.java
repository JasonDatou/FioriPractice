package ssicf.Leetcode2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
  public static void main(String[] args) {
    CloneGraphSolution s = new CloneGraphSolution();
    Node node1 = new Node(1);
//    Node node2 = new Node(2);
//    Node node3 = new Node(3);
//    Node node4 = new Node(4);
//    node1.neighbors = List.of(node2, node4);
//    node2.neighbors = List.of(node1, node3);
//    node3.neighbors = List.of(node2, node4);
//    node4.neighbors = List.of(node1, node3);
    Node result = s.cloneGraph(node1);
    System.out.println(result);
  }
}

class CloneGraphSolution {
  HashMap<Integer, Node> cloned = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }

    // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
    if (cloned.containsKey(node.val)) {
      return cloned.get(node.val);
    }

    // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
    Node cloneNode = new Node(node.val, new ArrayList());
    // 哈希表存储
    cloned.put(node.val, cloneNode);

    // 遍历该节点的邻居并更新克隆节点的邻居列表
    for (Node neighbor : node.neighbors) {
      cloneNode.neighbors.add(cloneGraph(neighbor));
    }
    return cloneNode;
  }
}


class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}