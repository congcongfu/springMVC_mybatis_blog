/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package sort;

/**
 * @author fucong
 * @version $Id Heap.java, v 0.1 2017-03-08 下午10:48 fucong Exp $$
 */
public class Heap {
    private Heap(){};

    public static void sort(Comparable[] data){
        int n = data.length;
        for (int k = n/2; k >=1; k--)
            sink(data,k,n);
        while (n>1){
            swap(data,1,n--);
            sink(data,1,n);
        }
    }

    private static void sink(Comparable[] data,int k, int n){
        while (2*k <= n){
            int j = 2 * k;
            if (j < n && less(data,j,j++)) j++;
            if (!less(data,k,j)) break;;
            swap(data,k,j);
            k = j;
        }
    }

    private static boolean less(Comparable[] data, int i , int j){
        return data[i-1].compareTo(data[j-1])<0;
    }

    private static void swap(Object[] data,int i , int j){
        Object temp = data[i-1];
        data[i-1] = data[j-1];
        data[j-1] = temp;
    }


    public static  void  main(String[] args){
        String[] data = new String[]{"S","O","R","T","E","X","A","M","P","L","E"};
        Heap.sort(data);
        System.out.println(" ************ ");
    }

}
