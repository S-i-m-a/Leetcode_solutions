import java.util.*;

class Router {
    private static class TrieNode {
        Map<String, TrieNode> children;
        boolean isEndpoint;
        String handler;

        TrieNode() {
            children = new HashMap<>();
            isEndpoint = false;
            handler = null;
        }
    }

    private final TrieNode root;

    public Router() {
        root = new TrieNode();
    }

    public void add(String path, String handler) {
        // Normalize the path, strip leading/trailing slashes
        String[] parts = normalize(path);
        TrieNode cur = root;
        for (String part : parts) {
            if (!cur.children.containsKey(part)) {
                cur.children.put(part, new TrieNode());
            }
            cur = cur.children.get(part);
        }
        cur.isEndpoint = true;
        cur.handler = handler;
    }

    public String route(String requestPath) {
        String[] parts = normalize(requestPath);
        TrieNode cur = root;
        for (String part : parts) {
            if (!cur.children.containsKey(part)) {
                return "404";
            }
            cur = cur.children.get(part);
        }
        return cur.isEndpoint ? cur.handler : "404";
    }

    private String[] normalize(String path) {
        if (path == null || path.isEmpty()) {
            return new String[0];
        }
        // Remove leading and trailing slashes
        path = path.trim();
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        if (path.isEmpty()) {
            return new String[0];
        }
        return path.split("/");
    }
}
