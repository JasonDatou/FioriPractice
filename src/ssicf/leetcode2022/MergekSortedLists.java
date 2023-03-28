package ssicf.leetcode2022;

import ssicf.commons.ListNode;

public class MergekSortedLists {
  public static void main(String[] args){
    ListNode a3 = new ListNode(4);
    ListNode a2 = new ListNode(2, a3);
    ListNode a = new ListNode(1, a2);

    ListNode b3 = new ListNode(4);
    ListNode b2 = new ListNode(3, b3);
    ListNode b = new ListNode(1, b2);

    ListNode []lists =new ListNode[]{a, b};

    MergekSortedListsSolution s = new MergekSortedListsSolution();
    ListNode result = s.mergeKLists(lists);
    System.out.println(result);
  }
}

class MergekSortedListsSolution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode res = new ListNode();
    ListNode pre = res;
    merge(res, lists);
    return pre.next;
  }

  private void merge(ListNode res, ListNode[] listNodes){
    ListNode minListNode = new ListNode(Integer.MAX_VALUE);
    int indexMin = -1;
    for(int i=0; i<listNodes.length; i++){
      if(listNodes[i] != null){
        if(listNodes[i].val < minListNode.val){
          indexMin = i;
          minListNode = listNodes[i];
        }
      }
    }
    if(indexMin != -1){
      res.next = new ListNode(minListNode.val);
      res = res.next;
      listNodes[indexMin] = listNodes[indexMin].next;
      merge(res, listNodes);
    }
  }

}
