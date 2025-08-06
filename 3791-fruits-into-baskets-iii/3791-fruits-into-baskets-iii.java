class SegmentTree {
    int n;
    int[] tree;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[n * 4];
        build(nums, 1, 0, n - 1);
    }

    private void build(int[] nums, int u, int l, int r) {
        if (l == r) {
            tree[u] = nums[l];
            return;
        }
        int mid = (l + r) >>> 1;
        build(nums, u * 2, l, mid);
        build(nums, u * 2 + 1, mid + 1, r);
        tree[u] = Math.max(tree[u * 2], tree[u * 2 + 1]);
    }

    // Find the leftmost basket index i such that baskets[i] >= value, or -1 if none
    public int queryFirst(int u, int l, int r, int value) {
        if (tree[u] < value) return -1;
        if (l == r) return l;
        int mid = (l + r) >>> 1;
        if (tree[u * 2] >= value) {
            return queryFirst(u * 2, l, mid, value);
        } else {
            return queryFirst(u * 2 + 1, mid + 1, r, value);
        }
    }

    // Set basket index i to zero after using it
    public void update(int u, int l, int r, int idx, int newVal) {
        if (l == r) {
            tree[u] = newVal;
            return;
        }
        int mid = (l + r) >>> 1;
        if (idx <= mid) {
            update(u * 2, l, mid, idx, newVal);
        } else {
            update(u * 2 + 1, mid + 1, r, idx, newVal);
        }
        tree[u] = Math.max(tree[u * 2], tree[u * 2 + 1]);
    }
}

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        SegmentTree seg = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            int pos = seg.queryFirst(1, 0, n - 1, fruit);
            if (pos < 0) {
                unplaced++;
            } else {
                seg.update(1, 0, n - 1, pos, 0);
            }
        }

        return unplaced;
    }
}
