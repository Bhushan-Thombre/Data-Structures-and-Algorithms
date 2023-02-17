// Given a binary tree, find the left view of the binary tree

package leftView;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int key;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int key) {
        this.key = key;
        leftChild = rightChild = null;
    }
}
public class LeftViewBinaryTree {

    // Time Complexity = O(N)
    // Space Complexity = O(No. of levels OR height)
    // N = No. of Nodes in the given tree;
    static void levelOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    list.add(curr.key);
                }
                if (curr.leftChild != null) {
                    queue.add(curr.leftChild);
                }
                if (curr.rightChild != null) {
                    queue.add(curr.rightChild);
                }
            }
        }
    }

    static int currLevel = 0;


    // Time Complexity = O(N)
    // Space Complexity = O(No. of levels OR height)
    // N = No. of Nodes in the given tree;
    public static void preOrder(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (currLevel < level) {
            list.add(root.key);
            currLevel = level;
        }
        preOrder(root.leftChild, level + 1, list);
        preOrder(root.rightChild, level + 1, list);
    }
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(10);
//        root.leftChild = new TreeNode(20);
        root.rightChild = new TreeNode(30);
//        root.rightChild.leftChild = new TreeNode(40);
        root.rightChild.rightChild = new TreeNode(50);
        root.rightChild.rightChild.leftChild = new TreeNode(60);
        root.rightChild.rightChild.rightChild = new TreeNode(70);

        List<Integer> list = new ArrayList<Integer>();

//        preOrder(root, 1, list);
        levelOrder(root, list);
        System.out.println(list);
    }
}
