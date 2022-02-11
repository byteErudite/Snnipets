package com.vaibhav.snippets.BeverageMakingMachineDesign;

public class LemonTea extends Tea {
    LemonTea() {
        super.beverageType = "lemon tea";
        super.ingridients.put(Ingridient.LEMON, 10);
    }
}
