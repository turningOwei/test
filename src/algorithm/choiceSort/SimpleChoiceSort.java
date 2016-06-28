package algorithm.choiceSort;

public class SimpleChoiceSort {
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int position = i + 1;
			// int a = arr[i]; 取到的还是最初的值,所以放入下层循环
			for (int j = position; j < arr.length; j++) {
				int a = arr[i];
				int b = arr[j];
				if (b < a) {// 交换位置
					position = j;
					int tmp = a;
					arr[i] = b;
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 45, 20, 33, 12, 11, 32, 0, 1, 5, 7 };
		int[] aa = SimpleChoiceSort.sort(arr);
		for (int i = 0; i < aa.length; i++) {
			System.out.print(aa[i] + " ");
		}
	}
}
