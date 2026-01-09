class Solution {
    // Helper class to hold a pair (node, depth)
    private static class Result {
        TreeNode node;
        int depth;
        Result(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
   
    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        
        Result leftR = dfs(root.left);
        Result rightR = dfs(root.right);
        
        if (leftR.depth == rightR.depth) {
            return new Result(root, leftR.depth + 1);
        }
        
        if (leftR.depth > rightR.depth) {
            return new Result(leftR.node, leftR.depth + 1);
        } else {
            return new Result(rightR.node, rightR.depth + 1);
        }
    }
}
