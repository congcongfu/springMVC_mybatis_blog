/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package tree;

import org.omg.CORBA.NO_IMPLEMENT;

import java.security.Key;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author fucong
 * @version $Id BSTree.java, v 0.1 2017-03-12 下午12:45 fucong Exp $$
 */
public class BSTree <T extends Comparable<T>,Value>{

    private class  Node{
        private T key;
        private Value value;
        private Node left,right;
        private int size = 0;
        private Node(T key,Value value){
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private  int size;

    public int size(){
        return  size;
    }

    public void put(T key, Value value){
        root = putValue(root,key,value);
        size++;
    }

    // don't have same key
    private Node putValue(Node node, T key, Value value){
        if (node == null) return  new Node(key,value);
        if (key.compareTo(node.key) <0){
            node.left = putValue(node.left,key,value);
        }else if (key.compareTo(node.key)>0){
            node.right = putValue(node.right,key,value);
        }
        return  node;
    }

    public Value get(T key){
        Node temp = find(root,key);

        return temp.value;
    }

    public boolean contains(T key){
        return  (find(root,key) != null);
    }

    public Node find(Node x,T key){
        Node temp = null;
        if (x == null) return  null;
        if (key.compareTo(x.key)<0){
            return find(x.left,key);
        }else  if (key.compareTo(x.key)>0){
            return find(x.right,key);
        }else if (key.equals(x.key)){
            temp = x;
        }
        return  temp;

    }

    public Node getMin(){
        if (root == null) return  null;
        Node minNode = root;
        while (minNode.left != null){
            minNode = minNode.left;
        }
        return  minNode;
    }

    public Value min(){
        Node minNode = min(root);
        return  minNode.value;
    }

    private Node min(Node node){
        if (node.left == null) return  node;
        return  min(node.left);
    }

    public Node getMax(){
        if (root == null) return  null;
        Node maxNode = root;
        while (maxNode.right != null){
            maxNode = maxNode.right;
        }
        return  maxNode;
    }

    public void deleteMin(){
        if (root == null) return;
        root = deleteMin(root);
        size--;
    }


    private Node deleteMin(Node node){

        if (node.left == null) return  node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public void delete(T key){
        root = delete(root,key);
        size--;
    }

    private Node delete(Node node,T key){
        if (node == null) return  null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left,key);
        else if (cmp > 0) node.right = delete(node.right,key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return  node.right;
            Node temp = node;
            node = min(temp.right);    //删除节点的右子树 的最小节点成为新节点
            node.right = deleteMin(temp.right);  // 删除节点的 右子树成为新节点的右节点
            node.left = temp.left;    //删除节点的左节点成为新节点的左节点。
        }
        return  node;
    }

    public Node deleteNode(Node node, T key){
        if (node == null) return  null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = deleteNode(node.left,key);
        }else if(cmp > 0){
            node.right = deleteNode(node,key);
        }else {
            if (node.left == null) return  node.right;
            if (node.right == null) return  node.left;
            Node temp = node;
            node = min(temp);
            node.left = deleteMin(temp);
            node.right = temp.right;
        }

        return  node;
    }

    public Iterable<T> keys()
    {
        return keys(getMin().key,getMax().key);
    }

    public Iterable<T> keys(T low,T high){
        Queue<T> queue = new PriorityQueue<T>();
        keys(root,queue,low,high);
        return queue;
    }




    private Iterable<T>  keys(Node node, Queue<T> queue, T low, T high){
        if (node == null) return  null;
        int cmpLow = low.compareTo(node.key);
        int cmpHigh = high.compareTo(node.key);

        if (cmpLow<0){
            keys(node.left,queue,low,high);
        }
        if (cmpLow <= 0 && cmpHigh >=0){
            queue.add(node.key);
        }
        if (cmpHigh >0){
            keys(node.right,queue,low,high);
        }
        return queue;
    }


    public static  void  main(String [] args){
        BSTree<Integer,String> tree = new BSTree<Integer, String>();
        tree.put(4,"4");
        tree.put(3,"3");
        tree.put(2,"2");
        tree.put(1,"1");
        tree.put(5,"5");
        tree.put(8,"8");
        tree.put(7,"7");
        tree.put(6,"6");
//        tree.deleteMin();
        Iterable<Integer> ite = tree.keys(2,9);

        System.out.println(tree.getMax().value);
        System.out.println(tree.min());
    }


}