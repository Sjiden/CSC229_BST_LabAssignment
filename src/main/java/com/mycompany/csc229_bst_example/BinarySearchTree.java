package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        // ToDo 1: complete InOrder Traversal 
        if (root == null) {
            return;
        }
        doInOrder(root.getLeft());
        System.out.println(root.getData());
        doInOrder(root.getRight());
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal.
        }
    
    private void doPreOrder(BstNode node) {
        if (node == null) return;
        System.out.println(node.getData());
        doPreOrder(node.getLeft());
        doPreOrder(node.getRight());
    }

 // ToDo 3: Find the height of a tree
    
     public Integer findHeight() {
        return getHeight(this.root);
    }

    private Integer getHeight(BstNode node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.getLeft());
        int right = getHeight(node.getRight());

        int height;
        if (left > right) {
            height = left;
        } else {
            height = right;
        }
        return height + 1;
    }
    
    

     public int getDepth(int num) {
        BstNode current = root;
        int depth = 0;

        while (current != null) {
            if (num == current.getData()) {
                return depth;
            } else if (num < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            depth++;
        }

        return depth;
    }
     
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }
   
   private void print(String moreOrLess, BstNode node, boolean leftOrRight) {
    if (node != null) {
        String right;
        String left;
        String currentNode;

        if (leftOrRight) {
            right = moreOrLess + "|-- ";
            left = moreOrLess + "|   ";
            currentNode = moreOrLess + "|-- ";
        } else {
            right = moreOrLess + "|++ ";
            left = moreOrLess + "    ";
            currentNode = moreOrLess + "|++ ";
        }

        print(right, node.getRight(), false);
        System.out.println(currentNode + node.getData());
        print(left, node.getLeft(), true);
    }
  }
   

}
