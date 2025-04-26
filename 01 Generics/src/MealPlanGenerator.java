import java.util.function.Supplier;

// Interface
public interface MealPlan {
    String getMealDetails();
}

// Meal Types
class VegetarianMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegetarian Meal: Lentil curry with brown rice.";
    }
}

class VeganMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegan Meal: Tofu stir-fry with quinoa.";
    }
}

class KetoMeal implements MealPlan {
    public String getMealDetails() {
        return "Keto Meal: Grilled chicken with avocado salad.";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealDetails() {
        return "High-Protein Meal: Steak with sweet potato mash.";
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void showMeal() {
        System.out.println(meal.getMealDetails());
    }

    public T getMeal() {
        return meal;
    }
}

// Generator with Supplier<T>
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(Supplier<T> mealSupplier) {
        T meal = mealSupplier.get();
        return new Meal<>(meal);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generateMealPlan(VegetarianMeal::new);
        vegetarianMeal.showMeal();

        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(VeganMeal::new);
        veganMeal.showMeal();

        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(KetoMeal::new);
        ketoMeal.showMeal();

        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(HighProteinMeal::new);
        highProteinMeal.showMeal();
    }
}
