package week11;

public class BinaryTreeTest {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(8);

		tree.insert(4);tree.insert(12);
		tree.insert(2);tree.insert(3);
		tree.insert(5);tree.insert(9);
		tree.insert(7);tree.insert(14);
		tree.insert(10);


		tree.printAll();

		tree.search(8);
		tree.search(20);
	}
}

class BinaryTree {

	class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;


	public BinaryTree(int top) {
		this.root = new Node(top);
	}

	public void insert(int value) {
		this.root = insert(root, value);
	}

	public Node insert(Node node, int value) {
		if (node == null)
			node = new Node(value);

		if (value < node.value)
			node.left = insert(node.left, value);

		else if (value > node.value)
			node.right = insert(node.right, value);

		return node;

	}


	public void printAll() {
	System.out.println("PreOder: ");
		PreOrder(root);
		// 8 4 2 3 5 7 12 9 10 14
		
		System.out.println("\nInOder: ");
		InOrder(root);		
		//  2 3 4 5 7 8 9 10 12 14
		
		System.out.println("\nPostOder: ");
		PostOrder(root);	
		//  3 2 7 5 4 10 9 14 12 8
		
		System.out.println("\n");
	}

	public void InOrder(Node node) {
		if (node != null) {
			InOrder(node.left);
			System.out.print(" " + node.value);
			InOrder(node.right);
		}
	}

	public void PreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			PreOrder(node.left);
			PreOrder(node.right);
		}
	}

	public void PostOrder(Node node) {
		if (node != null) {
			PostOrder(node.left);
			PostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}


	public void search(int i){
       Node result = search(root, i);
       if ( result != null)
    	   System.out.println(result.value + " is on the tree!");
       else
    	   System.out.println("Value " + i + " is not found!");
      }

	public Node search(Node node, int value) {
		while (node != null) {
			if (value < node.value)
				node = node.left;
			else if (value > node.value)
				node = node.right;
			else if (value == node.value)
				return node;
		}
		return node;
	}
}

