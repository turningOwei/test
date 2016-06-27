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
					// 排序排好 比最大值大,跳出循环
					break;
				}
			}
			// 插入的位置
			arr[j + 1] = a;
		}
		return arr;
	}

	public static void main(String[] args) {
		Integer[] arr = { 3, 2, 5, 8, 1, 0 };
		Integer[] re = DirectInsertSort.insertSort(arr);
		System.out.println(Arrays.asList(re));
	}
}
