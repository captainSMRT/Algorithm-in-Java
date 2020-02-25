package Tree;

import java.util.ArrayList;

public class BinaryTree {
	TreeNode root;

	ArrayList<ArrayList<TreeNode>> arrayAll = new ArrayList<ArrayList<TreeNode>>();
	
	
	int counter = 0;
	public void initialise(){
		root = null;	
	}
	
	public boolean empty(){
		return root==null;
	}
	
	public void create(TreeNode data){
		root = data;
		
	}
	
	public void combine(TreeNode data, TreeNode left, TreeNode right){
		data.left = left;
		data.right = right;
	}
	
	public void traverse(){
		if(!empty()){
			arrayAll.add(new ArrayList<TreeNode>());
			traverse(root, arrayAll, 0);
		}else{
			System.out.println("Cant traverse an empty tree");
		}
	}
	
	public int TabulateRow(){
		int counter = 0;
		TreeNode temp = root;
		while(root!=null){
			root = root.left;
			arrayAll.add(new ArrayList<TreeNode>());
			counter++;
		}
		root = temp;
		return counter;
	}
	
	public void traverse(TreeNode root, ArrayList<ArrayList<TreeNode>> array, int counterType){
		if(root!=null){
			array.get(counterType).add(root); 
			traverse(root.left, arrayAll, counterType + 1);
			traverse(root.right, arrayAll, counterType + 1);
			
		}
	}
}
