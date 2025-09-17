import java.util.*;

public class FoodRatings {
    // Map food name -> its current rating
    private Map<String, Integer> foodToRating;
    // Map food name -> its cuisine
    private Map<String, String> foodToCuisine;
    // Map cuisine -> TreeSet of Foods (sorted by rating desc, then name asc)
    private Map<String, TreeSet<Food>> cuisineToFoods;

    // A helper class to represent a food, with rating and name
    private static class Food implements Comparable<Food> {
        int rating;
        String name;

        Food(int rating, String name) {
            this.rating = rating;
            this.name = name;
        }

        @Override
        public int compareTo(Food other) {
            // higher rating comes first
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating);
            }
            // if rating tie, lexicographically smaller name first
            return this.name.compareTo(other.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Food)) return false;
            Food other = (Food)o;
            return this.rating == other.rating && this.name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rating, name);
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);

            cuisineToFoods
                .computeIfAbsent(cuisine, c -> new TreeSet<>())
                .add(new Food(rating, food));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        TreeSet<Food> set = cuisineToFoods.get(cuisine);
        // Remove the old Food object
        set.remove(new Food(oldRating, food));
        // Update rating map
        foodToRating.put(food, newRating);
        // Add updated
        set.add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        TreeSet<Food> set = cuisineToFoods.get(cuisine);
        // first() gives the highest one by our compareTo
        return set.first().name;
    }

    // For testing
    public static void main(String[] args) {
        FoodRatings obj = new FoodRatings(
            new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
            new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
            new int[]{9, 12, 8, 15, 14, 7}
        );

        System.out.println(obj.highestRated("korean"));   // should print "kimchi"
        System.out.println(obj.highestRated("japanese")); // should print "ramen"
        obj.changeRating("sushi", 16);
        System.out.println(obj.highestRated("japanese")); // should print "sushi"
        obj.changeRating("ramen", 16);
        System.out.println(obj.highestRated("japanese")); // tie 16, lexicographically smaller -> "ramen"
    }
}
