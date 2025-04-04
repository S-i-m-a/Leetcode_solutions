import java.util.*;

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> totalViews = new HashMap<>();
        Map<String, String> topVideo = new HashMap<>();
        Map<String, Integer> topVideoViews = new HashMap<>();

        long maxViews = 0;

        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String video = ids[i];
            int view = views[i];

            totalViews.put(creator, totalViews.getOrDefault(creator, 0L) + view);
            maxViews = Math.max(maxViews, totalViews.get(creator));

            if (!topVideo.containsKey(creator) || 
                view > topVideoViews.get(creator) || 
                (view == topVideoViews.get(creator) && video.compareTo(topVideo.get(creator)) < 0)) {
                topVideo.put(creator, video);
                topVideoViews.put(creator, view);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, Long> entry : totalViews.entrySet()) {
            if (entry.getValue() == maxViews) {
                result.add(Arrays.asList(entry.getKey(), topVideo.get(entry.getKey())));
            }
        }
        return result;
    }
}
