/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * */


import java.util.ArrayList;
import java.util.List;

public class MergeKSortedList {
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode start = new ListNode(0);
		ListNode head = new ListNode(0);
		if(lists.size() == 0) return null;
		if(lists.size() == 1) return lists.get(0);
		if(lists.size() == 2){
			ListNode One = lists.get(0);
			ListNode Two = lists.get(1);
			while(One != null && Two != null){
				// sorted in increasing order
				if(One.val < Two.val){
					start.next = One;
					if(head.next == null){
						head = start;
					}
					start = start.next;
					One = One.next;
				}else{
					start.next = Two;
					if(head.next == null){
						head = start;
					}
					start = start.next;
					Two = Two.next;
				}
			}
			if(One == null){
				start.next = Two;
			}else{
				start.next = One;
			}
			if(head.next == null){
				head = start;
			}
		}
		if(lists.size() > 2){
			ArrayList<ListNode> subList = new ArrayList<ListNode>();
			subList = new ArrayList<ListNode>(lists.subList(1, lists.size()));
			ArrayList<ListNode> newList = new ArrayList<ListNode>();
			newList.add(lists.get(0));
			newList.add(mergeKLists(subList));
			head.next = mergeKLists(newList);
		}
		return head.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ListNode> tmp = new ArrayList<ListNode>();
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(-1);
		tmp.add(a);
		tmp.add(null);
		tmp.add(b);
		ListNode ans = mergeKLists(tmp);

	}

}
