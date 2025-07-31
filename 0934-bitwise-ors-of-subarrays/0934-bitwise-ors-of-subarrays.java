class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> cur = new HashSet<>();    // OR results of subarrays ending at previous index
        Set<Integer> result = new HashSet<>(); // All distinct OR results
        
        for (int a : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(a);
            for (int x : cur) {
                next.add(x | a);
            }
            cur = next;
            result.addAll(cur);
        }
        
        return result.size();
    }
}
