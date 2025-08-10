import java.util.Arrays;

public class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] target = String.valueOf(n).toCharArray();
        Arrays.sort(target);
        for (int i = 0; i < 30; i++) {
            char[] power = String.valueOf(1 << i).toCharArray();
            Arrays.sort(power);
            if (Arrays.equals(target, power)) {
                return true;
            }
        }
        return false;
    }
}
