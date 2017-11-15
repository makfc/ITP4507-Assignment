package Memento;

import Stock.Rice;

public interface Memento {
    public void restore();
    public int getItemID(); // for food item creation undo/redo
}
