import java.util.*;

class RangeFreqQuery {
    Map<Integer, List<Integer>> m = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            m.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
    }

    public int query(int l, int r, int v) {
        List<Integer> a = m.get(v);
        if (a == null) return 0;
        return bs(a, r + 1) - bs(a, l);
    }

    int bs(List<Integer> a, int x) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (a.get(m) < x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
