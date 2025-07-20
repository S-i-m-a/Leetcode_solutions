import java.util.*;

class Solution {
    // Trie node representing each folder
    private static class Node {
        String name;
        boolean deleted = false;
        Map<String, Node> children = new HashMap<>();

        Node(String name) {
            this.name = name;
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");  // dummy root

        // Step 1: Build folder Trie from all paths
        for (List<String> path : paths) {
            Node curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Node(folder));
                curr = curr.children.get(folder);
            }
        }

        // Step 2: Serialize subtrees and count occurrences
        Map<String, Integer> freq = new HashMap<>();
        serialize(root, freq);

        // Step 3: Mark all nodes with duplicate subtrees for deletion
        markDeleted(root, freq);

        // Step 4: Collect remaining paths via DFS
        List<List<String>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), result);
        return result;
    }

    // Builds a unique serialization for each node's subtree
    private String serialize(Node node, Map<String, Integer> freq) {
        if (node.children.isEmpty()) {
            // Leaf nodes: no children => no serialization tracked
            return "";
        }
        List<String> parts = new ArrayList<>();
        for (Map.Entry<String, Node> e : node.children.entrySet()) {
            String childSerial = serialize(e.getValue(), freq);
            parts.add(e.getKey() + "(" + childSerial + ")");
        }
        Collections.sort(parts);
        String serial = String.join("", parts);
        freq.put(serial, freq.getOrDefault(serial, 0) + 1);
        return serial;
    }

    // Marks nodes whose subtree serialization appears more than once
    private void markDeleted(Node node, Map<String, Integer> freq) {
        for (Node child : node.children.values()) {
            markDeleted(child, freq);
        }
        // For non-leaf nodes, re-compute the serial and check frequency
        if (!node.children.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            List<String> keys = new ArrayList<>(node.children.keySet());
            Collections.sort(keys);
            for (String k : keys) {
                sb.append(k).append("(")
                  .append(serialize(node.children.get(k), freq))
                  .append(")");
            }
            String serial = sb.toString();
            if (freq.getOrDefault(serial, 0) > 1) {
                node.deleted = true;
            }
        }
    }

    // DFS collecting paths, skipping deleted subtrees
    private void collect(Node node, List<String> curr, List<List<String>> res) {
        for (Node child : node.children.values()) {
            if (child.deleted) continue;
            curr.add(child.name);
            res.add(new ArrayList<>(curr));
            collect(child, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
