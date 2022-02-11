package com.vaibhav.snippets.BeverageMakingMachineDesign;

abstract class Tea extends Beverage{

    Tea(){
        super.beverageName = "tea";
        super.beverageTemperature = BeverageTemperature.HOT;
        super.ingridients.put(Ingridient.WATER, 10);
    }
}
