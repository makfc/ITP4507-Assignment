package Memento;

public interface Memento {
    public void restore();
    public int getItemID(); // for food item creation undo/redo
}
