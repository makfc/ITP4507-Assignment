package Memento;

import Stock.FoodItem;
import Stock.Rice;
import Stock.InstantNoodle;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();

    public void saveFoodItem(FoodItem foodItem){

    }

    public void saveRice(Rice rice){
        redoStack.clear();
        undoStack.push(new RiceMemento(rice));
    }

    public void saveInstantNoodle(InstantNoodle instantNoodle){
        redoStack.clear();
        undoStack.push(new InstantNoodleMemento(instantNoodle));
    }

    public void undo(){
        Memento memento = undoStack.pop();
        memento.restore();
        redoStack.push(memento);
        System.out.println("undo completed.");
    }

    public void redo(){
        Memento memento = redoStack.pop();
        memento.restore();
        undoStack.push(memento);
        System.out.println("redo completed.");
    }

    public void displayUndoRedoList(){
        System.out.println("Undo List:");
        if (undoStack.empty()){
            System.out.println("Empty");
        } else {
            undoStack.forEach(System.out::println);
        }

        System.out.println();

        System.out.println("Redo List:");
        if (redoStack.empty()){
            System.out.println("Empty");
        } else {
            redoStack.forEach(System.out::println);
        }
    }
}
