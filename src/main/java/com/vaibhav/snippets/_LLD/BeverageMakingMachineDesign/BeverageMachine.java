package com.vaibhav.snippets._LLD.BeverageMakingMachineDesign;

public interface BeverageMachine {
    Beverage createBeverage(BeverageType beverageType, String subType);
    void initializeMachine();
    void displayInventory();

}
