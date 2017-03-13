/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package com.congfu.sort;

import java.util.Arrays;

/**
 * @author fucong
 * @version $Id BinarySearch.java, v 0.1 2017-02-09 下午10:30 fucong Exp $$
 */
public class BinarySearch<T extends Comparable<T>> {


    public  static  void  main(String [] args){
        Integer [] data = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

    }

    public int contains(T [] data,T key){
        if (data.length ==0) return  -1;
        int low = 0;
        int high = data.length-1;
        return binarySearch(data,low,high,key);
    }

    public  int binarySearch(T[] data, int low, int high , T key){
        int midel = (low+high)/2;
        if (key.equals(data[midel])) return  midel;
        else if (key.compareTo(data[midel])<0) return binarySearch(data,low,midel-1,key);
        else if (key.compareTo(data[midel])>0) return binarySearch(data,low,midel+1,key);
        return  -1;
    }

}


