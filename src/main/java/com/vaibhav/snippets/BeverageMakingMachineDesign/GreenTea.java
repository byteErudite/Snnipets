package com.vaibhav.snippets.BeverageMakingMachineDesign;

public class GreenTea extends Tea{
    GreenTea() {
        super.beverageType = "green tea";
        super.ingridients.put(Ingridient.TEA_BAG, 1);
    }
}
