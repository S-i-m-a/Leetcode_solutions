import java.util.*;

class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeMap<Integer, TreeSet<String>>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
            cuisineToFoods.putIfAbsent(cuisines[i], new TreeMap<>(Collections.reverseOrder()));
            cuisineToFoods.get(cuisines[i]).putIfAbsent(ratings[i], new TreeSet<>());
            cuisineToFoods.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);
        foodToRating.put(food, newRating);

        TreeSet<String> oldSet = cuisineToFoods.get(cuisine).get(oldRating);
        oldSet.remove(food);
        if (oldSet.isEmpty()) {
            cuisineToFoods.get(cuisine).remove(oldRating);
        }

        cuisineToFoods.get(cuisine).putIfAbsent(newRating, new TreeSet<>());
        cuisineToFoods.get(cuisine).get(newRating).add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).firstEntry().getValue().first();
    }
}
