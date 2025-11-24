class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);
        int prefix = 0;
        for (int bit : A) {
            prefix = ((prefix << 1) + bit) % 5;
            result.add(prefix == 0);
        }
        return result;
    }
}
