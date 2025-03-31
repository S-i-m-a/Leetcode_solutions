import java.util.*;

class Solution {
    int[] parent;

    public boolean gcdSort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        parent = new int[max + 1];
        for (int i = 0; i <= max; i++) parent[i] = i;

        for (int num : nums) {
            for (int f : getPrimeFactors(num)) {
                union(num, f);
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            if (find(nums[i]) != find(sorted[i]))
                return false;
        }
        return true;
    }

    // Prime factorization
    List<Integer> getPrimeFactors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) res.add(n);
        return res;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
