/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.search;

/**
 * @author fucong
 * @version $Id SequentialSearch.java, v 0.1 2017-03-11 下午2:59 fucong Exp $$
 */
public class SequentialSearch<Key,Value> {

    private  int size = 0;

    private Node first;
    private class  Node{
        Key key;
        Value value;
        Node next;

        public  Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key){
        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)){
                return x.value;
            }
        }
        return  null;
    }

    public void  put(Key key, Value value){
        Node x = first;
        for (; x != null ; x = x.next){
            if (key.equals(x.key)){
                x.value = value;
                return;
            }
        }
        first = new Node(key,value,first);
        size++;
    }




    public int getSize(){
        return  size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public  void  delete(Key key){
        if (key == null) return;;
        first = delete(first,key);

    }

    private Node delete(Node node, Key key){
        if (node == null) return  null;
        if (key.equals(node.key)){
            size--;
            return  node.next;
        }
        node.next = delete(node,key);  //
        return  node;
    }


}




















