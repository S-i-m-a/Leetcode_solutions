import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        // Process each description
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            // Get or create parent and child nodes
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = nodeMap.get(parentVal);
            TreeNode child = nodeMap.get(childVal);

            // Assign the child to the correct side
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            // Track that this node is a child
            children.add(childVal);
        }

        // Find the root node (a node that is not a child)
        for (int val : nodeMap.keySet()) {
            if (!children.contains(val)) {
                return nodeMap.get(val);
            }
        }

        return null; // Shouldn't happen as per the problem constraints
    }
}
