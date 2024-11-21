/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lab_practicle.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Ibrar Ali
 */
public class Binary_TREE {
    
    BTNode root;

    public void insert(int data){
        root = insertRec(root,data);
    }
    public BTNode insertRec(BTNode root,int data){
        if(root == null){
            root = new BTNode(data);
        }
        else if(data<root.data){
            root.left = insertRec(root.left,data);
        }else{
            root.right = insertRec(root.right,data);
        }
        return root;
    }
    
    
    
    public int countNodes() {
            return countNodesRec(root);
    }
    private int countNodesRec(BTNode root) {
        if(root == null) {
            return 0;
    }
            return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }    
         

    
     
    public void inorder(){
        inorderRec(root);
    }
    public void inorderRec(BTNode root){
    if(root != null){
        inorderRec(root.left);
        System.out.print(root.data+" ");
        inorderRec(root.right);
    }    
    }

   public void preorder(){
        preorderRec(root);
    }
    public void preorderRec(BTNode root){
        if(root != null){
            System.out.print(root.data+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }


    public void postorder(){
        postorderRec(root);
    }
    public void postorderRec(BTNode root){
        if(root!= null){
            preorderRec(root.left);
            preorderRec(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void levelorder(){
     Queue<BTNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             BTNode current = queue.poll();
                System.out.print(current.data+" ");
             if(current.left != null){
                 queue.add(current.left);
             }
             if(current.right != null){
                 queue.add(current.right);
             }
         }
    }
    
    
    
    public boolean search(BTNode root, int key) {
    if (root == null) {
        return false;
    }
    if (root.data == key) {
        return true;
    }
    if (key < root.data) {
        return search(root.left, key);
    }
        return search(root.right, key);
    }

    public boolean search(int key) {
        return search(root, key);
    }
    
    
    
    public static void main(String []args){
        Binary_TREE obj = new Binary_TREE();
        
        obj.insert(50);
        System.out.println(obj.countNodes());
        obj.insert(30);
        System.out.println(obj.countNodes());
        obj.insert(20);
        System.out.println(obj.countNodes());
        obj.insert(40);
        System.out.println(obj.countNodes());
        obj.insert(70);
        System.out.println(obj.countNodes());
        obj.insert(60);
        System.out.println(obj.countNodes());
        obj.insert(80);
        System.out.println(obj.countNodes());
        
        System.out.println("\nSearching: " + obj.search(obj.root, 20));
        System.out.println("Searching: " + obj.search(obj.root, 60));
        System.out.println("Searching: " + obj.search(obj.root, 90));
        
        System.out.print("\nIn-order traversal: ");
        obj.inorder();
        System.out.print("\nPre-order traversal: ");
        obj.preorder();
        System.out.print("\nPost-order traversal: ");
        obj.postorder();
        System.out.print("\nLevel-order traversal: ");
        obj.levelorder();
        
    }

}    
