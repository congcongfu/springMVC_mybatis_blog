/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package sort;

/**
 * @author fucong
 * @version $Id MaxData.java, v 0.1 2017-03-08 下午10:23 fucong Exp $$
 */
public class MaxData <T extends Comparable<T>>{

    private T [] data;

    private int size = 0;

    public MaxData(int maxSize){
        data = (T []) new Comparable[maxSize+1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(T value){
        // // TODO: 17/3/8
        data[++size] = value;
        swim(size);
    }

    public T deleteMax(){
        T min = data[1];
        swap(1,size--);
        data[size+1] = null;
        sink(1);
        return min;
    }

    private void swim(int k){
        while (k >1 && less(k/2,k)){
            swap(k,k/2);
            k = k /2;
        }

    }

    private void sink(int k){
        while (2 * k <= size){
            int j = 2* k;
            if (j < size && less(j,j+1)) j++;
            if (!less(k,j)) break;
            swap(k,j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return  data[i].compareTo(data[j]) < 0 ;
    }

    private void swap(int i, int j){
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String [] args){
        int size = 12;
        MaxData<Integer> data = new MaxData<Integer>(size);
        for (Integer i = 1; i < size; i++){
            data.insert(i);
        }
        System.out.println("gg");
    }
}

