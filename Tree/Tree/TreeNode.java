package Tree;

public class TreeNode {
	public String name;
	public int age;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public TreeNode(String name, int age, TreeNode left, TreeNode right){
		this.name = name;
		this.age = age;
		this.left = left;
		this.right = right;
	}
	
	public String toString(){
		return name + " | " + age;
	}
}
