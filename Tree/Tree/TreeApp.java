package Tree;

public class TreeApp {
	public static void main(String[] args){
		TreeNode node001 = new TreeNode("Nagato", 33);
		TreeNode node002 = new TreeNode("Konan", 22);
		TreeNode node003 = new TreeNode("Pein", 94);
		TreeNode node004 = new TreeNode("Itachi", 43);
		TreeNode node005 = new TreeNode("Kisame", 29);
		TreeNode node006 = new TreeNode("Sasori", 46);
		TreeNode node007 = new TreeNode("Deidara", 55);
		TreeNode node008 = new TreeNode("Hidan", 22);
		TreeNode node009 = new TreeNode("Kakuzu", 21);
		TreeNode node010 = new TreeNode("Zetsu", 43);
		TreeNode node011 = new TreeNode("Orochimaru", 22);
		TreeNode node012 = new TreeNode("Obito", 53);
		TreeNode node013 = new TreeNode("Sasuke", 23);
		TreeNode node014 = new TreeNode("Karin", 21);
		TreeNode node015 = new TreeNode("Suigetsu", 52);
		
		BinaryTree tree = new BinaryTree();
		tree.initialise();
		
		tree.create(node007);
		tree.combine(node007, node001, node004);
		
		tree.combine(node001, node002, node003);
		
		tree.combine(node004, node005, node006);
		
		tree.combine(node002, node008, node009);
		tree.combine(node003, node010, node011);
		tree.combine(node005, node012, node013);
		tree.combine(node006, node014, node015);
		
		
		int c = tree.TabulateRow();
		tree.traverse();
		
		for(int i=0;i<tree.arrayAll.size();i++){
			for(int x=1;x<Math.pow(2,c-i-1);x++){
				System.out.print("\t");
			}
			
			for(int j=0;j<tree.arrayAll.get(i).size();j++){
				System.out.print(tree.arrayAll.get(i).get(j));
				
				for(int x=1;x<Math.pow(2,c-i);x++){
					System.out.print("\t");
				}
				
			}
			System.out.println();
		}
		
	
	}
}
