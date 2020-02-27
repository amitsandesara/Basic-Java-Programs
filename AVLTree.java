class AVLNode {
	int data;
	AVLNode left;
	AVLNode right;
	int height;

	AVLNode(int n) {
		left = null;
		right = null;
		height = 0;
		data = n;
	}

	AVLNode() {
		left = null;
		right = null;
		height = 0;
		data = 0;
	}

	AVLNode getLeft(AVLNode root) {
		return root.left;
	}

	AVLNode getRight(AVLNode root) {
		return root.right;
	}
}


public class AVLTree {
	private AVLNode root;

	AVLTree() {
		root = null;
	}

	boolean isEmpty() {
		return root == null;
	}

	AVLNode makeEmpty() {
		return root = null;
	}

	int height(AVLNode root) {
		return root == null ? 0 : root.height;
	}



	void insert(int n) {
		root = insert(root, n);
	}


	AVLNode insert(AVLNode root, int value) {
		if (root == null) {
			root = new AVLNode(value);
		} else if (root.data >= value) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}

		int Balance = balancingFactor(root.left, root.right);
		if (Balance == 2) {
			if (height(root.left.left) >= height(root.left.right)) {
				root = rightRotate(root);
			} else {
				root.left = leftRotate(root.left);
				root = rightRotate(root);
			}
		} else if (Balance == -2) {
			if (height(root.right.right) >= height(root.right.left)) {
				root = leftRotate(root);
			} else {
				root.right = rightRotate(root.right);
				root = leftRotate(root);
			}
		} else {
			root.height = 1 + Math.max(height(root.left), height(root.right));
		}
		return root;
	}

	AVLNode rightRotate(AVLNode root) {
		AVLNode tempRoot = root.left;
		root.left = root.left.right;
		tempRoot.right = root;
		root.height = 1 + Math.max(height(root.left), height(root.right));
		tempRoot.height = 1 + Math.max(height(tempRoot.left), height(tempRoot.right));
		return tempRoot;
	}

	AVLNode leftRotate(AVLNode root) {
		AVLNode tempRoot = root.right;
		root.right = root.right.left;
		tempRoot.left = root;
		root.height = 1 + Math.max(height(root.left), height(root.right));
		tempRoot.height = 1 + Math.max(height(tempRoot.left), height(tempRoot.right));
		return tempRoot;
	}

	int balancingFactor(AVLNode left, AVLNode right) {
		return height(left) - height(right);
	}

	AVLNode balance(AVLNode root) {
		root.height = 1 + Math.max(height(root.left), height(root.right));
		return root;
	}

	AVLNode delete(int value) {
		return delete(root, value);
	}

	AVLNode delete(AVLNode root, int value) {

		if (root == null)
			return root;

		else if (root.data == value) {
			// root has no children
			if (root.left == null && root.right == null)
				return null;
			// root has 1 children
			else if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				// root has 2 children
				int minElement = smallestNode(root.right);
				root.data = minElement;
				root.right = delete(root.right, minElement);
				root.left = root.left;
				return balance(root);
			}
		} else if (root.data >= value) {
			root.left = delete(root.left, value);
			return balance(root);
		} else {
			root.right = delete(root.right, value);
			return balance(root);
		}

		// int balance = balancingFactor(root.left, root.right);
	}

	int smallestNode(AVLNode root) {
		if (root.left == null) {
			System.out.println("\nSmallest element:- " + root.data);
			return root.data;
		}
		return smallestNode(root.left);

	}

	void printInOrder(AVLNode root) {
		if (!isEmpty()) {

			if (root.left != null)
				printInOrder(root.left);
			System.out.print(root.data + " ");
			if (root.right != null)
				printInOrder(root.right);
		}
	}

	void printInOrder() {
		printInOrder(root);
	}

	void search(int value) {
		boolean found = search(root, value);
		if (found)
			System.out.println("Element " + value + " found in tree");
		else
			System.out.println("Element " + value + " not found in tree");
	}

	boolean search(AVLNode root, int value) {

		if (root == null)
			return false;
		else if (root.data == value)
			return true;
		else if (root.data >= value)
			return search(root.left, value);
		else
			return search(root.right, value);
	}

	public static void main(String args[]) {
		AVLTree tree = new AVLTree();
		int[] treeElements = {15, 12, 18, 25, 6, 11, 21, 35, 2, 48};
		for (int i : treeElements) {
			tree.insert(i);
		}
		System.out.println("Root of the tree: " + tree.root.data);
		System.out.println("The tree elements inOrder are:- ");
		tree.printInOrder();
		System.out.println();
		tree.search(34);
		tree.search(48);
		System.out.println("AVLTree's height:- " + tree.root.height);

		tree.delete(25);
		tree.printInOrder();
		System.out.println("\nTree's root: " + tree.root.data);
		tree.delete(6);
		tree.printInOrder();
		System.out.println("\nTree's root: " + tree.root.data);
		tree.delete(15);
		tree.printInOrder();
		System.out.println("\nTree's root: " + tree.root.data);
		System.out.println("Tree.right root:- " + tree.root.right.data);
		System.out.println("Tree.right.right root:- " + tree.root.right.right.data);


	}
}
