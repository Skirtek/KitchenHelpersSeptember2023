package com.codecool.kitchenmanagement;

import com.codecool.kitchenmanagement.models.Kitchen;
import com.codecool.kitchenmanagement.models.employee.Chef;
import com.codecool.kitchenmanagement.models.employee.Cook;
import com.codecool.kitchenmanagement.models.employee.Employee;
import com.codecool.kitchenmanagement.models.employee.KitchenHelper;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        LocalDate hireDate = LocalDate.now();

        Chef chef = new Chef("Paweł", hireDate, 2345);

        Cook cook = new Cook("Jan", hireDate, 1350);
        Cook secondCook = new Cook("Przemysław", hireDate, 1211);

        KitchenHelper firstHelper = new KitchenHelper("Michał", hireDate, 900);
        KitchenHelper secondHelper = new KitchenHelper("Damian", hireDate, 800);
        KitchenHelper thirdHelper = new KitchenHelper("Krzysztof", hireDate, 700);

        List<Employee> employeeList = List.of(chef, cook, secondCook, firstHelper, secondHelper, thirdHelper);
        employeeList.forEach(kitchen::hireEmployee);
        kitchen.startShift();
    }
}
