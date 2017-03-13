/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.tree;

import java.util.Comparator;
import java.util.Stack;

/**
 * @author fucong
 * @version $Id BinaryTree.java, v 0.1 2017-03-05 下午7:59 fucong Exp $$
 */
public class BinaryTree <T extends  Comparable<T>>{

    private BinaryTreeNode<T> root;
    private int modCount;

    public boolean isEmpty(){return modCount==0;}



    public BinaryTreeNode<T> invertTree(BinaryTreeNode<T> root){
        if (root == null) return  null;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        BinaryTreeNode<T> temp = root.left;
        root.left = root.right;
        root.right = temp;
        return  root;
    }


    private BinaryTreeNode<T> invertTree3(BinaryTreeNode<T> node){

        if(node == null) return  null;

        node.left = invertTree(node.left);
        node.right = invertTree(node.right);

        BinaryTreeNode<T> temp = root.left;
        root.left = root.right;
        root.right = root.left;

        return  root;

    }

    /**
     *
     * add element to the tree
     * @param element
     */
    public void addElement(T element){

        if(root ==null){
            root = new BinaryTreeNode<T>(element);
        }
        if(element.compareTo(root.getElement())<0){
            if(root.getLeft() ==null){
                root.setLeft(new BinaryTreeNode<T>(element));
            }else {
                addElement(element,root.getLeft());
            }
        }else {
            if(root.getRight() == null ){
                root.setRight(new BinaryTreeNode<T>(element));
            }else {
                addElement(element,root.getRight());
            }
        }
        modCount++;

    }

    private void  addElement(T element, BinaryTreeNode<T> node){

        if(element.compareTo(node.getElement())<0){
            if(node.getLeft() == null){
                node.setLeft(new BinaryTreeNode<T>(element));
            }else {
                addElement(element,node.getLeft());
            }
        }else {
            if(node.getRight() == null){
                node.setRight(new BinaryTreeNode<T>(element));
            }else {
                addElement(element,node.getRight());
            }
        }
    }

    /**
     * remove element from node;
     *
     * @param targetElement
     * @return
     */
    public T removeElement(T targetElement){
        T result = null;
        if(isEmpty()){
            return  null;
        }else {
            BinaryTreeNode<T> parent = null;
            if(((Comparable<T>)targetElement).equals(root.getElement())){
                result = root.getElement();
                BinaryTreeNode<T> temp = replacement(root);
                if(temp ==null) root = null;
                else {
                    root.setElement(temp.getElement());
                    root.setRight(temp.getRight());
                    root.setLeft(temp.getLeft());
                }
                modCount--;
            }else {
                parent = root;
                if(((Comparable<T>)targetElement).compareTo(root.element)<0){
                    result = removeElement(targetElement,root.getLeft(),parent);
                }else {
                    result  = removeElement(targetElement,root.getRight(),parent);
                }
            }
        }
        return  result;
    }

    private T removeElement(T targetElement,BinaryTreeNode<T> node,BinaryTreeNode<T> parent){
        T result = null;
        if(node == null)
            return null;
        else {
            if(((Comparable<T>)targetElement).equals(node.getElement())){
                result = node.getElement();
                BinaryTreeNode<T> temp = replacement(node);
                if(parent.getRight() == node){
                    parent.setRight(temp);
                }else {
                    parent.setLeft(temp);
                }
                modCount++;
            }else {
                parent = node;
                if((targetElement).compareTo(node.getElement())<0){
                    result = removeElement(targetElement,node.getLeft(),parent);
                }else {
                    result = removeElement(targetElement,node.getRight(),parent);
                }
            }
        }
        return  result;
    }


    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node){
        BinaryTreeNode<T> result = null;

        if(node.getLeft() == null && node.getRight() ==null) result =null;
        else  if (node.getLeft() != null &&  node.getRight() ==null) result = node.left;
        else if(node.getLeft() ==null && node.getRight() != null) result = node.getRight();
        else {
            BinaryTreeNode<T> current = node.getRight();
            BinaryTreeNode<T> parent = node;

            while (current.getLeft() != null){
                parent = current;
                current = current.getLeft();
            }

            current.setLeft(node.getLeft());
            if(node.getRight() != current){
                parent.setLeft(current.getRight());
                current.setRight(node.getRight());
            }
            result = current;
        }
        return  result;
    }












     class  BinaryTreeNode<T extends  Comparable<T>>{
         public BinaryTreeNode(T element){
             this.element = element;
             this.left = null;
             this.right= null;
         }

        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode<T> left) {
            this.left = left;
        }

        public BinaryTreeNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode<T> right) {
            this.right = right;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        private BinaryTreeNode<T> left;
        private BinaryTreeNode<T> right;
        private T element;
    }


}

