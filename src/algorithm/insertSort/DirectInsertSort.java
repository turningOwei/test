package algorithm.insertSort;

import java.util.Arrays;

//直接插入
public class DirectInsertSort {
	public static Integer[] insertSort(Integer[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int a = arr[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				int b = arr[j];
				if (a < b) {// b之后的往后移
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			// 插入的位置
			arr[j + 1] = a;
		}
		return arr;
	}

	public static void main(String[] args) {
		Integer[] arr = { 3, 2 };
		Integer[] re = DirectInsertSort.insertSort(arr);
		System.out.println(Arrays.asList(re));
	}
}
