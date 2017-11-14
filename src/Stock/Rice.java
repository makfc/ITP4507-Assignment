package Stock;

public class Rice extends FoodItem {
    private String type;

    public Rice(int itemID, String name, String type) {
        super(itemID, name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Type: " + getType() + '\n';
    }
}
