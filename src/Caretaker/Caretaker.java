package Caretaker;

import Command.*;
import Memento.*;
import Stock.FoodItem;
import Stock.Rice;
import Stock.InstantNoodle;

import java.util.Stack;
import java.util.Vector;

public class Caretaker {
    private Vector<FoodItem> foodItems;
    private Stack<StackItem> undoStack = new Stack<>();
    private Stack<StackItem> redoStack = new Stack<>();

    public void setFoodItems(Vector<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public void saveFoodItemAndCommand(FoodItem foodItem, Command command) {
        redoStack.clear();
        if (foodItem instanceof Rice) {
            saveRice((Rice) foodItem, command);
        } else if (foodItem instanceof InstantNoodle) {
            saveInstantNoodle((InstantNoodle) foodItem, command);
        }
    }

    public void saveRice(Rice rice, Command command) {
        Memento memento = new RiceMemento(rice);
        undoStack.push(new StackItem(rice, memento, command));
    }

    public void saveInstantNoodle(InstantNoodle instantNoodle, Command command) {
        Memento memento = new InstantNoodleMemento(instantNoodle);
        undoStack.push(new StackItem(instantNoodle, memento, command));
    }

    // return the FoodItem by the itemID of memento
    private FoodItem getFoodItemByID(int itemID){
        int index = -1;
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getItemID() == itemID) {
                index = foodItems.indexOf(foodItem);
            }
        }
        return foodItems.get(index);
    }

    public void undo() {
        if (undoStack.empty()) {
            System.out.println("No last undo command.");
            return;
        }

        StackItem stackItem = undoStack.pop();

        // check if it is the create food command then remove food item.
        // otherwise, restore the food item property.
        if (stackItem.getCommand() instanceof CreateFoodCommand) {
            foodItems.remove(stackItem.getFoodItem());
        }else {
            stackItem.getMemento().restore();
        }
        redoStack.push(stackItem);
        System.out.println("undo completed.");
    }

    public void redo() {
        if (redoStack.empty()) {
            System.out.println("No last redo command.");
            return;
        }

        StackItem stackItem = redoStack.pop();

        // check if it is the create food command then add food item.
        // otherwise, restore the food item property.
        if (stackItem.getCommand() instanceof CreateFoodCommand) {
            foodItems.add(stackItem.getFoodItem());
        }else {
            stackItem.getMemento().restore();
        }
        undoStack.push(stackItem);
        System.out.println("redo completed.");
    }

    public void displayUndoRedoList() {
        System.out.println("Undo List:");
        if (undoStack.empty()) {
            System.out.println("Empty");
        } else {
            undoStack.forEach(stackItem -> System.out.println(stackItem.getCommand().toString()));
        }

        System.out.println();

        System.out.println("Redo List:");
        if (redoStack.empty()) {
            System.out.println("Empty");
        } else {
            redoStack.forEach(stackItem -> System.out.println(stackItem.getCommand().toString()));
        }
    }
}
