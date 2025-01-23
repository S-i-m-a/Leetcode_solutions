class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;  // Initial value of x
        
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                x++;
            } else if (operation.equals("--X") || operation.equals("X--")) {
                x--;
            }
        }
        
        return x;  // Return the final value of x
    }
}
