class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;  // initial value
        
        for (String op : operations) {
            // Check the middle character (at index 1) to decide if it is a '+' or '-'
            if (op.charAt(1) == '+') {
                X += 1;
            } else {
                X -= 1;
            }
        }
        
        return X;
    }
}
