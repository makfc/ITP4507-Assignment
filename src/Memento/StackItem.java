package Memento;

import Command.*;
import Stock.FoodItem;

public class StackItem {
    private FoodItem foodItem; // for redo create food item
    private Memento memento;
    private Command command; // for display command list

    public StackItem(FoodItem foodItem, Memento memento, Command command) {
        this.foodItem = foodItem;
        this.memento = memento;
        this.command = command;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
