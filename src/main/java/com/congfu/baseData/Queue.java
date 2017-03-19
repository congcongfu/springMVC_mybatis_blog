/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.baseData;


import javax.swing.text.Element;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 实现一个queue 的方法其实可以有多种,下面是采用链表的形式来实现FIFO 的功能的,每次新增一个元素的时候生成一个节点加到
 * 链表的最后,取的时候取链表的最前一个。
 * 也可以采用数组的形式来实现,没次新增一个元素的时候放到数组的最后一个,取的时候取数组的第一个
 * @author fucong
 * @version $Id Queue.java, v 0.1 2017-03-19 上午11:18 fucong Exp $$
 */
public class Queue<T> implements Iterable<T> {
    private Node<T> first;   //beginning of queue
    private Node<T> last;    // end of queue
    private int n=0;          //number of elements on queue


    private static  class Node<T>{
        private T element;
        private Node<T> next;
        public Node(T element){
            this.element = element;
            this.next = null;
        }
        public Node(){}
    }


    public Queue(T element){
        this.first = new Node<T>(element);
        n=1;
        this.last = null;
    }


    public Queue(){
        this.first = null;
        this.last = null;
        n = 0;
    }

    public boolean isEmpty(){
        return  n == 0;
    }
    /**
     * get the first element of the queue
     * @return
     */
    public T peek(){
        if (n==0) throw  new NoSuchElementException("Queue is empty ! ");
        return first.element;
    }

    /**
     * adds element to the queue
     * @param element
     */
    public void enqueue(T element){


        Node<T> oldLast = last;
        last = new Node<T>(element);
        if (isEmpty()){
            first = last = new Node<T>(element);
        }else oldLast.next = last;
         n++;
    }

    public T dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue is empty !");
        Node oldFist = first;
        T element = first.element;
        first = oldFist.next;
        n--;
        if (isEmpty()) last = null;
        return  element;
    }



    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.element;
            current = current.next;
            return item;
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (T element : this){
            s.append(element);
            s.append(" ");
        }
        return  s.toString();
    }


    public static  void main(String [] args){
        Queue<String> queue = new Queue<String>();
        queue.enqueue("fuck");
        queue.enqueue("yourself");
        queue.enqueue("hard");
        queue.enqueue("hard");
        queue.enqueue("again");
        System.out.println(queue.toString());
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue()+" -- ");
        }
    }
}



























