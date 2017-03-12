/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package sort;

import com.sun.tools.javac.util.Assert;

/**
 * @author fucong
 * @version $Id QuickSort.java, v 0.1 2017-03-04 下午2:35 fucong Exp $$
 */
public class QuickSort {
    public static void main(String [] args){
        Integer [] data = new Integer[]{11,7,9,33,45,5,6,77,88,23,66,33,55,70,12,32,43,54,65,76,9};
        quickSort(data);
        System.out.println(data);
    }

    public static <T extends Comparable<T>> void quickSort(T[] data){
        quickSort(data,0,data.length-1);
    }

    private static  <T extends Comparable<T>>  void quickSort(T[] data, int min, int max){
        if(min < max){
            int indexOfPartition = partition(data,min,max);

            quickSort(data,min,indexOfPartition-1);

            quickSort(data,indexOfPartition+1,max);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] data,int min,int max){
        T partitionelement;
        int left, right;
        int middle = (max+min) / 2;
        partitionelement = data[middle];
        swap(data,middle,min);
        left = min;
        right = max;

        while (left < right){
            while (left < right && data[left].compareTo(partitionelement)<=0){
                left++;
                System.out.println("gg");
            }

            while (data[right].compareTo(partitionelement) >0){
                right--;
            }

            if(left < right){
                swap(data,left,right);
            }
            swap(data,min,right);
        }
        return  right;
    }

    public static <T extends  Comparable<T>> void   swap(T[] data, int index1,int index2){
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private static <T extends  Comparable<T>>   int partition1(T [] data, int min, int max){
        int middle = (min + max)/2;
        T partitionElement = data[middle];
        int left = min;
        int right = max;
        swap(data,min,middle);
        while (left < right ){

            while (data[left].compareTo(partitionElement)<0 ){
                left++;
            }
            while (partitionElement.compareTo(data[right])<0){
                right++;
            }
            if(left < right){
                swap(data,right,left);
            }
        }
        swap(data,min,right);
        return  right;
    }
}


































