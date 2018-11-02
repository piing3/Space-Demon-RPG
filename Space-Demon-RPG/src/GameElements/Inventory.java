package GameElements;

import java.util.LinkedList;

/**
 * Author: Davin Holmberg
 * 
 */
class Inventory {

    private final LinkedList<Item> inventory = new LinkedList<>();
    private final LinkedList<Integer> inventoryCount = new LinkedList<>();

    public Inventory() {
    }
    /**
     * Gets the Item at the index n. Returns Item.ERROR if out of bounds. 
     * @param n The index of the Item.
     * @return The Item at index n.
     */
    public Item getItem(int n) {
        if(outOfBounds(n)) return Item.ERROR;
        return inventory.get(n);
    }
    
    /**
     * Gets the number of Items at index n. Returns -1 if out of bounds. 
     * @param n The index of the Item.
     * @return The number of Items at index n. 
     */
    public int getItemCount(int n) {
        if(outOfBounds(n)) return -1;
        return inventoryCount.get(n);
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public int getItemCount (Item i){
        int n = findItem(i);
        if (n >= 0) {
            return inventoryCount.get(n);
        }
        else return 0;
        
    }
    
    public void removeItem(int n) {
        if(outOfBounds(n)) return;
        
        int c = inventoryCount.get(n);
        inventoryCount.set(n, c - 1);
        if (c <= 1) {
            inventoryCount.remove(n);
            inventory.remove(n);
        }
    }
    
    public void removeItem(Item i) {
        int n = findItem(i);
        if (n >= 0) removeItem(n);
    }
    
    public void removeItem(int n, int delta) {
        if (inventoryCount.get(n) >= delta){
            for (int i = 0; i < delta; i++) {
                removeItem(n);
            }
        } 
        else{
            for (int i = 0; i < inventoryCount.get(n); i++) {
                removeItem(n);
            }
        }
    }
    
    public void removeItem(Item i, int delta) {
        int n = findItem(i);
        if (n >= 0) removeItem(n, delta);
    }
    
    public void addItem(int n){
        addItem(n, 1);
    }
    
    public void addItem(Item i, int delta){
        int n = findItem(i);
        if (n >= 0) addItem(n, delta);
        else{
            inventoryCount.add(delta);
            inventory.add(i);
        }
    }
    
    public void addItem(int n, int delta){
        if(outOfBounds(n)) return;
        int c = inventoryCount.get(n);
        inventoryCount.set(n, c+delta);
    }
    
    public void addItem(Item i){
        int n = findItem(i);
        if (n >= 0) addItem(n);
        else{
            inventoryCount.add(1);
            inventory.add(i);
        }
    }
    
    public boolean hasItem(Item i){
        int n = findItem(i);
        if (n >= 0) return true;
        else return false;
    }
    
    private int findItem(Item i){
        for (int j = 0; j < inventory.size(); j++) {
            if (inventory.get(j).equals(i)) return j; 
        }
        return -1;
    }
    
    private boolean outOfBounds(int n){
        return (n < inventory.size()) && (n >= 0);
    }
}
