class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // 1. Sort all paths lexicographically so that any subfolder follows its parent
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        // 2. Track the last added (i.e., last parent) folder
        String prev = "";

        for (String f : folder) {
            // If this folder is a subfolder of 'prev', skip it
            if (!prev.isEmpty() && f.startsWith(prev) && f.charAt(prev.length()) == '/') {
                continue;
            }
            // Otherwise, it's a new top-level folder — add it
            result.add(f);
            prev = f;
        }

        return result;
    }
}
