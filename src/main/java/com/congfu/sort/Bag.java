/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.sort;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author fucong
 * @version $Id Bag.java, v 0.1 2017-03-15 下午10:20 fucong Exp $$
 */
public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int size;

    private static class  Node<Item>{
        private Item item;
        private Node<Item> next;

        public Node(Item item){
            this.item = item;
            next=null;
        }
    }

    public Bag(){
        first = null;
        size = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return  size;
    }

    public void add(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>(item);
        first.next = oldFirst;
        size++;
    }

    public boolean contains(Item item){
        boolean result = find(first,item);


        return  result;
    }

    private boolean find(Node<Item> node,Item item){
        if (node ==null) return  false;
        else  if (item.equals(node.item)) return  true;
        else return find(node.next,item);
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String [] args){
        Bag<String> bag = new Bag<String>();
        for (int i = 0; i < 10; i++){
            bag.add("1"+i);
        }
        System.out.println(" size of bag = "+bag.size());
        System.out.println(bag.contains("20"));
    }
}
























