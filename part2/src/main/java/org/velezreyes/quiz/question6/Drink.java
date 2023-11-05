package org.velezreyes.quiz.question6;

public class Drink {
    private String name;
    private boolean fizzy;

    public Drink(String name, boolean fizzy) {
        this.name = name;
        this.fizzy = fizzy;
    }

    public String getName() {
        return name;
    }

    public boolean isFizzy() {
        return fizzy;
    }
}