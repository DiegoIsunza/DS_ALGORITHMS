package Fundamentals;

/*
    Binary Search Tree
         50
       /   \
      25    75
     /  \     \
    15  30     85
 */

class Node {

    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }
}


public class BST {
    Node root; // Every tree must have a root node

    public void addNode(int key, String name) {

        Node newNode = new Node(key,name);

        if(root == null) { // check if it's the first value
            root = newNode;
        } else {

            Node currentNode = root; // we are going to start from the root
            Node parent;

            while(true) {
                parent = currentNode;

                if(key < currentNode.key) { // check if the new node should go in the left
                    currentNode = currentNode.leftChild;

                    if(currentNode == null) { // if the left child has no children
                        parent.leftChild = newNode;
                        return;
                    }
                } else { // node goes in the right
                    currentNode = currentNode.rightChild;

                    if(currentNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    // left, root, right
    public void inOrder(Node currentNode) {

        if(currentNode != null) {
            inOrder(currentNode.leftChild);
            System.out.println(currentNode);
            inOrder(currentNode.rightChild);
        }
    }

    // root, left, right
    public void preOrder(Node currentNode) {

        if(currentNode != null) {
            System.out.println(currentNode); //prints root
            preOrder(currentNode.leftChild);
            preOrder(currentNode.rightChild);
        }
    }

    // left, right, root
    public void postOrder(Node currentNode) {

        if(currentNode != null) {
            preOrder(currentNode.leftChild);
            preOrder(currentNode.rightChild);
            System.out.println(currentNode);
        }
    }

    public Node findNode(int key) {
        Node currentNode = root;

        while(currentNode.key != key) { // while key hasn't been found

            if(key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }

            if(currentNode == null) {
                return null;
            }
        }

        return currentNode;
    }

    public boolean remove(int key) {

        Node currentNode = root; // Focus node to take decisions
        Node parent = root;

        boolean isItALeftChild = true; // flag to indicate the position of node

        while(currentNode.key != key) {
            parent = currentNode;

            if(key < currentNode.key) {
                isItALeftChild = true;
                currentNode = currentNode.leftChild;
            } else {
                isItALeftChild = false;
                currentNode = currentNode.rightChild;
            }

            if(currentNode == null) { // doesn't exist
                return false;
            }
        }

        if(currentNode.leftChild == null && currentNode.rightChild == null) { // if there's no children (leaf format)

            if(currentNode == root) { // if it's the root
                root = null; //delete root
            } else if (isItALeftChild) {
                parent.leftChild = null; //delete parent.left
            } else{ //right child
                parent.rightChild = null; //delete parent.right
            }
        } else if(currentNode.rightChild == null) { // if there is not right child
            if(currentNode ==root){
                root =currentNode.leftChild;
            } else if(isItALeftChild) {
                parent.leftChild = currentNode.leftChild;
            } else {
                parent.rightChild = currentNode.leftChild;
            }
        } else if (currentNode.leftChild == null ) { // if there is no left child
            if(currentNode == root) {
                root = currentNode.rightChild;
            } else if(isItALeftChild) {
                parent.leftChild = currentNode.rightChild;
            } else{
                parent.rightChild = currentNode.leftChild;
            }
        }

        else{ // if two children are involved
            Node replacement =  getReplacementNode(currentNode);

            if(currentNode == root)
                root = replacement;

            else if(isItALeftChild)
                parent.leftChild = replacement;

            else
                parent.rightChild = replacement;

            replacement.leftChild = currentNode.leftChild;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node currentNode = replacedNode.rightChild; //removing right child

        while(currentNode != null) {

            replacementParent = replacement;

            replacement = currentNode;

            currentNode = currentNode.leftChild; // removing left child
        }

        if(replacement != replacedNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    public static void main(String[] args) {
        BST bt = new BST();

        bt.addNode(50, "Boss");
        bt.addNode(25, "Vice Pres");
        bt.addNode(15, "Office Manager");
        bt.addNode(30, "Secretary");
        bt.addNode(75, "Sales Manager");
        bt.addNode(85, "Salesman 1");

        System.out.println("----- In-Order Traversal -----");
        bt.inOrder(bt.root);

//        System.out.println("----- Pre-Order Traversal -----");
//        bt.preOrder(bt.root);
//
//        System.out.println("----- Post-Order Traversal -----");
//        bt.postOrder(bt.root);

        System.out.println("Search for 90");
        System.out.println(bt.findNode(90));

        System.out.println("Remove key 25");

        bt.remove(25);

        bt.inOrder(bt.root);
    }
}
