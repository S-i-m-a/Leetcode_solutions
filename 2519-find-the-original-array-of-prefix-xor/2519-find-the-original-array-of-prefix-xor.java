class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        
        // The first element of the original array is the same as the first element of the prefix XOR array
        arr[0] = pref[0];
        
        // For the subsequent elements, arr[i] = pref[i] ^ pref[i-1]
        for (int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }
        
        return arr;
    }
}
