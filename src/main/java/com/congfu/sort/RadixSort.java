/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fucong
 * @version $Id RadixSort.java, v 0.1 2017-03-05 下午5:33 fucong Exp $$
 */
public class RadixSort {
    public static void  main (String [] args){

        Integer [] data = new Integer[]{11,71,19,33,45,15,16,77,88,23,66,33,55,70,12,32,43,54,65,76,91};
        sort(data);
        System.out.println(data);
    }

    public static <T extends Comparable<T>> void sort(T[] data){
        String temp ;
        T numObj;
        int digit,num;
        Integer a = 3;

        Queue<T> [] digitQueues = (LinkedList<T>[]) (new LinkedList[data.length]);
        for (int digtiVal = 0; digtiVal <= data.length-1; digtiVal++){
            digitQueues[digtiVal] = (Queue<T>)(new LinkedList<T>());
        }

        for (int position = 0; position <=1; position++){
            for(int scan = 0; scan < data.length;scan++){
                temp = String .valueOf(data[scan]);
                digit = Character.digit(temp.charAt(1-position),10);
                digitQueues[digit].add(data[scan]);
            }

            num = 0;
            for (int digitVal = 0 ; digitVal < data.length-1;digitVal++){
                while (!(digitQueues[digitVal].isEmpty())){
                    numObj = digitQueues[digitVal].remove();
                    data[num] = numObj;
                    num++;
                }
            }
        }
    }
}
