package com.codecool.kitchenmanagement.models.employee;

import com.codecool.kitchenmanagement.enums.Ingredient;

import java.time.LocalDate;
import java.util.Random;

public class Cook extends Employee implements CanCook {
    public Cook(String name, LocalDate hireDate, double salary) {
        super(name, hireDate, salary);
    }

    @Override
    public void cook() {
        System.out.println("I'm cooking Chef!");
    }
}
