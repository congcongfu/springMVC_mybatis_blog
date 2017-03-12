/**
 * Company
 * Copyright (C) 2004-2017 All Rights Reserved.
 */
package sort;

/**
 * @author fucong
 * @version $Id SelectionSort.java, v 0.1 2017-03-04 下午3:29 fucong Exp $$
 */
public class SelectionSort {

    public static void main(String [] args){
        int [] data = new int[]{11,7,9,33,45,5,6,77,88,23,66,33,55,70,12,32,43,54,65,76,9,4,0,44};
        sort(data);
        System.out.println(data);
    }

    /**
     * 选择排序算法通过发福将某一特定值放到它的列表中的最终已排序位置从而完成对某一列表值的排序
     * 第一步: 扫描整个列表中的最小值,然后将这个最小值和该列表的第一个值对换
     * 第二步: 从列表的第二个值开始扫描找到最小值,并与列表第二个值对换
     * @param data
     */
    public static void sort(int [] data){

        for (int i = 0; i< data.length; i++){

            int minDataIndex = getMinDataIndex(data,i,data.length-1);
            int temp = data[minDataIndex];
            data[minDataIndex] = data[i] ;
            data[i] = temp;
        }
    }

    public static  int getMinDataIndex(int [] data ,int start,int end){
        int temp = data[start];
        int index = start;

        for (int i=start; i<= end; i++){
            if (data[i] < temp) {
                temp = data[i];
                index = i;
            }
        }

        return  index;
    }
}

