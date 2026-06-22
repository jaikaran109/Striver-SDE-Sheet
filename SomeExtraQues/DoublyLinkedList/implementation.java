package DoublyLinkedList;

public class implementation {
		
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
	
	
	public static void displayrev(Node tail) {
		Node  temp = tail;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp= temp.prev;
		}
		System.out.println();
	}
	
	
	public static void displayFromRandom(Node random) { // display the whole DLL from a Random Node
		Node temp = random;
		while(random.prev != null) {
			random = random.prev;
		}
		
		while(random != null) {
			System.out.print(random.val + " ");
			random = random.next;
		}
		
		System.out.println();
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
		display(a);
		displayrev(e);
		displayFromRandom(c);

	}

}
