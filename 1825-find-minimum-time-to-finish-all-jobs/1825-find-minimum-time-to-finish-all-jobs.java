import java.util.Arrays;

public class Solution {
    private int result = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] workers = new int[k];
        backtrack(jobs, jobs.length - 1, workers);
        return result;
    }

    private void backtrack(int[] jobs, int index, int[] workers) {
        if (index < 0) {
            result = Math.min(result, Arrays.stream(workers).max().getAsInt());
            return;
        }
        if (Arrays.stream(workers).max().getAsInt() >= result) {
            return;
        }
        for (int i = 0; i < workers.length; i++) {
            if (i > 0 && workers[i] == workers[i - 1]) {
                continue;
            }
            workers[i] += jobs[index];
            backtrack(jobs, index - 1, workers);
            workers[i] -= jobs[index];
        }
    }
}
