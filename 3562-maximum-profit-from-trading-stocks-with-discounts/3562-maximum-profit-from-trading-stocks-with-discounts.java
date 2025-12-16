import java.util.*;

class Solution {
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        // Build adjacency list for the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] e : hierarchy) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            tree.get(u).add(v);
        }
        
        // Run DFS from the root (0 = employee 1)
        Pair dpRoot = dfs(0, -1, tree, present, future, budget);
        
        // Return the max possible profit (no-discount DP)
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dpRoot.noDiscount[b]);
        }
        return ans;
    }
    
    static class Pair {
        int[] noDiscount;
        int[] withDiscount;
        Pair(int[] nd, int[] wd) {
            this.noDiscount = nd;
            this.withDiscount = wd;
        }
    }
    
    private Pair dfs(int u, int parent,
                     List<List<Integer>> tree,
                     int[] present, int[] future, int budget) {
        
        // Start with zero profits for both states
        int[] noDisc = new int[budget + 1];
        int[] withDisc = new int[budget + 1];
        
        // Process all children
        for (int v : tree.get(u)) {
            if (v == parent) continue;
            Pair childDP = dfs(v, u, tree, present, future, budget);
            noDisc = merge(noDisc, childDP.noDiscount, budget);
            withDisc = merge(withDisc, childDP.withDiscount, budget);
        }
        
        // Make copies for adding the current node
        int[] newNoDisc = Arrays.copyOf(noDisc, budget + 1);
        int[] newWithDisc = Arrays.copyOf(noDisc, budget + 1);
        
        // Option 1: Buy this stock at full price
        int fullCost = present[u];
        int profitFull = future[u] - fullCost;
        for (int b = fullCost; b <= budget; b++) {
            newNoDisc[b] = Math.max(newNoDisc[b],
                withDisc[b - fullCost] + profitFull);
        }
        
        // Option 2: Buy this stock at half price (if parent bought)
        int halfCost = present[u] / 2;
        int profitHalf = future[u] - halfCost;
        for (int b = halfCost; b <= budget; b++) {
            newWithDisc[b] = Math.max(newWithDisc[b],
                withDisc[b - halfCost] + profitHalf);
        }
        
        return new Pair(newNoDisc, newWithDisc);
    }
    
    // Knapsack merge: combine two DP arrays
    private int[] merge(int[] A, int[] B, int budget) {
        int[] res = new int[budget + 1];
        Arrays.fill(res, Integer.MIN_VALUE / 2);
        res[0] = 0;
        
        for (int i = 0; i <= budget; i++) {
            if (A[i] < 0) continue;
            for (int j = 0; j + i <= budget; j++) {
                res[i + j] = Math.max(res[i + j], A[i] + B[j]);
            }
        }
        return res;
    }
}
