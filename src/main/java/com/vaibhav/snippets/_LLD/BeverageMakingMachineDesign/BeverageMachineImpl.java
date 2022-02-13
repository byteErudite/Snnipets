package com.vaibhav.snippets._LLD.BeverageMakingMachineDesign;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeverageMachineImpl implements BeverageMachine{

    Map<Ingridient, Integer> inventory = new HashMap<>();
    @Override
    public Beverage createBeverage(BeverageType beverageType, String subType) {
        switch (beverageType) {
            case TEA:
                System.out.println("Staring to make your tea");
                Beverage tea = getSubTeaType(subType);
                updateInventory(tea);
                System.out.println("tea is ready ....");
                System.out.println(tea.getInfo());
                return tea;
            case COFFEE:
        }
        return null;
    }

    @Override
    public void initializeMachine() {
        poplulateInventory();
    }

    @Override
    public void displayInventory() {
        inventory.forEach(((ingridient, amount) -> {
            System.out.println(ingridient+" : "+amount);
        }));
    }

    private void poplulateInventory() {
        Arrays.stream(Ingridient.values()).forEach(i-> {
            inventory.put(i, 100);
        });
    }

    private Tea getSubTeaType(String subType) {
        switch (subType) {
            case "green" : return new GreenTea();
            case "lemon" : return new LemonTea();
        }
        return null;
    }

    private void updateInventory(Beverage beverage) {
        beverage.ingridients.forEach((ingr, amount) -> {
            if (inventory.containsKey(ingr)) {
                inventory.put(ingr, inventory.get(ingr) - amount);
            }
        });
    }
}
