/*
	You are given two linked lists representing two non-negative numbers. 
	The digits are stored in reverse order and each of their nodes contain
	a single digit. Add the two numbers and return it as a linked list.

			Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
			Output: 7 -> 0 -> 8
	
	*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
		if(l1 == null && l2 == null) return null;
		else if(l1 == null || l2 != null) return l2;
		else if(l2 == null || l1 != null) return l1;
		
		int sum = l1.val + l2.val; 
		ListNode answer = new ListNode(0);
		
		if(sum >= 10){
			answer.val = sum%10;
			l1.next.val = l1.next.val + 1;
			answer.next = addTwoNumbers(l1.next, l2.next);
		}else{
			answer.val = sum;
			answer.next = addTwoNumbers(l1.next, l2.next);
		}
		return answer;
 	}
