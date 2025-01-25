import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] requiredSkills, List<List<String>> people) {
        Map<String, Integer> skillIndex = new HashMap<>();
        int skillCount = requiredSkills.length;
        int peopleCount = people.size();
        for (int i = 0; i < skillCount; ++i) {
            skillIndex.put(requiredSkills[i], i);
        }

        int[] peopleSkills = new int[peopleCount];
        for (int i = 0; i < peopleCount; ++i) {
            for (String skill : people.get(i)) {
                peopleSkills[i] |= 1 << skillIndex.get(skill);
            }
        }

        final int INF = 1 << 30;
        int[] dp = new int[1 << skillCount];
        int[] lastPersonAdded = new int[1 << skillCount];
        int[] lastState = new int[1 << skillCount];
      
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int state = 0; state < (1 << skillCount); ++state) {
            if (dp[state] == INF) {
                continue;
            }

            for (int j = 0; j < peopleCount; ++j) {
                int newState = state | peopleSkills[j];
                if (dp[state] + 1 < dp[newState]) {
                    dp[newState] = dp[state] + 1;
                    lastPersonAdded[newState] = j;
                    lastState[newState] = state;
                }
            }
        }

        List<Integer> team = new ArrayList<>();
        for (int state = (1 << skillCount) - 1; state != 0; state = lastState[state]) {
            team.add(lastPersonAdded[state]);
        }
        return team.stream().mapToInt(Integer::intValue).toArray();
    }
}
