package de.filipzocktan;


public class Inventory {

    private InventoryItem[] contents;

    public Inventory(int size) {
        this.contents = new InventoryItem[size];
    }

    public Inventory(int size, InventoryItem[] oldContents){
        this(size);
        for (int i = 0; i<contents.length;i++){
            contents[i] = oldContents[i];
        }
    }

    public InventoryItem[] getContents() {
        return contents;
    }
}
