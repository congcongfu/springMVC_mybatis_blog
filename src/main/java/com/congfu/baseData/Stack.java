/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.baseData;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author fucong
 * @version $Id Stack.java, v 0.1 2017-03-19 下午12:44 fucong Exp $$
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> first;
    private int count;

    public Stack(){
        first = null;
        count = 0;
    }

    public boolean isEmpty(){
        return  count==0;
    }

    public int size(){
        return count;
    }

    /**
     * push element to the stack
     * @param element
     */
    public void push(T element){
        if (!isEmpty()){
            Node<T> newFirst = new Node<T>(element);
            newFirst.next = first;
            first = newFirst;
        }else first= new Node<T>(element);
        count++;
    }

    /**
     * pop the first element in the stack
     * @return
     */
    public T pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack is empty !");
        T element = first.element;
        first = first.next;
        count--;
        return element;
    }

    public T peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack is empty !");
        return first.element;
    }


    private static class Node<T>{
        private T element;
        private Node<T> next;
        public Node(T element){
            this.element = element;
            next = null;
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }
    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

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
            s.append(' ');
        }
        return s.toString();
    }

    public static void main(String [] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.toString());
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}