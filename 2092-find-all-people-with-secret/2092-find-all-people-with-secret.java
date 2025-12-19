import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Track who knows the secret
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true; // firstPerson learns at time 0

        // Sort meetings by meeting time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];

            // Build graph for all meetings at this time
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> peopleAtThisTime = new HashSet<>();

            int j = i;
            while (j < meetings.length && meetings[j][2] == time) {
                int a = meetings[j][0];
                int b = meetings[j][1];

                graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);

                peopleAtThisTime.add(a);
                peopleAtThisTime.add(b);
                j++;
            }

            // BFS from people who already know the secret
            Deque<Integer> queue = new ArrayDeque<>();
            for (int person : peopleAtThisTime) {
                if (knowsSecret[person]) {
                    queue.offer(person);
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                List<Integer> neighbors = graph.getOrDefault(curr, Collections.emptyList());
                for (int neighbor : neighbors) {
                    if (!knowsSecret[neighbor]) {
                        knowsSecret[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            i = j; // Move to next time group
        }

        // Collect all people who know the secret
        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (knowsSecret[p]) {
                result.add(p);
            }
        }
        return result;
    }
}
