package Sorts;

public class dMergeSort {
	
	public static void main(String[] args){
		yNode node001 = new yNode(1);
		yNode node002 = new yNode(3);
		yNode node003 = new yNode(5);
		yNode node004 = new yNode(7);
		yNode node005 = new yNode(9);
		
		node002.next = node001;
		node003.next = node002;
		node004.next = node003;
		node005.next = node004;
		
		yNode node006 = new yNode(2);
		yNode node007 = new yNode(4);
		yNode node008 = new yNode(6);
		yNode node009 = new yNode(8);
		yNode node010 = new yNode(10);
		node007.next = node006;
		node008.next = node007;
		node009.next = node008;
		node010.next = node009;
		
		

		
		yNode combi = new yNode();
		
		mergeSort(node005, node010, combi);
		combi.print();
	
	}
	
	public static void mergeSort(yQueue a, yQueue b, yQueue c){
		while(!(a.isEmpty()||b.isEmpty())){

			if(a.front.num < b.front.num){
				System.out.println("Adding to Queue: "+ a.front);
				c.enqueue(a.dequeue());
			}else{
				System.out.println("Adding to Queue: "+ b.front);
				c.enqueue(b.dequeue());
			}
			
			if(a.isEmpty()){
				System.out.println("Adding to Queue: Remaining of b");
				c.enqueue(b.front);
			}
			if(b.isEmpty()){
				System.out.println("Adding to Queue: Remaining of a");
				c.enqueue(a.front);
			}
		}
	}
	
	public static void mergeSort(yNode a, yNode b, yNode c){
		if(a!=null && b!=null){
			if(a.num < b.num){
				c = a;
				a = a.next;
			}else{
				c = b;
				b = b.next;
			}
			
			yNode s = c;
		
			while(a!=null && b!=null){
				if(a.num<=b.num){
					s.next =  a;
					s = a;
					a = a.next;
				}else{
					s.next =  b;
					s = b;
					b = b.next;
				}
			}
			
			if(a!=null){
				s.next = b;
			}else{
				s.next = a;
			}
			
			
		}
	}
}


/*
 
 yQueue Queue = new yQueue();
		Queue.enqueue(new yNode(3));
		Queue.enqueue(new yNode(4));
		Queue.enqueue(new yNode(5));
		Queue.enqueue(new yNode(6));
		Queue.enqueue(new yNode(16));
		
		yQueue Queue2 = new yQueue();
		Queue2.enqueue(new yNode(2));
		Queue2.enqueue(new yNode(9));
		Queue2.enqueue(new yNode(10));
		Queue2.enqueue(new yNode(11));
		Queue2.enqueue(new yNode(12));
		
		yQueue Queue3 = new yQueue();
		
		mergeSort(Queue, Queue2, Queue3);
		Queue3.PrintQueue();
 
 
 
 
 
 */
