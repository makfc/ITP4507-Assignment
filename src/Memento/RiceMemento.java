package Memento;

import Stock.Rice;

public class RiceMemento implements Memento{
    private Rice rice;
    private int itemID;
    private String name;
    private int balance;
    private String type;

    public RiceMemento(Rice rice) {
        this.rice = rice;
        this.itemID = rice.getItemID();
        this.name = rice.getName();
        this.balance = rice.getBalance();
        this.type = rice.getType();
    }

    @Override
    public void restore() {
        rice.setName(name);
        rice.setBalance(balance);
        rice.setType(type);
    }

    public int getItemID() {
        return itemID;
    }
}
