package DoublyLinkedList;


public class insertAtIndexKDLL {

	public static class Node{
		int val ;
		Node next;
		Node prev;
		Node(int val){
			this.val = val;
		}
	}
	
	
	public static void display(Node head) {
		Node  temp = head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp= temp.next;
		}
		System.out.println();
	}
	
	
	
	
	public static Node insertionAtK(Node random,int x) {
		Node t = new Node(x);
		t.next = random.next;
		t.prev = random;
		random.next = t;
		random.next.prev = t;
		return random;
	}
	
	
	public static void main(String[] args) {
		// 1 3 5 7 9
		Node a = new Node(1);
		Node b = new Node(3);
		Node c = new Node(5);
		Node d = new Node(7);
		Node e = new Node(9);
		
		a.prev = null;
		a.next = b;
		b.prev = a;
		b.next = c;
		c.prev = b;
		c.next = d;
		d.prev = c;
		d.next = e;
		e.prev = d;
		e.next = null;
		
		insertionAtK(c,999);   // insert at K
		display(a);
	}

}
