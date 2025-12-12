class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // Sort events by timestamp, and if timestamps are equal, sort by event type
        // "MESSAGE" (M) comes before "OFFLINE" (O) based on ASCII values
        events.sort((a, b) -> {
            int timestampA = Integer.parseInt(a.get(1));
            int timestampB = Integer.parseInt(b.get(1));
            if (timestampA == timestampB) {
                // Sort by the third character of event type to prioritize MESSAGE over OFFLINE
                return a.get(0).charAt(2) - b.get(0).charAt(2);
            }
            return timestampA - timestampB;
        });
      
        // Array to store mention count for each user
        int[] mentionCounts = new int[numberOfUsers];
      
        // Array to track when each user will be online until (offline time + 60)
        int[] onlineUntilTime = new int[numberOfUsers];
      
        // Counter for "ALL" mentions that will be applied to all users at the end
        int allMentionsCount = 0;
      
        // Process each event in chronological order
        for (List<String> event : events) {
            String eventType = event.get(0);
            int currentTime = Integer.parseInt(event.get(1));
            String content = event.get(2);
          
            if (eventType.charAt(0) == 'O') {
                // OFFLINE event: user goes offline but can receive mentions for 60 more time units
                int userId = Integer.parseInt(content);
                onlineUntilTime[userId] = currentTime + 60;
            } else if (content.charAt(0) == 'A') {
                // MESSAGE with "ALL": increment lazy counter to apply to all users later
                allMentionsCount++;
            } else if (content.charAt(0) == 'H') {
                // MESSAGE with "HERE": mention all currently online users
                for (int i = 0; i < numberOfUsers; i++) {
                    if (onlineUntilTime[i] <= currentTime) {
                        // User is online (their offline time + 60 has passed or they never went offline)
                        mentionCounts[i]++;
                    }
                }
            } else {
                // MESSAGE with specific user IDs: parse and mention each user
                String[] userIds = content.split(" ");
                for (String userIdStr : userIds) {
                    // Extract user ID from format "id123" by removing first 2 characters
                    int userId = Integer.parseInt(userIdStr.substring(2));
                    mentionCounts[userId]++;
                }
            }
        }
      
        // Apply all "ALL" mentions to every user
        if (allMentionsCount > 0) {
            for (int i = 0; i < numberOfUsers; i++) {
                mentionCounts[i] += allMentionsCount;
            }
        }
      
        return mentionCounts;
    }
}
