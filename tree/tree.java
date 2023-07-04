package com.mycompany.tree;

public class tree {

	private Node root;
	
	public void insert(int key, Object value) {
		this.root = this.insert(this.root, key, value);
	}
	
	private Node insert(Node root, int key, Object value) {
		if(root == null) {
			Node node = new Node();
			node.setKey(key);
			node.setValue(value);
			return node;
		} else {
			if(key < root.getKey()) {
				root.setLeft(this.insert(root.getLeft(), key, value));
			} else if(key > root.getKey()) {
				root.setRight(this.insert(root.getRight(), key, value));
			}
			return root;
		}
	}
	
	public Object get(int key) {
		return this.get(this.root, key);
	}
	
	private Object get(Node root, int key) {
		if(root != null) {
			if(key < root.getKey()) {
				return this.get(root.getLeft(), key);
			} else if(key > root.getKey()) {
				return this.get(root.getRight(), key);
			} else {
				return root.getValue();
			}			
		}
		return null;
	}
	
	private String print(Node root, int lvl) {
		String out = "";
		for(int i=0; i<lvl; i++) {
			out += "\t";
		}
		out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
		out += "\n";
		out += (root.getLeft() != null ? print(root.getLeft(), lvl + 1) : "");
		out += (root.getRight() != null ? print(root.getRight(), lvl + 1) : "");
		return out;
	}
	
	@Override
	public String toString() {
		return this.print(this.root, 0);
	}
	
        public void remove(int key) {
            this.root = removeNode(this.root, key);
        }

        private Node removeNode(Node root, int key) {
            if (root == null) {
                return null;
            }

            if (key < root.getKey()) {
                root.setLeft(removeNode(root.getLeft(), key));
            } else if (key > root.getKey()) {
                root.setRight(removeNode(root.getRight(), key));
            } else {

               
                if (root.getLeft() == null && root.getRight() == null) {
                    return null;
                }
                
                else if (root.getLeft() == null) {
                    return root.getRight();
                } else if (root.getRight() == null) {
                    return root.getLeft();
                }
                
                else {
                  
                    Node successor = findMin(root.getRight());
                    root.setKey(successor.getKey());
                    root.setValue(successor.getValue());
                    root.setRight(removeNode(root.getRight(), successor.getKey()));
                }
            }

            return root;
        }

        private Node findMin(Node root) {
            while (root.getLeft() != null) {
                root = root.getLeft();
            }
            return root;
        }
           
        public void postOrder() {
		postOrderTraversal(this.root);
	}

	private void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.println(root.getKey() + ": " + root.getValue());
		}
	}

	public void preOrder() {
		preOrderTraversal(this.root);
	}

	private void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.println(root.getKey() + ": " + root.getValue());
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}

	public void inOrder() {
		inOrderTraversal(this.root);
	}

	private void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.getLeft());
			System.out.println(root.getKey() + ": " + root.getValue());
			inOrderTraversal(root.getRight());
		}
	}
        
	public static void main(String[] args) {
		tree t = new tree();
		
		t.insert(30, "30");
                t.insert(10, "530");
                t.insert(20, "5340");
                t.insert(60, "250");
                t.insert(550, "350");
		t.insert(530, "505");
                t.insert(500, "320");
                System.out.println("Print Keys 30 e 500");
                System.out.println(t.get(30) + ", " + t.get(500));
                System.out.println("Remove key 500");
		t.remove(500);
                System.out.println("Print Keys 30 e 500 após remoção");
		System.out.println(t.get(30) + ", " + t.get(500));
                
                System.out.println("In-Order Traversal:");
		t.inOrder();
		System.out.println("Pre-Order Traversal:");
		t.preOrder();
		System.out.println("Post-Order Traversal:");
		t.postOrder();
	}
	
}
