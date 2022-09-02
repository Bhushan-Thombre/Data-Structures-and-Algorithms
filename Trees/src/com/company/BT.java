// Binary Tree

// The representation of Binary tree with n nodes, has n - 1 edges

// The height of the binary tree is defined as the number of nodes between root and leaf nodes on the longest path.
// The level of a node in the binary tree is the number of nodes between root and the given node. The level of root node is zero.
// Number of edges associated with a node is called degree of the node. Number of edges coming towards the node is called indegree
// while number of edges going away from a node is called outdegree. The sum of indegree and outdegree is degree of the node.
// Root nodes have a indegree of zero while leaf nodes have outdegree of zero.

// If a Binary Tree has n nodes than:
// H(max) = n
// H(min) = log(n + 1)

// If height of a Binary tree is h than:
// N(max) = 2 ^ h - 1
// N(min) = h

// The maximum number of nodes at level l of a Binary Tree are 2 ^ l

package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BT {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.leftChild = new Node(20);
        root.rightChild = new Node(30);
        root.leftChild.leftChild = new Node(40);

        System.out.println("Recursive Inorder Traversal");
        inOrderRecursive(root);
        System.out.println();
        System.out.println("Recursive Preorder Traversal");
        preOrderRecursive(root);
        System.out.println();
        System.out.println("Recursive Postorder Traversal");
        postOrderRecursive(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        levelOrder(root);
        System.out.println();
        System.out.println("Height of the Binary tree");
        System.out.println(height(root));
        System.out.println("Size of the Binary tree");
        System.out.println(size(root));
        System.out.println("Maximum in a Binary tree");
        System.out.println(max(root));
        System.out.println("Iterative Inorder Traversal");
        inOrderIterative(root);
        System.out.println();
        System.out.println("Iterative Preorder Traversal");
        preOrderIterative(root);
    }

    // Recursive Inorder Traversal
    public static void inOrderRecursive(Node root) {
        if (root != null) {
            inOrderRecursive(root.leftChild);
            System.out.print(root.key + " ");
            inOrderRecursive(root.rightChild);
        }
    }

    // Recursive Preorder Traversal
    public static void preOrderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRecursive(root.leftChild);
            preOrderRecursive(root.rightChild);
        }
    }

    // Recursive Postorder Traversal
    public static void postOrderRecursive(Node root) {
        if (root != null) {
            postOrderRecursive(root.leftChild);
            postOrderRecursive(root.rightChild);
            System.out.print(root.key + " ");
        }
    }

    // Iterative Inorder Traversal
    public static void inOrderIterative(Node root) {
        Stack<Node> s = new Stack<>();
        Node temp = root;
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {
                s.push(temp);
                temp = temp.leftChild;
            }
            temp = s.pop();
            System.out.print(temp.key + " ");
            temp = temp.rightChild;
        }
    }

    // Iterative Preorder Traversal
    public static void preOrderIterative(Node root){


        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (s.isEmpty() == false) {
            Node temp = s.pop();
            System.out.print(temp.key + " ");
            if (temp.rightChild != null) {
                s.push(temp.rightChild);
            }
            if (temp.leftChild != null) {
                s.push(temp.leftChild);
            }
        }

        // Optimized

//        Stack<Node> s = new Stack<>();
//        s.push(root);
//        Node temp = root;
//        while (temp != null || s.isEmpty() == false) {
//            while (temp != null) {
//                System.out.print(temp.key + " ");
//                if (temp.rightChild != null) {
//                    s.push(temp.rightChild);
//                }
//                temp = temp.leftChild;
//            }
//            if (s.isEmpty() == false) {
//                temp = s.pop();
//            }
//        }
    }

    // Level Order Traversal
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.key + " ");
            if (temp.leftChild != null) {
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                queue.add(temp.rightChild);
            }
        }
    }

    // Size of the tree (Total Number of nodes present in the tree)
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }else  {
            return (1 + size(root.leftChild) + size(root.rightChild));
        }
    }


    // Node with the maximum value
    public static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }else {
            return Math.max(root.key, Math.max(max(root.leftChild), max(root.rightChild)));
        }
    }

    // Height of the Tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }else {
            return (1 + Math.max(height(root.leftChild), height(root.rightChild)));
        }
    }
}

class Node {
    int key;
    Node leftChild;
    Node rightChild;

    public Node(int key) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }
}


// Recursive Inorder, Preorder and Postorder Traversal
// Time Complexity: O(N)
// Space Complexity: O(h) where h is height of the binary tree

// Height of the binary tree
// Time Complexity: O(N)
// Space Complexity: O(h) where h is height of the binary tree

// Level Order Traversal
// Time Complexity: O(N)
// Space Complexity: O(N)

// Size of the Binary Tree
// Time Complexity: O(N)
// Space Complexity: O(h) where h is the height of the binary tree

// Maximum in a Binary Tree
// Time Complexity: O(N)
// Space Complexity: O(h) where h is the height of the binary tree


// Iterative Inorder, Preorder and Postorder traversal
// Time Complexity = O(N)
// Space Complexity = O(H)