package com.vaibhav.snippets.BeverageMakingMachineDesign;

public interface BeverageMachine {
    Beverage createBeverage(BeverageType beverageType, String subType);
    void initializeMachine();
    void displayInventory();

}
