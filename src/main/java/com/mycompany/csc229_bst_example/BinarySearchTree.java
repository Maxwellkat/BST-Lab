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
if(root!= null) {
    doInOrder(root.getLeft());
    System.out.print(root.getData() + " "); //For in order, it will go through the left, then the node its on printing it, then the right
    doInOrder(root.getRight());
}
        // ToDo 1: complete InOrder Traversal 
    }
        public void preOrderTraversal() {
if(root!=null){
    System.out.print(root.getData()+ " ");
    doPreOrder(root.getLeft());
    doPreOrder(root.getRight());

    // ToDo 2: complete the pre-order travesal .
    }


    }

    private void doPreOrder(BstNode left) {
        doPreOrder(this.root);
    }

    public Integer findHeight() {
return calcheight(root);
        // ToDo 3: Find the height of a tree
    }
    private int calcheight(BstNode node){
        if (node==null) {
            return -1;
        } else{
            int leftHeight=calcheight(node.getLeft()); //This method takes the heights of the left and right sides and adds them with one being the base of the tree
            int rightheight=calcheight(node.getRight());
            return 1+leftHeight+rightheight;

        }
    }

    

    public int getDepth(BstNode node) {
return calcDepth(root,node,0);
        //ToDo 4: complete getDepth of a node 
    }
    private int calcDepth(BstNode root, BstNode node, int depth){
        if(root==null){
            return -1;
        }
        if(root==node){
            return depth;
        }
        int ldepth=calcDepth(root.getLeft(), node, depth+1);
        if(ldepth!= -1){
            return ldepth;
        }
        return calcDepth(root.getRight(),node,depth+1);
    }//THis method will either find or not find a node for the first two if's, then it will check the left tree, and return if found, and then check the right to see the depth.
    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        printTree(root, 0);
        // ToDo 5: complete the print of the BST
    }
    private void printTree(BstNode node, int level){
        if(node!=null){
            printTree(node.getRight(),level+1);
            for(int i=0;i<level;i++) {
                System.out.print("  ");
            }
            System.out.println(node.getData());
            printTree(node.getLeft(),level+1);
            }
        //First it checks the right tree and prints the node its on, and continues down the left tree while printing out the nodes
        }
    }



