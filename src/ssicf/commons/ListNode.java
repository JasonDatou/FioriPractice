package ssicf.commons;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int[] val) {
    ListNode pre = null;
    for (int i = 0; i < val.length; i++) {
      if (i == 0) {
        this.val = val[0];
        pre = this;
      } else {
        ListNode next = new ListNode(val[i]);
        pre.next = next;
        pre = next;
      }
    }
  }

  public ListNode(String valsr) {
    String[] strs = valsr.split(",");
    int[] val = new int[strs.length];
    for (int i = 0; i < strs.length; i++) {
      val[i] = Integer.parseInt(strs[i]);
    }
    ListNode pre = null;
    for (int i = 0; i < val.length; i++) {
      if (i == 0) {
        this.val = val[0];
        pre = this;
      } else {
        ListNode next = new ListNode(val[i]);
        pre.next = next;
        pre = next;
      }
    }
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public String toString() {
    ListNode temp = this;
    StringBuilder sb = new StringBuilder();
    while (temp != null) {
      sb.append(temp.val).append(",");
      temp = temp.next;
    }
    return sb.toString();
  }
}
