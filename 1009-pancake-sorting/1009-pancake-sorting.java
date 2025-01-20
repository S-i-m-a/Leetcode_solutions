import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        for (int size = n; size > 1; size--) {
            // Find the index of the largest element in the subarray arr[0...size-1]
            int maxIndex = findMaxIndex(arr, size);
            
            // Bring the largest element to the front, if it's not already there
            if (maxIndex != size - 1) {
                // Flip the array to bring the largest element to the front
                if (maxIndex > 0) {
                    flip(arr, maxIndex + 1);
                    result.add(maxIndex + 1);
                }
                
                // Flip again to bring the largest element to its correct position
                flip(arr, size);
                result.add(size);
            }
        }
        
        return result;
    }
    
    private int findMaxIndex(int[] arr, int size) {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    private void flip(int[] arr, int k) {
        int left = 0, right = k - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
