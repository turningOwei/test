package algorithm.exchangeSort;

public class BubbleSort1 {
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// 第一次肯定把最大值冒在最右边
			// 第二次则是把第二大值冒在右边第二个位置
			// 第三次则是把第三大值冒在右边第三个位置
			// ...
			// 结论就是外层循环值减少
			for (int j = 0; j < arr.length - 1; j++) {
				int a = arr[j];
				int b = arr[j + 1];
				if (a > b) {
					int tmp = a;
					arr[j] = b;
					arr[j + 1] = tmp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 45, 20, 33, 12, 11, 32, 0, 1, 5, 7 };
		int[] aa = BubbleSort1.sort(arr);
		for (int i = 0; i < aa.length; i++) {
			System.out.print(aa[i] + " ");
		}
	}
}
