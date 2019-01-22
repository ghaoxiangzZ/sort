/*
* 文件名: com.ghaoxiang.sort.service
* 文件编号: 
* 版权: Copyright (c) 2019, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
* 描述: 
* 创建人: ghaoxiang
* 创建时间: 2019年01月21日 09:34
* 修改人:
* 修改时间: 2019年01月21日 09:34
* 修改变更号: 
* 修改内容: 
*/
package com.ghaoxiang.sort.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

/**
 * @author ghaoxiang
 * @version V1.0
 * @Title SortService
 * @Description java常见排序
 * @date 2019年01月21日 09:34
 * @since V1.0
 */
@Service
public class SortService {

    /**
     * 冒泡排序：
     * 1、从左至右开始比较，如果左边的数值大于右边的数值，则交换位置，此时，数组末尾为数值最大
     * 2、重复步骤1，直到得到一个数值从小到大排列的数组
     * @param array
     * @return int[]
     */
    public int[] bubbleSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        // 外层循环从数组下标第0位开始遍历到下标n-1
        for (int i = 0; i < array.length; i++) {
            // 内层循环从数组下标0遍历到下标n-1-i
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 左边数值大于右边
                if (array[j] > array[j+1]) {
                   // 交换左右的数值
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序：
     * 1、定义一个最小下标minIndex，默认为0
     * 2、找出数组中数值最小的数的下标并赋值minIndex
     * 3、将array[minIndex]和array[0]的值互换,此时数组中最小的值在数组第一位
     * 4、重复步骤2、3，得到一个数值从小到大排列的数组
     * @param array
     * @return int[]
     */
    public int[] selectionSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int minIndex;
        // 外层循环从数组第一位开始遍历
        for (int i = 0; i< array.length; i++) {
            // 默认将最小值定义为第一位
            minIndex = i;
            // 内层循环从数组第二位开始遍历
            for (int j = i + 1; j < array.length; j++) {
                // 当第二位数值小于第一位
                if (array[minIndex] > array[j]) {
                    // 将最小值定义为第二位的数值
                    minIndex = j;
                }
            }
            // 交换第二位和第一位的数值
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序：
     * 1、可近似理解为扑克牌抓牌时从左至右从小到大排列，
     * 当新抓一张牌时，按顺序插入已有的手牌中
     * 2、默认第一个值是有序的，从array[1]遍历到array[array.length-1],依次按顺序插入
     * @param array
     * @return int[]
     */
    public int[] insertionSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int i, j;
        // 要插入的数据
        int insertData;
        // 从数组的第二个元素开始循环将数组中的元素插入
        for (i = 1; i < array.length; i++) {
            // 设置数组中的第2个元素为第一次循环要插入的数据
            insertData = array[i];
            j = i - 1;
            while (j >= 0 && insertData < array[j]) {
                // 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                array[j + 1] = array[j];
                j--;
            }
            // 直到要插入的元素不小于第j个元素,将insertData插入到数组中
            array[j + 1] = insertData;
        }
        return array;
    }

    /**
     * 希尔排序：
     * 1、将包含n个元素的数组，分成n/2个数组序列，第一个数据和第n/2+1个数据为一对...
 　　* 2、对每对数据进行比较和交换，排好顺序；
 　　* 3、然后分成n/4个数组序列，再次排序；
 　　* 4、不断重复以上过程，随着序列减少并直至为1，排序完成。
     * @param array
     * @return int[]
     */
    public int[] shellSort(int[] array) {
        // i表示希尔排序中的第n/2+1个元素（或者n/4+1）
        // j表示希尔排序中从0到n/2的元素（n/4）
        // r表示希尔排序中n/2+1或者n/4+1的值
        int i, j, r, tmp;
        // 划组排序
        for(r = array.length / 2; r >= 1; r /= 2) {
            for(i = r; i < array.length; i++) {
                tmp = array[i];
                j = i - r;
                // 插入排序
                 while(j >= 0 && tmp < array[j]) {
                     array[j+r] = array[j];
                     j -= r;
                 }
                array[j+r] = tmp;
            }
         }
         return array;
    }

    /**
     * 归并排序
     * @param array
     * @return int[]
     */
    public int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        // 找到数组中间点
        int mid = array.length / 2;
        // 根据中间点生成2个新的数组
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     * @param left
     * @param right
     * @return int[]
     */
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     * @return int[]
     */
    public int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            quickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    /**
     * 快速排序算法
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 声明堆排序算法全局array长度
    private int len;

    /**
     * 堆排序算法
     * @param array
     * @return int[]
     */
    public int[] heapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        // 构建一个最大堆
        buildMaxHeap(array);
        // 循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }

    /**
     * 建立最大堆
     * @param array
     * @return void
     */
    private void buildMaxHeap(int[] array) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     * @param array
     * @param i
     * @return void
     */
    private void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    /**
     * 计数排序
     * @param array
     * @return int[]
     */
    public int[] countingSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

    /**
     * 桶排序
     * @param array
     * @param bucketSize
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                // 如果带排序数组中有重复数字时
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1){
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    /**
     * 基数排序
     * @param array
     * @return int[]
     */
    public int[] radixSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        // 算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}
