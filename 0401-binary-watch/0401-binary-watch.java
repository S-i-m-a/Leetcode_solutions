import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        
        // Iterate over all possible hour values (0 to 11) and minute values (0 to 59)
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Count the number of 1 bits in the binary representation of hour + minute
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    // Format the time as "h:mm"
                    result.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1: num = 1 (1 LED on)
        List<String> result1 = solution.readBinaryWatch(1);
        System.out.println(result1);  // Expected output: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
        
        // Test case 2: num = 2 (2 LEDs on)
        List<String> result2 = solution.readBinaryWatch(2);
        System.out.println(result2);  // Output will contain all valid times with exactly 2 LEDs on
    }
}
