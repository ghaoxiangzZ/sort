package com.ghaoxiang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ghaoxiang.sort.service.SortService;
/**
 * @author ghaoxiang
 * @version V1.0
 * @Title SortTest
 * @Description java常见排序测试
 * @date 2019年01月21日 09:46
 * @since V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SortTest {

	@Autowired
	private SortService sortService;

	private int[] array = {21, 33, 55, 20, 34, 1, 5, 7, 9, 2, 4, 77, 6, 8, 233, 156};

	/**
	 * 测试冒泡排序
	 */
	@Test
	public void bubbleSortTest() {
		array = sortService.bubbleSort(array);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.println(array[i]);
			}
		}
	}

	/**
	 * 测试选择排序
	 */
	@Test
	public void selectionSortTest() {
		array = sortService.selectionSort(array);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}

	/**
	 * 测试插入排序
	 */
	@Test
	public void insertionSortTest() {
		array = sortService.insertionSort(array);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}

	/**
	 * 测试归并排序
	 */
	@Test
	public void mergeSortTest() {
		array = sortService.mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}

	/**
	 * 测试快速排序
	 */
	@Test
	public void quickSortTest() {
		array = sortService.quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}

	/**
	 * 测试堆排序
	 */
	@Test
	public void heapSortTest() {
		array = sortService.heapSort(array);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}

	/**
	 * 测试计数排序
	 */
	@Test
	public void countingSortTest() {
		array = sortService.countingSort(array);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}

	/**
	 * 测试桶排序
	 */
	@Test
	public void bucketSortTest() {
		Integer[] array = {21, 33, 55, 20, 34, 1, 5, 7, 9, 2, 4, 77, 6, 8, 233, 156};
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
		list = sortService.bucketSort(list, 5);
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1) {
				System.out.print(list.get(i) + ",");
			} else {
				System.out.print(list.get(i));
			}
		}
	}

	/**
	 * 测试基数排序
	 */
	@Test
	public void radixSortTest() {
		array = sortService.radixSort(array);
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ",");
			} else {
				System.out.print(array[i]);
			}
		}
	}
}

