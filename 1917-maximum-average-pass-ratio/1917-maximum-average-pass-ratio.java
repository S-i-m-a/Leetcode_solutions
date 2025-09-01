import java.util.PriorityQueue;

class Solution {
    private static class ClassData {
        double delta; // Potential improvement by adding one student
        int pass, total;
        ClassData(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.delta = computeDelta(pass, total);
        }
        void addStudent() {
            pass++;
            total++;
            delta = computeDelta(pass, total);
        }
        private static double computeDelta(int pass, int total) {
            return (pass + 1.0) / (total + 1.0) - (pass * 1.0 / total);
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassData> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.delta, a.delta)
        );

        for (int[] cls : classes) {
            pq.offer(new ClassData(cls[0], cls[1]));
        }

        while (extraStudents-- > 0) {
            ClassData top = pq.poll();
            top.addStudent();
            pq.offer(top);
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            ClassData c = pq.poll();
            sum += (c.pass * 1.0 / c.total);
        }

        return sum / classes.length;
    }
}
