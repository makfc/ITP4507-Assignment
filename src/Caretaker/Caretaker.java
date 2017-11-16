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

    // get the corresponding Memento of FoodItem
    public Memento getMemento(FoodItem foodItem){
        if (foodItem instanceof Rice) {
            return new RiceMemento((Rice) foodItem);
        } else if (foodItem instanceof InstantNoodle) {
            return new InstantNoodleMemento((InstantNoodle) foodItem);
        }
        return null;
    }

    public void saveCurrentState(FoodItem foodItem, Command command) {
        redoStack.clear();

        // save the current state of foodItem
        Memento memento = getMemento(foodItem);
        undoStack.push(new StackItem(foodItem, memento, command));
    }

    public void undo() {
        if (undoStack.empty()) {
            System.out.println("No last undo command.");
            return;
        }

        // get the last undo command
        StackItem stackItem = undoStack.pop();

        // check if it is the create food command then remove food item.
        // otherwise, restore the food item property.
        if (stackItem.getCommand() instanceof CreateFoodCommand) {
            foodItems.remove(stackItem.getFoodItem());
        }else {
            // save the current state of the last undo foodItem
            Memento memento = getMemento(stackItem.getFoodItem());

            stackItem.getMemento().restore();

            // for the later redo operation,
            // we need to set the Memento to the new Memento
            // which is before the restore
            stackItem.setMemento(memento);
        }
        redoStack.push(stackItem);
        System.out.println("undo completed.");
    }

    public void redo() {
        if (redoStack.empty()) {
            System.out.println("No last redo command.");
            return;
        }

        // get the last redo command
        StackItem stackItem = redoStack.pop();

        // check if it is the create food command then add food item.
        // otherwise, restore the food item property.
        if (stackItem.getCommand() instanceof CreateFoodCommand) {
            foodItems.add(stackItem.getFoodItem());
        }else {
            // save the current state of the last redo foodItem
            Memento memento = getMemento(stackItem.getFoodItem());

            stackItem.getMemento().restore();

            // for the later undo operation,
            // we need to set the Memento to the new Memento
            // which is before the restore
            stackItem.setMemento(memento);
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
