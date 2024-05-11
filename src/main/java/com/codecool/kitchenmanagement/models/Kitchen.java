package com.codecool.kitchenmanagement.models;

import com.codecool.kitchenmanagement.enums.Ingredient;
import com.codecool.kitchenmanagement.models.employee.Chef;
import com.codecool.kitchenmanagement.models.employee.Cook;
import com.codecool.kitchenmanagement.models.employee.Employee;
import com.codecool.kitchenmanagement.models.employee.KitchenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Kitchen {
    private Chef chef;
    private final List<Cook> cooks = new ArrayList<>();
    private final List<KitchenHelper> kitchenHelpers = new ArrayList<>();

    public Optional<Ingredient> requestIngredient(Ingredient ingredient) {
        for (KitchenHelper helper : kitchenHelpers) {
            Optional<Ingredient> helperIngredient = helper.giveIngredient(ingredient);

            if (helperIngredient.isPresent()) {
                return helperIngredient;
            }
        }

        System.out.println("Helpers: We are all out.");
        System.out.println("Chef: Yes, go out!");

        return Optional.empty();
    }

    public void hireEmployee(Employee employee) {
        if (employee instanceof Cook cook) {
            cooks.add(cook);
        }

        if (employee instanceof KitchenHelper helper) {
            kitchenHelpers.add(helper);
        }

        if (employee instanceof Chef chef) {
            hireChef(chef);
        }
    }

    public void startShift() {
        for (KitchenHelper helper : kitchenHelpers) {
            helper.addIngredients();
        }

        if (chef != null) {
            for (Cook cook : cooks) {
                cook.cook();
            }

            chef.cook();
        } else {
            throw new IllegalArgumentException("No chef on shift");
        }
    }

    private void hireChef(Chef chef) {
        if (chef != null) {
            fireChef();
        }

        this.chef = chef;
        this.chef.setKitchen(this);
    }

    private void fireChef() {
        this.chef = null;
    }
}
