package Memento;

import Stock.Rice;
import Stock.InstantNoodle;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();

    public void saveRice(Rice rice){
        redoStack.clear();
        undoStack.push(new RiceMemento(rice));
    }

    public void saveInstantNoodle(InstantNoodle instantNoodle){
        redoStack.clear();
        undoStack.push(new InstantNoodleMemento(instantNoodle));
    }

    public void undo(){
        undoStack.pop().restore();
    }

    public void redo(){
        redoStack.pop().restore();
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
