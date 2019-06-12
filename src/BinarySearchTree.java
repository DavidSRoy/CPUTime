// How to use this class

// static BST211 myTree = new BST211();
// myTree.insert(value);
// myTree.search(value);
// myTree.delete(value);

class BinarySearchTree {
	final boolean DEBUG_MODE = false;

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	Node root;

	BinarySearchTree() {
		root = null;
	}

// search an element
	void search(int key) {
		root = searchRec(root, key);

		// for your test
		if (root != null) {
			if (DEBUG_MODE)
				System.out.println("found: " + key);
		} else {
			if (DEBUG_MODE)
				System.out.println("NOT found: " + key);
		}
	}

	Node searchRec(Node root, int key) {

		// root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// value is greater than root's key
		if (root.key > key)
			return searchRec(root.left, key);

		// value is less than root's key
		return searchRec(root.right, key);
	}

// insert
	void insert(int key) {
		root = insertRec(root, key);

		// for your test
		if (root != null) {
			if (DEBUG_MODE)
				System.out.println("saved: " + key);
		}
	}

	// A recursive function to insert a new key
	Node insertRec(Node root, int key) {

		// If the tree is empty, return a new node
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// delete
	void delete(int key) {
		root = deleteRec(root, key);

		// for your test
		if (root == null) {
			if (DEBUG_MODE)
				System.out.println("deleted:  " + key);
		}
	}

	Node deleteRec(Node root, int key) {
		// If the tree is empty
		if (root == null)
			return root;

		// Otherwise, recurive down the tree
		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		// if key is same as root's key, then This is the node to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the smallest in the right subtree
			root.key = minValue(root.right);

			// Delete
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	int minValue(Node root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}
}
