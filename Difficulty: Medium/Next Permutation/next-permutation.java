class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;

        // Step 1: find the pivot
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: if pivot found, find successor and swap
        if (pivot != -1) {
            for (int i = n - 1; i > pivot; i--) {
                if (arr[i] > arr[pivot]) {
                    swap(arr, pivot, i);
                    break;
                }
            }
        }

        // Step 3: reverse suffix
        reverse(arr, pivot + 1, n - 1);
    }

    // Swap helper
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverse helper
    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
