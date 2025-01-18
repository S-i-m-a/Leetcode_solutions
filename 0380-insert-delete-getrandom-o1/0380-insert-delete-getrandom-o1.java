import java.util.*;

public class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    // Insert a value into the set
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }
    
    // Delete a value from the set
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        // Get the index of the element to delete
        int index = map.get(val);
        
        // Swap the last element with the element to be removed
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        
        // Remove the last element
        list.remove(list.size() - 1);
        map.remove(val);
        
        return true;
    }
    
    // Get a random element from the set
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
