/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.tree;


/**
 * @author fucong
 * @version $Id RedBlackTree.java, v 0.1 2017-03-12 下午9:48 fucong Exp $$
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> {
    //true means read
    private static  final boolean RED = true;
    // false means black
    private static final boolean BLACK = false;
    private  Node root;

    private class Node{
        private Key key;
        private Value value;
        private int size;
        private boolean color;
        private Node left,right;

        public Node(Key key, Value value,int size, boolean color){
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

    private boolean isRed(Node node){
        if (node == null) return  false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node){
        Node temp = node.right;     // 原节点的有节点变成根节点
        node.right = temp.left;     // 原来右节点的左孩子变成原根节点的右孩子
        temp.left = node;           //原来根节点变成现在节点的左孩子
        temp.color = node.color;    //交换颜色
        node.color = RED;           //重新着色
        temp.size = node.size;
        node.size = 1 + size(node.right) + size(node.left);
        return temp;
    }

    private Node rotateRight(Node node){
        Node temp = node.left;     //新的根节点
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        temp.size = node.size;
        node.size = 1 + size(node.right)+size(node.left);
        return temp;
    }

    public int size(){
        return  size(root);
    }

    private  int size(Node node){
        if (node == null) return 0;
        return node.size;
    }

    public  void  put(Key key,Value value){
        root = putValue(root,key,value);
        root.color = BLACK;
    }

    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node putValue(Node node,Key key,Value value){
        if (node == null) return  new Node(key,value,1,RED);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = putValue(node.left,key,value);
        else if (cmp > 0) node.right = putValue(node.right,key,value);
        else node.value = value;
        //右节点为红 左节点为黑 则左转
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        // 左节点且 左节点的左子节点为红则右转
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        //左右子节点都为红那么颜色转换
        if (isRed(node.left) && isRed(node.right)) flipColors(node);
        node.size = 1 + size(node.left)+size(node.right);
        return node;
    }





}























