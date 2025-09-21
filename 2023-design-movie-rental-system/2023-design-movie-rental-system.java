import java.util.*;

public class MovieRentingSystem {

    // Helper class for available entries
    private static class Entry {
        int price;
        int shop;
        int movie;
        Entry(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
    }

    // Comparator for available entries: by price, then shop
    private Comparator<Entry> cmpAvailable = new Comparator<Entry>() {
        @Override
        public int compare(Entry a, Entry b) {
            if (a.price != b.price) {
                return Integer.compare(a.price, b.price);
            }
            return Integer.compare(a.shop, b.shop);
        }
    };

    // Comparator for rented entries: price, then shop, then movie
    private Comparator<Entry> cmpRented = new Comparator<Entry>() {
        @Override
        public int compare(Entry a, Entry b) {
            if (a.price != b.price) {
                return Integer.compare(a.price, b.price);
            }
            if (a.shop != b.shop) {
                return Integer.compare(a.shop, b.shop);
            }
            return Integer.compare(a.movie, b.movie);
        }
    };

    // Map movie -> TreeSet of available (unrented) entries
    private Map<Integer, TreeSet<Entry>> available;

    // TreeSet of rented entries
    private TreeSet<Entry> rented;

    // Map (shop, movie) pair to price
    private Map<Long, Integer> priceMap;

    // A helper to encode (shop, movie) pair into a long key, or use a pair class
    private long encode(int shop, int movie) {
        // We can assume movie <= 10^4, shop up to maybe 3e5 so fits
        // e.g. shift shop by some bits
        return (((long)shop) << 32) | (movie & 0xffffffffL);
    }

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>(cmpRented);
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0];
            int movie = e[1];
            int price = e[2];
            long key = encode(shop, movie);
            priceMap.put(key, price);

            // add to available
            available.computeIfAbsent(movie, k -> new TreeSet<>(cmpAvailable))
                     .add(new Entry(price, shop, movie));
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Entry> set = available.get(movie);
        if (set == null) return ans;
        int count = 0;
        for (Entry e : set) {
            ans.add(e.shop);
            count++;
            if (count == 5) break;
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        long key = encode(shop, movie);
        Integer price = priceMap.get(key);
        if (price == null) return;  // or throw error, based on spec
        Entry e = new Entry(price, shop, movie);

        // remove from available
        TreeSet<Entry> set = available.get(movie);
        if (set != null) {
            set.remove(e);
        }

        // add to rented
        rented.add(e);
    }

    public void drop(int shop, int movie) {
        long key = encode(shop, movie);
        Integer price = priceMap.get(key);
        if (price == null) return;
        Entry e = new Entry(price, shop, movie);

        // remove from rented
        rented.remove(e);

        // add back to available
        available.computeIfAbsent(movie, k -> new TreeSet<>(cmpAvailable))
                 .add(e);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0;
        for (Entry e : rented) {
            ans.add(Arrays.asList(e.shop, e.movie));
            count++;
            if (count == 5) break;
        }
        return ans;
    }
}
