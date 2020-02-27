import java.util.*;

class BSTNode {
	private int val;
	private BSTNode left;
	private BSTNode right;

	public BSTNode() {
		setLeft(null);
		setRight(null);
		val = 0;
	}

	public BSTNode(int n) {
		setLeft(null);
		setRight(null);
		val = n;
	}

	public BSTNode(BSTNode left, BSTNode right, int v) {
		this.setLeft(left);
		this.right = right;
		val = v;
	}

	public void setLeft(BSTNode n) {
		this.left = n;
	}

	public BSTNode getLeft() {
		return this.left;
	}

	public void setRight(BSTNode n) {
		right = n;
	}

	public BSTNode getRight() {
		return this.right;
	}

	public void setData(int n) {
		val = n;
	}

	public int getData() {
		return this.val;
	}

}


public class BST {
	private BSTNode root;
	protected int count;

	BST() {
		root = null;
	}

	public int getRoot(BSTNode n) {
		return n.getData();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private BSTNode insert(BSTNode node, int data) {
		if (node == null)
			node = new BSTNode(data);
		else {
			if (data <= node.getData())
				node.setLeft(insert(node.getLeft(), data));
			else
				node.setRight(insert(node.getRight(), data));
		}
		return node;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(BSTNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Binary Search Tree\n");

		BST bst = new BST();
		bst.insert(24);
		bst.insert(32);
		bst.insert(1);
		bst.insert(56);
		bst.insert(65);
		bst.insert(32);
		bst.insert(23);
		bst.insert(66);
		bst.insert(7);

		System.out.println("InOrder Traversal:-");
		bst.inorder();
		System.out.println("\nPreOrder Traversal:-");
		bst.preorder();
		scan.close();
	}
}
