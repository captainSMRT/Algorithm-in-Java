package Sorts;

public class yQueue {
	yNode front;
	yNode rear;
	
	public void initialise(){
		front = null;
		rear = null;
	}
	
	public boolean isEmpty(){
		return front == null;
	}
	
	public void enqueue(yNode x){
		if(isEmpty()){
			front = x;
			rear = x;
		}else{
			rear.next = x;
			rear = x;
		}
	}
	
	public yNode dequeue(){
		if(front==null){
			System.out.println("Cant dequeue an empty list");
			return null;
		}else{
			yNode temp = front;
			front = front.next;
			temp.next = null;
			return temp;
		}
	}
	
	public void PrintQueue(){
		yNode temp = front;
		while(temp!=null){
			System.out.println(temp);
			temp = temp.next;
		}
		System.out.println("end of list");
	}
}
