// Binary Search Tree
package com.company;

public class BST {
    public static void main(String[] args) {
        NodeBST root = new NodeBST(10);
        root.leftChild = new NodeBST(5);
        root.rightChild = new NodeBST(15);
        System.out.println("Initial Binary Search Tree");
        display(root);
        System.out.println();
        insertRecursive(root, 3);
        System.out.println("Binary Search Tree after inserting 3");
        display(root);
        System.out.println();
        System.out.println("Search for 3");
        System.out.println(searchRecursive(root, 3));
        delete(root, 3);
        System.out.println("Binary Search Tree after deleting 3");
        display(root);
        System.out.println();
    }

    // Recursive Search
    public static boolean searchRecursive(NodeBST root, int key) {
        if (root == null) {
            return false;
        }else if (key == root.key) {
            return true;
        }else if (key < root.key) {
            return searchRecursive(root.leftChild, key);
        }else {
            return searchRecursive(root.rightChild, key);
        }
    }

    // Recursive Insert
    public static NodeBST insertRecursive(NodeBST root, int key) {
        if (root == null) {
            return new NodeBST(key);
        }
        if (key < root.key) {
            root.leftChild = insertRecursive(root.leftChild, key);
        }else if (key > root.key) {
            root.rightChild = insertRecursive(root.rightChild, key);
        }
        return root;
    }

    // Recursive delete
    public static NodeBST delete(NodeBST root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.leftChild = delete(root.leftChild, key);
        }else if (key > root.key) {
            root.rightChild = delete(root.rightChild, key);
        }else {
            if (root.leftChild == null) {
                return root.rightChild;
            }else if (root.rightChild == null) {
                return root.leftChild;
            }else {
                NodeBST succ = getSucc(root);
                root.key = succ.key;
                // Delete the inorder successor
                root.rightChild = delete(root.rightChild, succ.key);
            }
        }
        return root;
    }

    // Get the closest greater successor using inorder traversal
    public static NodeBST getSucc(NodeBST root) {
        NodeBST temp = root.rightChild;
        while (temp != null && temp.leftChild != null) {
            temp = temp.leftChild;
        }
        return temp;
    }

    // Iterative Search
    public static boolean searchIterative(NodeBST root, int key) {
        while (root != null) {
            if (key == root.key){
                return true;
            }else if (key < root.key) {
                root = root.leftChild;
            }else {
                root = root.rightChild;
            }
        }
        return false;
    }

    // Iterative Insert
    public static NodeBST insertIterative(NodeBST root, int key) {
        NodeBST temp = new NodeBST(key);
        NodeBST parent = null;
        NodeBST curr = root;

        while (curr != null) {
            parent = curr;
            if (key < curr.key) {
                curr = curr.leftChild;
            }else if (key > curr.key) {
                curr = curr.rightChild;
            }
            return root;
        }

        if (parent == null) {
            return temp;
        }
        if (key < parent.key) {
            parent.leftChild = temp;
        }else if (key > parent.key) {
            parent.rightChild = temp;
        }
        return root;
    }

    // Display using inorder traversal
    public static void display(NodeBST root) {
        if (root != null) {
            display(root.leftChild);
            System.out.print(root.key + " ");
            display(root.rightChild);
        }
    }

    // Greatest value that is smaller than or equal to given value
    public static NodeBST floor(NodeBST root, int key) {
        NodeBST temp = null;
        while (root != null) {
            if (key == root.key) {
                return root;
            }else if (key < root.key) {
                root = root.leftChild;
            }else {
                temp = root;
                root = root.rightChild;
            }
        }
        return temp;
    }

    // Smallest value that is greater than or equal to given value
    public static NodeBST ceiling(NodeBST root, int key) {
        NodeBST temp = null;
        while (root != null) {
            if (key == root.key) {
                return root;
            }else if (key > root.key) {
                root = root.rightChild;
            }else {
                temp = root;
                root = root.leftChild;
            }
        }
        return temp;
    }


}

class NodeBST {
    int key;
    NodeBST leftChild;
    NodeBST rightChild;

    public NodeBST(int key) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }
}


// Recursive Search
// Time Complexity = O(H)
// Space Complexity = O(H)

// Iterative Search
// Time Complexity = O(H)
// Space Complexity = O(1)

// Recursive Insert
// Time Complexity = O(H)
// Space Complexity = O(H)

// Iterative Insert
// Time Complexity = O(H)
// Space Complexity = O(1)


// Deletion
// Time Complexity = O(H)
// Space Complexity = O(H)

// Floor - Greatest value that is smaller than or equal to given value
// Time Complexity = O(H)
// Space Complexity = O(1)

// Ceiling - Smallest value that is greater than or equal to given value
// Time Complexity = O(H)
// Space Complexity = O(1)
