package com.codecool.kitchenmanagement.enums;

import java.util.Random;

public enum Ingredient {
    MEAT,
    POTATO,
    CARROT;

   private final static Random RANDOM = new Random();

    public static Ingredient getRandomIngredient() {
        Ingredient[] values = values();

        int ingredientTypesAmount = values.length;

        return values[RANDOM.nextInt(ingredientTypesAmount)];
    }
}
