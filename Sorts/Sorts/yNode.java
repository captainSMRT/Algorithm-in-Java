package Sorts;

public class yNode {
	public int num;
	public yNode next;
	
	public yNode(){
		this.num = 0;
	}
	
	public yNode(int num){
		this.num = num;
	}
	
	public String toString(){
		return num +" ";
	}
	
	public void print(){
		//while(next!=null){
			System.out.print(num + " ");
			//if(next==null){
				//System.out.print(next.num);
			//}
		//}
	}
}
