import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        
        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }
        
        return result;
    }
    
    private boolean isSelfDividing(int num) {
        int originalNum = num;
        
        while (num > 0) {
            int digit = num % 10;  // Extract the last digit
            num /= 10;  // Remove the last digit
            
            if (digit == 0 || originalNum % digit != 0) {
                return false;  // If digit is 0 or not divisible, return false
            }
        }
        
        return true;  // If all digits divide the number, return true
    }
}
