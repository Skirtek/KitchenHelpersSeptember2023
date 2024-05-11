package com.codecool.kitchenmanagement.models.employee;

import com.codecool.kitchenmanagement.enums.Ingredient;
import com.codecool.kitchenmanagement.models.Kitchen;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

public class Chef extends Employee implements CanCook {
    private Kitchen kitchen;

    private static final Random RANDOM = new Random();

    public Chef(String name, LocalDate hireDate, double salary) {
        super(name, hireDate, salary);
    }

    @Override
    public void cook() {
        boolean isRequestingIngredients = RANDOM.nextBoolean();

        if (isRequestingIngredients) {
            Ingredient randomIngredient = Ingredient.getRandomIngredient();
            System.out.println("I need " + randomIngredient.toString());

            Optional<Ingredient> requestedIngredient = kitchen.requestIngredient(randomIngredient);
            //String answer = requestedIngredient.get() != null ? requestedIngredient.get().toString() : "nothing";
            String answer = requestedIngredient.map(Ingredient::toString).orElse("nothing");
            System.out.println("I've got " + answer);
        } else {
            System.out.println("Are you cooking guys?");
        }
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
