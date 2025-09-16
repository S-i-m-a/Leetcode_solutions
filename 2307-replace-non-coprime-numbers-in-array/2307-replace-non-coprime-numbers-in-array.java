import java.util.*;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        // We use an ArrayList as stack-like structure
        List<Integer> stack = new ArrayList<>();
        
        for (int num : nums) {
            // push current number
            stack.add(num);
            // while top two are non-coprime, merge them
            while (stack.size() > 1) {
                int last = stack.get(stack.size() - 1);
                int secondLast = stack.get(stack.size() - 2);
                int g = gcd(last, secondLast);
                if (g == 1) {
                    break;  // they are coprime, stop merging
                }
                // if non-coprime, compute LCM and replace them
                long lcm = lcm(secondLast, last, g);
                // remove the last
                stack.remove(stack.size() - 1);
                // replace second last with the LCM (cast to int; safe under constraints)
                stack.set(stack.size() - 1, (int) lcm);
            }
        }
        
        return stack;
    }
    
    // gcd using Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    // compute LCM safely using known GCD
    private long lcm(int a, int b, int gcd) {
        // To avoid overflow, divide first then multiply
        // LCM(a,b) = (a / gcd) * b
        return (long)a / gcd * b;
    }
    
    // Overloaded if you don't want to pass gcd
    private long lcm(int a, int b) {
        int g = gcd(a, b);
        return (long)a / g * b;
    }
}
