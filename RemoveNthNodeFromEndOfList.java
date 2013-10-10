/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Try to do this in one pass.
 * */


public class RemoveNthNodeFromEndOfList {

	// Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
        // consider the case with only one node in the list
		if(head.next == null && n == 1){
			return null;
		}else if(head.next == null && n == 0){
			return head;
		}
		
		ListNode current = head;
		
		while(current.next != null){ // until current is the end point
			
			ListNode tmp = current;
			for(int i = 0; i < n; i++){
				if(tmp.next != null){
					tmp = tmp.next;
				}
				else{
					head = head.next;
					return head;
				}
			}
			if(tmp.next == null){
				current.next = current.next.next;
				break;
			}else{
				current = current.next;
			}
		}
		return head;
    }
}
