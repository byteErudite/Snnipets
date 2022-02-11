package com.vaibhav.snippets.BeverageMakingMachineDesign;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverClass {


    public static void main(String[] args) {
        DriverClass d = new DriverClass();
        d.startMachine();
    }

    private void startMachine() {
        System.out.println("Machine started");
        BeverageMachine machine = new BeverageMachineImpl();
        machine.initializeMachine();
        machine.displayInventory();
        machine.createBeverage(BeverageType.TEA, "green");
        machine.displayInventory();
    }


}
