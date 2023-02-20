class Solution {
	public static int maxConsecutive(int bottom, int top, int[] arr) {
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		if (arr[0] - bottom > 0) {
			max = Math.max(max, arr[0] - bottom);
		}
		if (top - arr[arr.length - 1] > 0) {
			max = Math.max(max, top - arr[arr.length]);
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] > 1) {
				max = Math.max(max, arr[i + 1] - arr[i]);
			}
		}
		return max;
	}
}
