/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.sort;

/**
 * @author fucong
 * @version $Id InsertSort.java, v 0.1 2017-03-04 下午1:41 fucong Exp $$
 */
public class InsertSort {

    public static   void  sort(int [] data){
        int temp =0;
        for (int i = 1; i< data.length;i++){
            temp = data[i];
            int j = i -1;
            for (; j >=0 && temp < data[j];j--){
                data[j+1] = data[j];
            }
            data[j+1] = temp;
        }
    }

    public static void main(String [] args){
        int [] data = new int[]{11,7,9,33,45,5,6,77,88,23,66,33,55,70,12,32,43,54,65,76,9};
        sort(data);
        System.out.println(data);
    }
}
