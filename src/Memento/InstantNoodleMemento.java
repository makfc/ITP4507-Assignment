package Memento;

import Stock.InstantNoodle;

public class InstantNoodleMemento implements Memento {
    private InstantNoodle instantNoodle;
    private String name;
    private int balance;
    private int weight;

    public InstantNoodleMemento(InstantNoodle instantNoodle) {
        this.instantNoodle = instantNoodle;
        this.name = instantNoodle.getName();
        this.balance = instantNoodle.getBalance();
        this.weight = instantNoodle.getWeight();
    }

    @Override
    public void restore() {
        instantNoodle.setName(name);
        instantNoodle.setBalance(balance);
        instantNoodle.setWeight(weight);
    }
}
