/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.sort;

/**
 * @author fucong
 * @version $Id BubbleSort.java, v 0.1 2017-03-04 下午2:25 fucong Exp $$
 */
public class BubbleSort {

    public static void  main (String [] args){

        int [] data = new int[]{11,7,9,33,45,5,6,77,88,23,66,33,55,70,12,32,43,54,65,76,9};
        sort(data);
        System.out.println(data);    }

    public static  void  sort(int [] data ){

        for (int i =0; i <data.length; i++){
            for (int j =data.length-1; j>i; j--){
                 int temp = data[i];
                if(data[i] >data[j]){
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}

