/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package sort;

/**
 * @author fucong
 * @version $Id MinData.java, v 0.1 2017-03-08 下午8:53 fucong Exp $$
 */
public class MinData<T extends  Comparable<T>> {

    private T [] data;

    private int size = 0;

    public MinData(int maxSize){
        data = (T []) new Comparable[maxSize+1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T getMin(){return data[1];}

    public void insert(T value){
        // // TODO: 17/3/8
        data[++size] = value;
        swim(size);
    }

    public T deleteMin(){
        T min = data[1];
        // // TODO: 17/3/8
        swap(1,size--);
        data[size+1] = null;
        sink(1);
        return min;
    }

    private void swim(int k){
        while (k > 1 && less(k,k/2)){
            swap(k,k/2);
            k = k /2;
        }

    }

    private void sink(int k){
        while (2 * k < size){
            int j = 2* k;
            if (j < size && less(j+1,j)) j++;
            if (less(k,j)) break;
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
        int size = 11;
        MinData<Integer> data = new MinData<Integer>(size);
        for (Integer i = 1; i < size; i++){
            data.insert(i);
        }
        long time = System.currentTimeMillis();
        for (Integer j =10000000; j >10; j--){
            if (j.compareTo(data.getMin())>0){
                data.deleteMin();
                data.insert(j);
            }

        }


        System.out.println(" Takes time " +(System.currentTimeMillis() -time) /1000 +" s");
        System.out.print("");
    }

}

