import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private List<Integer> perfectSubtreeSizes = new ArrayList<>();

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        postOrderTraversal(root);
        Collections.sort(perfectSubtreeSizes, Collections.reverseOrder());
        return perfectSubtreeSizes.size() >= k ? perfectSubtreeSizes.get(k - 1) : -1;
    }

    private int[] postOrderTraversal(TreeNode node) {
        if (node == null) {
            return new int[]{0, 1}; // {height, isPerfect}
        }

        int[] left = postOrderTraversal(node.left);
        int[] right = postOrderTraversal(node.right);

        int height = Math.max(left[0], right[0]) + 1;
        boolean isPerfect = left[1] == 1 && right[1] == 1 && left[0] == right[0];

        if (isPerfect) {
            int size = (1 << height) - 1; // Size of a perfect binary tree of given height
            perfectSubtreeSizes.add(size);
            return new int[]{height, 1};
        } else {
            return new int[]{height, 0};
        }
    }
}
