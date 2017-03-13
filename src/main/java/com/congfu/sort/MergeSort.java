/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.sort;

/**
 * @author fucong
 * @version $Id MergeSort.java, v 0.1 2017-03-05 上午10:59 fucong Exp $$
 */
public class MergeSort {
    public static void main(String [] args){
        Integer [] data = new Integer[]{11,7,9,33,45,5,6,77,88,23,66,33,55,70,12,32,43,54,65,76,9};
        mergeSort(data,0,data.length-1);
        System.out.println(data);
    }

    public    static   <T extends Comparable<T>> void mergeSort(T[] data,int min, int max){
        if(min < max){
            int middle = (min + max) / 2;
            mergeSort(data,min, middle);
            mergeSort(data,middle+1,max);
            merge(data,min,middle,max);
        }

    }

    private  static <T extends Comparable<T>>  void merge(T[] data ,int first,int middle,int last){
        T[] temp = (T []) new Comparable[last-first+1];
        int i = first;     //左指针
        int j = middle +1;  //右指针
        int k = 0;
        //把娇小的元素移入新数组中
        while (i <= middle && j <= last){
            if(data[i].compareTo(data[j])<0){
                temp[k++] = data[i++];
            }else {
                temp[k++] = data[j++];
            }
        }

        //把左边剩余的元素移入数组
        while (i<=middle){
            temp[k++] = data[i++];
        }

        //把右边剩余的元素移入数组
        while (j<= last){
            temp[k++] = data[j++];
        }
        //把新数组中的数覆盖原来数组
        for (int k2=0;k2<temp.length;k2++){
            data[k2+first] = temp[k2];
        }
    }


}

























