package ssicf.leetcode2022;


import ssicf.commons.ListNode;

public class MergeTwoSortedLists {
  public static void main(String[] args){

    ListNode a3 = new ListNode(4);
    ListNode a2 = new ListNode(2, a3);
    ListNode a = new ListNode(1, a2);

    ListNode b3 = new ListNode(4);
    ListNode b2 = new ListNode(3, b3);
    ListNode b = new ListNode(1, b2);


    MergeTwoSortedListsSolution s = new MergeTwoSortedListsSolution();
    ListNode result = s.mergeTwoLists(a, b);
    System.out.println(result);
  }
}

class MergeTwoSortedListsSolution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode temp = new ListNode();
    ListNode first = temp;
    while( list1 != null || list2 !=null){

      if(list1 == null){
        temp.next = list2;
        break;
      }else if(list2 == null){
        temp.next = list1;
        break;
      }else{
        if(list1.val < list2.val){
          temp.next = list1;
          list1 = list1.next;
        }else {
          temp.next = list2;
          list2 = list2.next;
        }
        temp = temp.next;
      }
    }
    return first.next;
  }
}
