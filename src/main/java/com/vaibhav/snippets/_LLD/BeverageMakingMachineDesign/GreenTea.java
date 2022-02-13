package com.vaibhav.snippets._LLD.BeverageMakingMachineDesign;

public class GreenTea extends Tea{
    GreenTea() {
        super.beverageType = "green tea";
        super.ingridients.put(Ingridient.TEA_BAG, 1);
    }
}
