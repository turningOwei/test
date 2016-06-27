package algorithm.insertSort;

public class ShellSort {
	public static void shellSort(int[] data) {
		int j = 0;
		int temp = 0;
		for (int increment = data.length / 2; increment > 0; increment /= 2) {
			for (int i = increment; i < data.length; i++) {
				temp = data[i];
				for (j = i; j >= increment; j -= increment) {
					if (temp > data[j - increment]) {
						data[j] = data[j - increment];
					} else {
						break;
					}
				}
				data[j] = temp;
			}
		}
	}

	/*
	 * public static void main(String[] args) { int[] data = new int[] { 5, 2,
	 * 8, 9, 1, 3, 4 };
	 * 
	 * System.out.println("未排序前"); for (int i = 0; i < data.length; i++) {
	 * System.out.print(data[i] + " "); }
	 * 
	 * shellSort(data);
	 * 
	 * System.out.println("\n排序后"); for (int i = 0; i < data.length; i++)
	 * System.out.print(data[i] + " "); }
	 */

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 希尔排序
		int d = a.length;
		while (true) {
			for (int i = 0; i < d; i++) {
				for (int j = i; j + d < a.length; j += d) {
					int temp;
					if (a[j] > a[j + d]) {
						temp = a[j];
						a[j] = a[j + d];
						a[j + d] = temp;
					}
				}
			}

			if (d == 1) {
				break;
			}
			d--;
		}
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
