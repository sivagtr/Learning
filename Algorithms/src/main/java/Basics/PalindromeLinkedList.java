package Basics;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode  head = new ListNode(1);
		ListNode mainHead = head;
		head.next = new ListNode(2);
		head = head.next;
		head.next = new ListNode(3);
		head = head.next;
		head.next = new ListNode(4);
		head = head.next;
		head.next = new ListNode(5);
		int length = 0;
		head = mainHead;
		ListNode root = head;
		ListNode midNode = head;

		while(head != null && head.next != null && head.next.next != null){
			head = head.next.next;
			midNode = midNode.next;
		}
		System.out.println("MidNode"+midNode.val);
		ListNode r = reverse(root);
//		 midNode.next = r;
		while(r != null){
			System.out.println(r.val);
			r = r.next;
		}
	}
	private static ListNode reverse(ListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;
		ListNode retHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		// retHead.next = head;
		return retHead;

	}


}
