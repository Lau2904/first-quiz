package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
  
    private static final Map<String, Integer> DRINK_PRICES;
    private static final Map<String, Boolean> DRINK_FIZZINESS;
    
    private int insertedMoney;
  
    static {
        DRINK_PRICES = new HashMap<>();
        DRINK_PRICES.put("ScottCola", 75);
        DRINK_PRICES.put("KarenTea", 100);
        
        DRINK_FIZZINESS = new HashMap<>();
        DRINK_FIZZINESS.put("ScottCola", true);
        DRINK_FIZZINESS.put("KarenTea", false);
    }

    private VendingMachineImpl() {
        insertedMoney = 0;
    }

    public static VendingMachine getInstance() {
        return new VendingMachineImpl();
    }

    @Override
    public void insertQuarter() {
        insertedMoney += 25;
    }

    @Override
    public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
        if (!DRINK_PRICES.containsKey(name)) {
            throw new UnknownDrinkException("Unknown drink: " + name);
        }
        
        int price = DRINK_PRICES.get(name);
        
        if (insertedMoney < price) {
            throw new NotEnoughMoneyException("Insufficient funds for " + name);
        }
        
        insertedMoney -= price;
        
        return new Drink(name, DRINK_FIZZINESS.get(name));
    }
}

