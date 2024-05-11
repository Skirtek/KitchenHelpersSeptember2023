package com.codecool.kitchenmanagement.models.employee;

import com.codecool.kitchenmanagement.enums.Ingredient;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class KitchenHelper extends Employee {
    private static final int MAX_NUMBER_OF_INGREDIENTS = 3;
    private static final Random RANDOM = new Random();

    // Meat: 0
    // Potato: 1
    // Carrot: 2
    private Map<Ingredient, Integer> helperIngredients = new HashMap<>();

    public KitchenHelper(String name, LocalDate hireDate, double salary) {
        super(name, hireDate, salary);

        for (Ingredient ingredient : Ingredient.values()) {
            helperIngredients.put(ingredient, 0);
        }
    }

    public void addIngredients() {
        for (Ingredient ingredient : Ingredient.values()) {
            int maxIngredientAmount = RANDOM.nextInt(MAX_NUMBER_OF_INGREDIENTS + 1);
            helperIngredients.merge(ingredient, maxIngredientAmount, Math::max);
        }
    }

    public Optional<Ingredient> giveIngredient(Ingredient ingredient) {
        boolean hasIngredient = helperIngredients.get(ingredient) > 0;

        if (hasIngredient) {
            deleteIngredient(ingredient);
            return Optional.of(ingredient);
        }

        return Optional.empty();
    }

    private void deleteIngredient(Ingredient ingredient) {
        Integer currentValue = helperIngredients.get(ingredient);
        helperIngredients.replace(ingredient, currentValue - 1);
    }
}
